package kr.co.saramin.fastandroidstudy

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.*
import kotlinx.android.synthetic.main.activity_web_view.*
import android.transition.Slide
import android.transition.Transition
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.Toast
import java.net.URI


class WebViewActivity : AppCompatActivity() {

    var webViewList: ArrayList<WebView>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        supportActionBar?.hide()

        settingWebView(webView)

        webViewList = ArrayList()
        webViewList?.add(webView)
        refreshWebViewCount()

        webView.loadUrl(intent.extras?.getString("link"))
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun settingWebView(view: WebView) {
        view.settings.javaScriptEnabled = true
        view.settings.javaScriptCanOpenWindowsAutomatically = true
        view.settings.setSupportMultipleWindows(true)
        view.webViewClient = CustomWebViewClient()
        view.webChromeClient = CustomWebChromeClient()
    }

    override fun onBackPressed() {
        if (webViewList?.get(webViewList!!.size - 1)?.canGoBack()!!) {
            webViewList!!.get(webViewList!!.size - 1).goBack()
        } else if (webViewList!!.size > 1) {
            val viewNumber = webViewList!!.size - 1
            val transitionType: Transition = Slide(Gravity.BOTTOM)
            TransitionManager.beginDelayedTransition(webviewContainer, transitionType)
            webviewContainer.removeView(webViewList?.get(viewNumber))
            webViewList?.get(viewNumber)!!.destroy()
            webViewList?.removeAt(viewNumber)
            refreshWebViewCount()
        } else {
            finish()
        }
    }

    fun refreshWebViewCount() {
        webviewCountView.text = "${webViewList!!.size}"
    }

    private inner class CustomWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
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
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            Log.v(TAG, "onPageFinished $url")
            super.onPageFinished(view, url)
        }

        override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
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

        override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
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

        override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
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
            if (newProgress in 1..100) {
                progressBar.show()
                progressBar.progress = newProgress
            } else {
                progressBar.hide()
            }
            super.onProgressChanged(view, newProgress)
        }


    }
}