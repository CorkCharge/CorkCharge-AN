package com.corkcharge.myapplication.kmp.util

import androidx.compose.runtime.Composable

/**
 * 플랫폼별 기능을 제공하는 인터페이스
 */
expect class PlatformActions {
    /**
     * 전화 걸기
     * @param phoneNumber 전화번호 (예: "010-1234-5678")
     */
    fun callPhone(phoneNumber: String)

    /**
     * 공유하기
     * @param title 공유할 제목
     * @param text 공유할 텍스트
     * @param url 공유할 URL (선택사항)
     */
    fun share(title: String, text: String, url: String? = null)

    /**
     * 외부 브라우저로 URL 열기
     * @param url 열 URL
     */
    fun openExternalBrowser(url: String)
}

/**
 * Composable에서 PlatformActions 인스턴스를 가져오는 함수
 */
@Composable
expect fun rememberPlatformActions(): PlatformActions
