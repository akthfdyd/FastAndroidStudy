package kr.co.saramin.fastandroidstudy

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.transition.Slide
import android.transition.Transition
import android.transition.TransitionManager
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.webkit.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_web_view.*
import java.net.URI


class WebViewActivity : AppCompatActivity() {

    var webViewList: ArrayList<WebView>? = null


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        WebView.setWebContentsDebuggingEnabled(true)

        setListener()

        settingWebView(webView)

        webViewList = ArrayList()
        webViewList?.add(webView)
        refreshWebViewCount()

        webView.loadUrl(intent.extras?.getString("link"))
    }

    private fun setListener() {
        urlBar.setOnEditorActionListener { view, actionId, event ->
            var handled = false
            if (actionId == EditorInfo.IME_ACTION_GO) {
                getTopWebView()?.loadUrl(view.text.toString())
                handled = true
            }
            handled
        }
        prevButton.setOnClickListener {
            getTopWebView()?.goBack()
        }
        nextButton.setOnClickListener {
            getTopWebView()?.goForward()
        }
        reloadButton.setOnClickListener {
            getTopWebView()?.reload()
        }
        homeButton.setOnClickListener {
            getTopWebView()?.loadUrl(intent.extras?.getString("link"))
            getTopWebView()?.clearHistory()
        }
        sendButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(getTopWebView()?.url)))
        }
    }

    private fun getTopWebView() = webViewList?.get(webViewList!!.size - 1)

    @SuppressLint("SetJavaScriptEnabled")
    private fun settingWebView(view: WebView) {
        view.settings.javaScriptEnabled = true
        view.settings.javaScriptCanOpenWindowsAutomatically = true
        view.settings.setSupportMultipleWindows(true)
        view.webViewClient = CustomWebViewClient()
        view.webChromeClient = CustomWebChromeClient()
    }

    override fun onBackPressed() {
        val viewNumber = webViewList!!.size - 1

        if (webViewList?.get(viewNumber)?.canGoBack()!!) {
            webViewList!![viewNumber].goBack()

        } else if (webViewList!!.size > 1) {

//            val transitionType: Transition = Slide(Gravity.BOTTOM)
//            TransitionManager.beginDelayedTransition(webviewContainer, transitionType)

            webviewContainer.removeView(webViewList?.get(viewNumber))
            webViewList?.get(viewNumber)!!.destroy()
            webViewList?.removeAt(viewNumber)

            refreshWebViewCount()
        } else {
            finish()
        }
    }

    fun refreshWebViewCount() {
//        webviewCountView.text = "${webViewList!!.size}"
    }

    private inner class CustomWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            Log.v(TAG, "shouldOverrideUrlLoading ${request?.url.toString()}")
            val uri = URI(request?.url.toString())
            Log.v(
                TAG, "shouldOverrideUrlLoading scheme:" +
                        "${uri.scheme} host:${uri.host} path:${uri.path} query:${uri.query}"
            )
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            Log.v(TAG, "onPageStarted $url")
            progressBar.show()
            urlBar.setText(url)
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            Log.v(TAG, "onPageFinished $url")
            progressBar.hide()
            super.onPageFinished(view, url)
        }

        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Log.v(TAG, "onReceivedError ${error?.errorCode}")
            }
            super.onReceivedError(view, request, error)
        }
    }

    private inner class CustomWebChromeClient : WebChromeClient() {
        override fun onCreateWindow(
            view: WebView?,
            isDialog: Boolean,
            isUserGesture: Boolean,
            resultMsg: Message?
        ): Boolean {
            Log.v("MainActivity", "onCreateWindow")

            val newWebView = WebView(this@WebViewActivity)
            settingWebView(newWebView)

            val transitionType: Transition = Slide(Gravity.BOTTOM)
            TransitionManager.beginDelayedTransition(webviewContainer, transitionType)

            webviewContainer.addView(newWebView)
            webViewList?.add(newWebView)

            refreshWebViewCount()
            Log.v("MainActivity", "webview added >> " + webViewList.toString())

            val transport = resultMsg?.obj as WebView.WebViewTransport
            transport.webView = newWebView
            resultMsg.sendToTarget()
            return true
        }

        override fun onJsAlert(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ): Boolean {
            val builder = AlertDialog.Builder(this@WebViewActivity)
            builder.setTitle("알림")
                .setMessage("$message")
                .setCancelable(false)
                .setPositiveButton("확인") { _, _ ->
                    result?.confirm()
                }
            val dialog = builder.create()
            dialog.show()
            return super.onJsAlert(view, url, message, result)
        }

        override fun onJsConfirm(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ): Boolean {
            val builder = AlertDialog.Builder(this@WebViewActivity)
            builder.setTitle("알림")
                .setMessage("$message")
                .setCancelable(false)
                .setPositiveButton("확인") { _, _ ->
                    result?.confirm()
                }
                .setNegativeButton("취소") { _, _ ->
                    result?.cancel()
                }
            val dialog = builder.create()
            dialog.show()
            return super.onJsConfirm(view, url, message, result)
        }

        override fun onCloseWindow(window: WebView?) {
            super.onCloseWindow(window)
            window?.destroy()
            webviewContainer.removeView(window)
        }

        override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
            Toast.makeText(this@WebViewActivity, "$consoleMessage", Toast.LENGTH_SHORT).show()
            return super.onConsoleMessage(consoleMessage)
        }

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            progressBar.progress = newProgress
            super.onProgressChanged(view, newProgress)
        }


    }
}