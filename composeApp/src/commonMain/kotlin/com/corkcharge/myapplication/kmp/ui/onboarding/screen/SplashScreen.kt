package com.corkcharge.myapplication.kmp.ui.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kmp_corkcharge_an.composeapp.generated.resources.Res
import kmp_corkcharge_an.composeapp.generated.resources.bg_gradient_left
import kmp_corkcharge_an.composeapp.generated.resources.bg_login
import kmp_corkcharge_an.composeapp.generated.resources.img_corkcharge_logo
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreen(modifier: Modifier = Modifier) { // 시작, 끝일 때 사용하는 화면
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(Res.drawable.bg_gradient_left),
            contentDescription = "온보딩1",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // 화면 꽉 채우고 잘라내기
        )
        Column(modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.img_corkcharge_logo),
                contentDescription = "코르크차지 로고",
                modifier = Modifier.size(156.73.dp, 257.dp).align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}