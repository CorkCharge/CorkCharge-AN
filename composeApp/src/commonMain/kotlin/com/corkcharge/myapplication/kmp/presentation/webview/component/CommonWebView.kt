package com.corkcharge.myapplication.kmp.presentation.webview.component

import androidx.compose.runtime.Composable

@Composable
expect fun CommonWebView(
    url: String,
    onBridgeMessage: (methodName: String, message: String) -> Unit,
)
