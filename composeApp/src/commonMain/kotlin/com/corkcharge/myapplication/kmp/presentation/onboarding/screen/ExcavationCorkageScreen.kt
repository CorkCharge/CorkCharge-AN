package com.corkcharge.myapplication.kmp.presentation.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import design.theme.CorkChargeTheme
import kmp_corkcharge_an.composeapp.generated.resources.Res
import kmp_corkcharge_an.composeapp.generated.resources.bg_onboarding3
import kmp_corkcharge_an.composeapp.generated.resources.img_next_btn
import kmp_corkcharge_an.composeapp.generated.resources.img_onboarding_third
import kmp_corkcharge_an.composeapp.generated.resources.img_shake_hand
import org.jetbrains.compose.resources.painterResource

@Composable
fun ExcavationCorkageScreen(
    modifier: Modifier = Modifier,
    onNavigateToNext: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {}
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(Res.drawable.bg_onboarding3),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .padding(bottom = 44.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 상단 바 (인디케이터 + SKIP)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .height(44.dp)
            ) {
                Image(
                    painter = painterResource(Res.drawable.img_onboarding_third),
                    contentDescription = null,
                    modifier = Modifier.size(34.dp, 6.dp).align(Alignment.Center)
                )
                Text(
                    text = "SKIP",
                    style = CorkChargeTheme.typography.Body_Small,
                    color = CorkChargeTheme.colors.gray5,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clickable(onClick = onNavigateToLogin)
                )
            }

            Spacer(modifier = Modifier.height(39.dp))

            Text(
                text = "코르크차지의\n콜키지 발굴 방법²",
                style = CorkChargeTheme.typography.HeadLine_XL,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "해주세요에서 직접적인 요청이 가능합니다",
                style = CorkChargeTheme.typography.HeadLine_Small,
                color = CorkChargeTheme.colors.gray7
            )

            Spacer(modifier = Modifier.height(42.dp))

            Image(
                painter = painterResource(Res.drawable.img_shake_hand),
                contentDescription = null,
                modifier = Modifier.size(242.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            // 설명 텍스트 영역
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "해주세요 서비스란?",
                    style = CorkChargeTheme.typography.Body_Medium_B,
                    color = CorkChargeTheme.colors.gray8
                )
                Text(
                    text = "코르크 차지의 추가 방식은 매장에 직접 방문하여\n사장님과 함께 콜키지 비즈니스를 시작하는방식입니다.\n'해주세요 리스트'에 등록된 매장은 우선적으로 콜키지 영업\n을 진행하게 됩니다.",
                    style = CorkChargeTheme.typography.Label_Tab,
                    color = CorkChargeTheme.colors.gray8,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(33.dp))

            Image(
                painter = painterResource(Res.drawable.img_next_btn),
                contentDescription = "다음 버튼",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clickable(onClick = onNavigateToNext)
            )
        }
    }
}