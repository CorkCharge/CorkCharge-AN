package com.corkcharge.myapplication.kmp.ui.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import design.theme.CorkChargeTheme
import kmp_corkcharge_an.composeapp.generated.resources.Res
import kmp_corkcharge_an.composeapp.generated.resources.bg_what_is_corkage
import kmp_corkcharge_an.composeapp.generated.resources.ic_onboarding_first
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ExplainCorkageScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(Res.drawable.bg_what_is_corkage),
            contentDescription = "와인 그림",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // 전체를 살짝 어둡게 만드는 검정 오버레이 (Figma 000000 비슷)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.35f)) // 0.3~0.4 정도 취향대로
        )
        // 아래쪽 흰색 페이드 (투명 -> 흰색)
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(160.dp) // 페이드 올라오는 높이 조절
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.White
                        )
                    )
                )
        )
        Box(
            modifier = Modifier.fillMaxSize().padding(bottom = 44.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_onboarding_first),
                    contentDescription = "첫번째 온보딩",
                    modifier = Modifier.size(34.dp, 6.dp)
                )
                Spacer(modifier = Modifier.height(48.dp))
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
                Text(text = "음식점에 외부 술을 가져와서 마시는 것", style = CorkChargeTheme.typography.HeadLine_Small, color = CorkChargeTheme.colors.gray3)
            Spacer(modifier = Modifier.weight(1f))
                Text(text = "경우에 따라 잔과 얼음을 제공하기도 합니다.", color = Color.White, style = CorkChargeTheme.typography.Label_Tab)
                Spacer(modifier = Modifier.height(36.dp))

            }
        }
    }
}

@Preview
@Composable
fun ExplainCorkageScreenPreview() {
    ExplainCorkageScreen()
}