package com.corkcharge.myapplication.kmp.presentation.webview.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.multiplatform.webview.jsbridge.IJsMessageHandler
import com.multiplatform.webview.jsbridge.JsMessage
import com.multiplatform.webview.jsbridge.rememberWebViewJsBridge
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewNavigator
import com.multiplatform.webview.web.rememberWebViewState

@Composable
actual fun CommonWebView(
    url: String,
    onBridgeMessage: (methodName: String, message: String) -> Unit,
) {
    val state = rememberWebViewState(url)
    val jsBridge = rememberWebViewJsBridge()

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

    WebView(
        state = state,
        modifier = Modifier.fillMaxSize(),
        webViewJsBridge = jsBridge
    )
}
