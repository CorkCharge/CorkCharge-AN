package com.corkcharge.myapplication.kmp.presentation.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kmp_corkcharge_an.composeapp.generated.resources.Res
import kmp_corkcharge_an.composeapp.generated.resources.bg_gradient_left
import kmp_corkcharge_an.composeapp.generated.resources.img_corkcharge_logo
import kmp_corkcharge_an.composeapp.generated.resources.img_corkcharge_text
import org.jetbrains.compose.resources.painterResource

@Composable
fun FinishSplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit = {}
) {
    LaunchedEffect(Unit) {
        delay(2000) // 2초 후 홈 화면으로 이동
        onNavigateToHome()
    }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(Res.drawable.bg_gradient_left),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.img_corkcharge_logo),
                contentDescription = "코르크차지 로고",
                modifier = Modifier.size(128.dp, 212.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            Image(
                painter = painterResource(Res.drawable.img_corkcharge_text),
                contentDescription = "코르크차지 텍스트",
                modifier = Modifier.size(156.dp, 26.dp)
            )
        }
    }
}