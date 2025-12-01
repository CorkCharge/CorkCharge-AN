package com.corkcharge.myapplication.kmp.ui.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import design.theme.CorkChargeTheme
import kmp_corkcharge_an.composeapp.generated.resources.Res
import kmp_corkcharge_an.composeapp.generated.resources.bg_login
import kmp_corkcharge_an.composeapp.generated.resources.img_corkcharge_logo
import kmp_corkcharge_an.composeapp.generated.resources.img_naver_login_button
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(Res.drawable.bg_login),
            contentDescription = "로그인 배경화면",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // 화면 꽉 채우고 잘라내기
        )
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "코르크차지를\n시작해볼까요?",
                style = CorkChargeTheme.typography.HeadLine_XL,
                color = CorkChargeTheme.colors.gray8
            )
            Image(
                painter = painterResource(Res.drawable.img_corkcharge_logo),
                contentDescription = "코르크차지 로고",
                modifier = Modifier.size(156.73.dp, 257.dp).align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(69.dp))
            Image(
                painter = painterResource(Res.drawable.img_naver_login_button),
                contentDescription = "네이버 로그인 버튼",
                modifier = Modifier.fillMaxWidth().height(54.dp).clickable{} // TODO: 네이버로그인 화면으로 가는 거 필요
                .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "로그인 없이 보기", textDecoration = TextDecoration.Underline, style = CorkChargeTheme.typography.Body_Medium_R, color = CorkChargeTheme.colors.gray2)
        }
    }
}