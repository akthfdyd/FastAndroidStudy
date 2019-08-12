package kr.co.saramin.fastandroidstudy

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.ViewGroup
import android.webkit.*
import kotlinx.android.synthetic.main.activity_web_view.*


class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView.settings.javaScriptEnabled = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        webView.settings.setSupportMultipleWindows(true)
        webView.webViewClient = CustomWebViewClient()
        webView.webChromeClient = CustomWebChromeClient()

        webView.loadUrl(intent.extras?.getString("link"))
    }

    private inner class CustomWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            Log.v(TAG, "shouldOverrideUrlLoading${request?.url.toString()}")
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
            val newWebView = WebView(view?.context)
            newWebView.tag = "subWebView"
            newWebView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

            activity_webview.addView(newWebView)
            val transport = resultMsg?.obj as WebView.WebViewTransport
            transport.webView = newWebView
            resultMsg.sendToTarget()
            return true
        }

        override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
            return super.onJsAlert(view, url, message, result)
        }

        override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
            return super.onJsConfirm(view, url, message, result)
        }

        override fun onCloseWindow(window: WebView?) {
            super.onCloseWindow(window)
        }

        override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
            return super.onConsoleMessage(consoleMessage)
        }

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
        }


    }
}