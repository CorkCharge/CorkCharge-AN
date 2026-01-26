package com.corkcharge.myapplication.kmp.presentation.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import design.theme.CorkChargeTheme
import kmp_corkcharge_an.composeapp.generated.resources.Res
import kmp_corkcharge_an.composeapp.generated.resources.bg_login
import kmp_corkcharge_an.composeapp.generated.resources.img_corkcharge_logo
import kmp_corkcharge_an.composeapp.generated.resources.img_naver_login_button
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onNavigateToNoLogin: () -> Unit = {}
) {
    Box(modifier = modifier.fillMaxSize()) {
        // 배경은 패딩 없이 전체 화면 채우기
        Image(
            painter = painterResource(Res.drawable.bg_login),
            contentDescription = "로그인 배경화면",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // UI 콘텐츠만 안전 영역 확보
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "코르크차지를\n시작해볼까요?",
                style = CorkChargeTheme.typography.HeadLine_XL,
                color = CorkChargeTheme.colors.gray8,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(30.dp))

            Image(
                painter = painterResource(Res.drawable.img_corkcharge_logo),
                contentDescription = "코르크차지 로고",
                modifier = Modifier.size(156.dp, 257.dp)
            )

            Spacer(modifier = Modifier.height(69.dp))

            Image(
                painter = painterResource(Res.drawable.img_naver_login_button),
                contentDescription = "네이버 로그인 버튼",
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(54.dp)
                    .clickable { /* TODO: 네이버 로그인 구현 */ }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "로그인 없이 보기",
                textDecoration = TextDecoration.Underline,
                style = CorkChargeTheme.typography.Body_Medium_R,
                color = CorkChargeTheme.colors.gray2,
                modifier = Modifier.clickable(onClick = onNavigateToNoLogin)
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}