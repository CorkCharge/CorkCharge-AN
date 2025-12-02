package com.corkcharge.myapplication.kmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.corkcharge.myapplication.kmp.core.navigation.CorkNavgraph
import design.theme.CorkChargeANTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    CorkChargeANTheme {
        val navController = rememberNavController()

        // 배경이 꽉 차게 하려면 여기서 statusBarsPadding()을 제거해야 합니다.
        CorkNavgraph(
            modifier = Modifier.fillMaxSize(),
            navController = navController
        )
    }
}