package com.corkcharge.myapplication.kmp.presentation.webview.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.corkcharge.myapplication.kmp.presentation.webview.component.CommonWebView
import com.corkcharge.myapplication.kmp.util.rememberPlatformActions
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Composable
fun HomeWebViewScreen(navController: NavController) {
    val platformActions = rememberPlatformActions()

    CommonWebView(
        url = "https://cork-charge-fe-deployment.vercel.app/signin",
        onBridgeMessage = { methodName, params ->
            try {
                // JSON 파라미터 파싱
                val json = Json.parseToJsonElement(params).jsonObject

                when (methodName) {
                    "callPhone" -> {
                        // 전화 걸기
                        val phoneNumber = json["phoneNumber"]?.jsonPrimitive?.content
                        phoneNumber?.let {
                            platformActions.callPhone(it)
                        }
                    }
                    "share" -> {
                        // 공유하기
                        val title = json["title"]?.jsonPrimitive?.content ?: ""
                        val text = json["text"]?.jsonPrimitive?.content ?: ""
                        val url = json["url"]?.jsonPrimitive?.content
                        platformActions.share(title, text, url)
                    }
                    "openBrowser" -> {
                        // 외부 브라우저로 열기
                        val url = json["url"]?.jsonPrimitive?.content
                        url?.let {
                            platformActions.openExternalBrowser(it)
                        }
                    }
                    "navigate" -> {
                        // 앱 내부 화면 이동
                        val screen = json["screen"]?.jsonPrimitive?.content
                        when (screen) {
                            "reservation_list" -> navController.navigate("reservation_list")
                            "login" -> navController.navigate("login")
                        }
                    }
                    "sendToNative" -> {
                        // 일반 메시지 처리
                        val action = json["action"]?.jsonPrimitive?.content
                        when (action) {
                            "RESERVATION_CLICK" -> {
                                navController.navigate("reservation_list")
                            }
                            "LOGIN_REQUIRED" -> {
                                navController.navigate("login")
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                println("메시지 파싱 오류: ${e.message}")
            }
        }
    )
}