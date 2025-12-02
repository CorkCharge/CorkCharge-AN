package com.corkcharge.myapplication.kmp.presentation.onboarding.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kmp_corkcharge_an.composeapp.generated.resources.Res
import kmp_corkcharge_an.composeapp.generated.resources.bg_gradient_left
import kmp_corkcharge_an.composeapp.generated.resources.img_corkcharge_logo
import kmp_corkcharge_an.composeapp.generated.resources.img_corkcharge_text
import org.jetbrains.compose.resources.painterResource

@Composable
fun StartSplashScreen(
    modifier: Modifier = Modifier,
    onTimeout: () -> Unit = {}
) {
    var startAnimation by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        startAnimation = true
        delay(3000L)
        onTimeout()
    }

    val logoAlpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 500)
    )
    val logoTranslationY by animateFloatAsState(
        targetValue = if (startAnimation) 0f else 80f,
        animationSpec = tween(durationMillis = 500)
    )

    val textAlpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 500, delayMillis = 100)
    )

    Box(modifier = modifier.fillMaxSize()) {
        // 배경은 패딩 없이 무조건 꽉 채우기
        Image(
            painter = painterResource(Res.drawable.bg_gradient_left),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // 콘텐츠(로고, 텍스트)만 안전 영역 안으로 배치
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
                    .graphicsLayer(alpha = logoAlpha, translationY = logoTranslationY)
            )
            Spacer(modifier = Modifier.height(18.dp))
            Image(
                painter = painterResource(Res.drawable.img_corkcharge_text),
                contentDescription = "코르크차지 텍스트",
                modifier = Modifier.size(156.dp, 26.dp)
                    .graphicsLayer(alpha = textAlpha)
            )
        }
    }
}