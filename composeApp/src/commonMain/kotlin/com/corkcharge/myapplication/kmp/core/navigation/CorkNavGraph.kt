package com.corkcharge.myapplication.kmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.corkcharge.myapplication.kmp.presentation.onboarding.screen.*
import com.corkcharge.myapplication.kmp.presentation.webview.screen.HomeWebViewScreen
import com.corkcharge.myapplication.kmp.presentation.webview.screen.NaverLoginWebViewScreen

@Composable
fun CorkNavgraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.OnboardingGraph
    ) {
        navigation<Route.OnboardingGraph>(
            startDestination = Route.StartSplash
        ) {
            composable<Route.StartSplash> {
                StartSplashScreen(
                    modifier = modifier,
                    onTimeout = {
                        // 3초 뒤 다음 화면으로 이동하고 스플래시는 백스택에서 제거
                        navController.navigate(Route.ExplainCorkage) {
                            popUpTo(Route.StartSplash) { inclusive = true }
                        }
                    }
                )
            }

            composable<Route.ExplainCorkage> {
                ExplainCorkageScreen(
                    modifier = modifier,
                    onNavigateToNext = {
                        navController.navigate(Route.ExcavationCorkage)
                    }
                )
            }

            composable<Route.ExcavationCorkage> {
                ExcavationCorkageScreen(
                    modifier = modifier,
                    onNavigateToNext = { navController.navigate(Route.Login) },
                    onNavigateToLogin = { navController.navigate(Route.Login) }
                )
            }

            composable<Route.Login> {
                LoginScreen(
                    modifier = modifier,
                    onNavigateToNoLogin = { navController.navigate(Route.FinishSplash) }
                )
            }

            composable<Route.FinishSplash> {
                FinishSplashScreen(
                    modifier = modifier,
                    onNavigateToHome = {
                        navController.navigate(Route.HomeWebView) {
                            popUpTo(Route.OnboardingGraph) { inclusive = true }
                        }
                    }
                )
            }
        }

        // 웹뷰 화면들
        composable<Route.HomeWebView> {
            HomeWebViewScreen(navController = navController)
        }

        composable<Route.NaverLogin> {
            NaverLoginWebViewScreen(navController = navController)
        }
    }
}