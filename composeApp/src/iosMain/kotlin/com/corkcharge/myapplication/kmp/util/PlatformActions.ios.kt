package com.corkcharge.myapplication.kmp.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import platform.Foundation.NSURL
import platform.UIKit.UIActivityViewController
import platform.UIKit.UIApplication

actual class PlatformActions {
    actual fun callPhone(phoneNumber: String) {
        val cleanNumber = phoneNumber.replace("-", "").replace(" ", "")
        val url = NSURL.URLWithString("tel://$cleanNumber")
        url?.let {
            if (UIApplication.sharedApplication.canOpenURL(it)) {
                UIApplication.sharedApplication.openURL(it)
            }
        }
    }

    actual fun share(title: String, text: String, url: String?) {
        val items = mutableListOf<Any>(text)
        url?.let { items.add(it) }

        // TODO: iOS 공유 기능 구현
        // UIActivityViewController를 사용하려면 UIViewController 컨텍스트가 필요
        println("iOS 공유: title=$title, text=$text, url=$url")
    }

    actual fun openExternalBrowser(url: String) {
        val nsUrl = NSURL.URLWithString(url)
        nsUrl?.let {
            if (UIApplication.sharedApplication.canOpenURL(it)) {
                UIApplication.sharedApplication.openURL(it)
            }
        }
    }
}

@Composable
actual fun rememberPlatformActions(): PlatformActions {
    return remember { PlatformActions() }
}
