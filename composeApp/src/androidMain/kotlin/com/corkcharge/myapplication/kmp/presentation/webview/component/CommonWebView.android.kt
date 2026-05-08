package com.corkcharge.myapplication.kmp.presentation.webview.component

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Message
import android.webkit.CookieManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.multiplatform.webview.jsbridge.IJsMessageHandler
import com.multiplatform.webview.jsbridge.JsMessage
import com.multiplatform.webview.jsbridge.rememberWebViewJsBridge
import com.multiplatform.webview.web.AccompanistWebChromeClient
import com.multiplatform.webview.web.AccompanistWebViewClient
import com.multiplatform.webview.web.PlatformWebViewParams
import com.multiplatform.webview.web.WebView as ComposeWebView
import com.multiplatform.webview.web.WebViewNavigator
import com.multiplatform.webview.web.rememberWebViewState

@Composable
actual fun CommonWebView(
    url: String,
    onBridgeMessage: (methodName: String, message: String) -> Unit,
) {
    val state = rememberWebViewState(url) {
        androidWebSettings.apply {
            domStorageEnabled = true
            useWideViewPort = true
            mediaPlaybackRequiresUserGesture = false
        }
    }
    val jsBridge = rememberWebViewJsBridge()
    val webViewClient = remember { LoginWebViewClient() }
    val chromeClient = remember { LoginWebChromeClient() }

    LaunchedEffect(jsBridge) {
        jsBridge.register(object : IJsMessageHandler {
            override fun methodName(): String = "sendToNative"

            override fun handle(message: JsMessage, navigator: WebViewNavigator?, callback: (String) -> Unit) {
                onBridgeMessage("sendToNative", message.params)
                callback("{\"status\":\"success\"}")
            }
        })

        jsBridge.register(object : IJsMessageHandler {
            override fun methodName(): String = "callPhone"

            override fun handle(message: JsMessage, navigator: WebViewNavigator?, callback: (String) -> Unit) {
                onBridgeMessage("callPhone", message.params)
                callback("{\"status\":\"success\"}")
            }
        })

        jsBridge.register(object : IJsMessageHandler {
            override fun methodName(): String = "share"

            override fun handle(message: JsMessage, navigator: WebViewNavigator?, callback: (String) -> Unit) {
                onBridgeMessage("share", message.params)
                callback("{\"status\":\"success\"}")
            }
        })

        jsBridge.register(object : IJsMessageHandler {
            override fun methodName(): String = "openBrowser"

            override fun handle(message: JsMessage, navigator: WebViewNavigator?, callback: (String) -> Unit) {
                onBridgeMessage("openBrowser", message.params)
                callback("{\"status\":\"success\"}")
            }
        })

        jsBridge.register(object : IJsMessageHandler {
            override fun methodName(): String = "navigate"

            override fun handle(message: JsMessage, navigator: WebViewNavigator?, callback: (String) -> Unit) {
                onBridgeMessage("navigate", message.params)
                callback("{\"status\":\"success\"}")
            }
        })
    }

    ComposeWebView(
        state = state,
        modifier = Modifier.fillMaxSize(),
        webViewJsBridge = jsBridge,
        platformWebViewParams = PlatformWebViewParams(
            client = webViewClient,
            chromeClient = chromeClient
        ),
        onCreated = { webView ->
            webView.settings.javaScriptCanOpenWindowsAutomatically = true
            webView.settings.setSupportMultipleWindows(true)
            CookieManager.getInstance().setAcceptCookie(true)
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)
        }
    )
}

private class LoginWebViewClient : AccompanistWebViewClient() {
    override fun onPageStarted(
        view: WebView,
        url: String?,
        favicon: Bitmap?,
    ) {
        super.onPageStarted(view, url, favicon)
        injectLoginWorkaround(view)
    }

    override fun onPageFinished(
        view: WebView,
        url: String?,
    ) {
        super.onPageFinished(view, url)
        injectLoginWorkaround(view)
    }

    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?,
    ): Boolean = handleUrl(view, request?.url?.toString())

    @Deprecated("Deprecated in Java")
    override fun shouldOverrideUrlLoading(
        view: WebView,
        url: String,
    ): Boolean = handleUrl(view, url)

    private fun handleUrl(
        view: WebView?,
        url: String?,
    ): Boolean {
        if (view == null || url.isNullOrBlank()) return false
        val uri = Uri.parse(url)
        val scheme = uri.scheme.orEmpty()

        if (scheme == "http" || scheme == "https") {
            return false
        }

        if (scheme == "intent") {
            return try {
                val intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME)
                view.context.startActivity(intent)
                true
            } catch (_: Exception) {
                val fallbackUrl = runCatching {
                    Intent.parseUri(url, Intent.URI_INTENT_SCHEME).getStringExtra("browser_fallback_url")
                }.getOrNull()

                if (!fallbackUrl.isNullOrBlank()) {
                    view.loadUrl(fallbackUrl)
                    true
                } else {
                    false
                }
            }
        }

        return try {
            view.context.startActivity(
                Intent(Intent.ACTION_VIEW, uri).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
            )
            true
        } catch (_: ActivityNotFoundException) {
            false
        }
    }

    private fun injectLoginWorkaround(view: WebView) {
        val script =
            """
            (function() {
              if (window.__ccNaverPatched) return;
              window.__ccNaverPatched = true;

              var openInSameView = function(targetUrl) {
                if (!targetUrl) return null;
                window.location.href = targetUrl;
                return null;
              };

              window.open = function(targetUrl) {
                return openInSameView(targetUrl);
              };

              document.addEventListener('click', function(event) {
                var anchor = event.target && event.target.closest ? event.target.closest('a[target="_blank"]') : null;
                if (!anchor) return;
                event.preventDefault();
                openInSameView(anchor.href);
              }, true);
            })();
            """.trimIndent()

        view.evaluateJavascript(script, null)
    }
}

private class LoginWebChromeClient : AccompanistWebChromeClient() {
    override fun onCreateWindow(
        view: WebView,
        isDialog: Boolean,
        isUserGesture: Boolean,
        resultMsg: Message,
    ): Boolean {
        val transport = resultMsg.obj as? WebView.WebViewTransport ?: return false
        val popupWebView = WebView(view.context)

        popupWebView.settings.javaScriptEnabled = true
        popupWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                popupView: WebView,
                request: WebResourceRequest,
            ): Boolean {
                view.loadUrl(request.url.toString())
                popupView.destroy()
                return true
            }

            @Deprecated("Deprecated in Java")
            override fun shouldOverrideUrlLoading(
                popupView: WebView,
                url: String,
            ): Boolean {
                view.loadUrl(url)
                popupView.destroy()
                return true
            }
        }

        transport.webView = popupWebView
        resultMsg.sendToTarget()
        return true
    }
}
