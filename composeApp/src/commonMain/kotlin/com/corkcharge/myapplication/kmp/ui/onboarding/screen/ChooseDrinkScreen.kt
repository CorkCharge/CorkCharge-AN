package com.corkcharge.myapplication.kmp.ui.onboarding.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import design.theme.CorkChargeTheme

@Composable
fun ChooseDrinkScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).padding(top = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TODO: State bar 넣기
        Text(modifier = Modifier.padding(top = 48.dp), text = "당신의 잔에 담고 싶은 건?", style = CorkChargeTheme.typography.HeadLine_XL, color = Color.Black)
        Text(modifier = Modifier.padding(top = 16.dp), text ="(복수 선택 가능)", color = CorkChargeTheme.colors.gray7, style = CorkChargeTheme.typography.HeadLine_Small)

    }
}