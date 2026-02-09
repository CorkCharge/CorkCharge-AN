package com.corkcharge.myapplication.kmp.presentation.webview.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.corkcharge.myapplication.kmp.presentation.webview.component.CommonWebView
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Composable
fun NaverLoginWebViewScreen(navController: NavController) {
    CommonWebView(
        url = "https://nid.naver.com/oauth2.0/authorize", // 실제 네이버 로그인 URL로 변경 필요
        onBridgeMessage = { methodName, params ->
            try {
                // JSON 파라미터 파싱
                val json = Json.parseToJsonElement(params).jsonObject

                when (methodName) {
                    "loginSuccess" -> {
                        // 로그인 성공 시 토큰 등을 받아서 저장
                        val accessToken = json["accessToken"]?.jsonPrimitive?.content
                        val refreshToken = json["refreshToken"]?.jsonPrimitive?.content

                        // TODO: 토큰 저장 로직 구현
                        println("로그인 성공: accessToken=$accessToken")

                        // 홈 화면으로 이동
                        navController.navigate("home") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                    "loginFailed" -> {
                        // 로그인 실패 처리
                        val error = json["error"]?.jsonPrimitive?.content
                        println("로그인 실패: $error")

                        // 이전 화면으로 돌아가기
                        navController.popBackStack()
                    }
                    "cancel" -> {
                        // 취소 버튼 클릭 시
                        navController.popBackStack()
                    }
                }
            } catch (e: Exception) {
                println("메시지 파싱 오류: ${e.message}")
            }
        }
    )
}
