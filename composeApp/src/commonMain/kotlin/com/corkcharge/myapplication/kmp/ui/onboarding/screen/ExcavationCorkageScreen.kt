package com.corkcharge.myapplication.kmp.ui.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import design.theme.CorkChargeTheme
import kmp_corkcharge_an.composeapp.generated.resources.Res
import kmp_corkcharge_an.composeapp.generated.resources.bg_onboarding3
import kmp_corkcharge_an.composeapp.generated.resources.img_next_btn
import kmp_corkcharge_an.composeapp.generated.resources.img_onboarding_third
import kmp_corkcharge_an.composeapp.generated.resources.img_shake_hand
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ExcavationCorkageScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(Res.drawable.bg_onboarding3),
            contentDescription = "온보딩 3(발굴 방법)",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.align(Alignment.Center).padding(bottom = 44.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp).padding(top = 10.dp)
            ) {
                Image(
                    painter = painterResource(Res.drawable.img_onboarding_third),
                    contentDescription = "온보딩 3",
                    modifier = Modifier.size(34.dp, 6.dp).align(Alignment.Center)
                )
                Text(
                    text = "SKIP",
                    style = CorkChargeTheme.typography.Body_Small,
                    color = CorkChargeTheme.colors.gray5,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            Spacer(modifier = Modifier.height(39.dp))
            Text(
                text = "코르크차지의\n콜키지 발굴 방법²",
                style = CorkChargeTheme.typography.HeadLine_XL,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "해주세요에서 질접적인 요청이 가능합니다",
                style = CorkChargeTheme.typography.HeadLine_Small,
                color = CorkChargeTheme.colors.gray7
            )
            Spacer(modifier = Modifier.height(42.dp))
            Image(
                painter = painterResource(Res.drawable.img_shake_hand),
                contentDescription = "손 잡고 있는 아이콘",
                modifier = Modifier.size(242.dp)
            )
            Spacer(modifier = Modifier.height(47.dp))
            Column() {
                Text(
                    text = "해주세요 서비스란?",
                    style = CorkChargeTheme.typography.Body_Medium_B,
                    color = CorkChargeTheme.colors.gray8,
                    modifier = Modifier.align(
                        Alignment.Start
                    )
                )
                Text(
                    text = "코르크 차지의 추가 방식은 매장에 직접 방문하여\n사장님과 함계 콜키지 비즈니스를 시작하는방식입니다.\n'해주세요 리스트'에 등록된 매장은 우선적으로 콜키지 영업\n을 진행하게 됩니다.",
                    style = CorkChargeTheme.typography.Label_Tab,
                    color = CorkChargeTheme.colors.gray8,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(33.dp))
            Image(
                painter = painterResource(Res.drawable.img_next_btn),
                contentDescription = "다음 버튼",
                modifier = Modifier.fillMaxWidth().height(80.dp)
            )
        }
    }
}

@Preview
@Composable
fun ExcavationCorkageScreenPreview() {
    ExcavationCorkageScreen()
}