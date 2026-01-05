package com.corkcharge.myapplication.kmp.presentation.onboarding.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import design.theme.CorkChargeTheme
import kmp_corkcharge_an.composeapp.generated.resources.Res
import kmp_corkcharge_an.composeapp.generated.resources.bg_what_is_corkage
import kmp_corkcharge_an.composeapp.generated.resources.img_next_btn
import kmp_corkcharge_an.composeapp.generated.resources.img_onboarding_first
import org.jetbrains.compose.resources.painterResource

@Composable
fun ExplainCorkageScreen(
    modifier: Modifier = Modifier,
    onNavigateToNext: () -> Unit = {},
) {
    var startAnimation by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        startAnimation = true
    }

    val blurAnim by animateFloatAsState(
        targetValue = if (startAnimation) 0f else 20f,
        animationSpec = tween(durationMillis = 700)
    )

    val contentAlpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 700)
    )
    val contentTranslationY by animateFloatAsState(
        targetValue = if (startAnimation) 0f else 50f,
        animationSpec = tween(durationMillis = 700)
    )

    Box(modifier = modifier.fillMaxSize()) {
        // 배경 이미지
        Image(
            painter = painterResource(Res.drawable.bg_what_is_corkage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().blur(radius = blurAnim.dp),
            contentScale = ContentScale.Crop
        )
        // 어두운 오버레이
        Box(modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.35f)))

        // 하단 흰색 그라데이션
        Box(
            modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth().height(160.dp)
                .background(Brush.verticalGradient(colors = listOf(Color.Transparent, Color.White)))
        )

        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 44.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 인디케이터
            Image(
                painter = painterResource(Res.drawable.img_onboarding_first),
                contentDescription = null,
                modifier = Modifier.padding(top = 10.dp).size(34.dp, 6.dp).graphicsLayer(alpha = contentAlpha)
            )

            Spacer(modifier = Modifier.height(48.dp))

            // 중앙 콘텐츠
            Column(
                modifier = Modifier.weight(1f).graphicsLayer(alpha = contentAlpha, translationY = contentTranslationY),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "콜키지란?",
                    style = CorkChargeTheme.typography.HeadLine_XL,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(52.dp))
                Text(
                    text = "주류반입비",
                    style = CorkChargeTheme.typography.HeadLine_Medium_B,
                    color = Color.White
                )
                Text(
                    text = "음식점에 외부 술을 가져와서 마시는 것",
                    style = CorkChargeTheme.typography.HeadLine_Small,
                    color = CorkChargeTheme.colors.gray3
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "경우에 따라 잔과 얼음을 제공하기도 합니다.",
                    color = Color.White,
                    style = CorkChargeTheme.typography.Label_Tab
                )
                Spacer(modifier = Modifier.height(36.dp))

                // 다음 버튼
                Image(
                    painter = painterResource(Res.drawable.img_next_btn),
                    contentDescription = "다음 버튼",
                    modifier = Modifier.fillMaxWidth().clickable { onNavigateToNext() }
                )
            }
        }
    }
}