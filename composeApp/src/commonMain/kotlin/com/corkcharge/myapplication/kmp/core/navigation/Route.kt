package com.corkcharge.myapplication.kmp.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route {
    // 1. 온보딩 그래프 전체를 식별하는 ID (추가)
    @Serializable
    data object OnboardingGraph : Route

    // 2. 개별 화면들
    @Serializable
    data object StartSplash : Route

    @Serializable
    data object ExplainCorkage : Route

    @Serializable
    data object ExcavationCorkage : Route

    @Serializable
    data object Login : Route

    @Serializable
    data object FinishSplash : Route
}