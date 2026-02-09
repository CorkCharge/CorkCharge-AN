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

/**
 * 공통 웹뷰 컴포넌트
 * @param url 로드할 URL
 * @param modifier Modifier
 * @param onBridgeMessage 웹에서 메시지를 받았을 때 호출되는 콜백
 */
@Composable
fun CommonWebView(
    url: String,
    modifier: Modifier = Modifier.fillMaxSize(),
    onBridgeMessage: (methodName: String, message: String) -> Unit
) {
    val state = rememberWebViewState(url)
    val jsBridge = rememberWebViewJsBridge()

    LaunchedEffect(jsBridge) {
        // 웹에서 보내는 모든 메시지를 처리하는 핸들러 등록
        jsBridge.register(object : IJsMessageHandler {
            override fun methodName(): String = "sendToNative"

            override fun handle(message: JsMessage, navigator: WebViewNavigator?, callback: (String) -> Unit) {
                // 메시지 내용을 콜백으로 전달
                onBridgeMessage("sendToNative", message.params)
                // 웹으로 응답 전송 (선택사항)
                callback("{\"status\":\"success\"}")
            }
        })

        // 다른 메소드들도 추가로 등록 가능
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
        modifier = modifier,
        webViewJsBridge = jsBridge
    )
}