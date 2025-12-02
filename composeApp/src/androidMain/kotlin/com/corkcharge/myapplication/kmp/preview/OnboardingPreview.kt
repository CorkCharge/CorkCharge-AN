package com.corkcharge.myapplication.kmp.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.corkcharge.myapplication.kmp.ui.onboarding.screen.ExcavationCorkageScreen
import com.corkcharge.myapplication.kmp.ui.onboarding.screen.ExplainCorkageScreen
import design.theme.CorkChargeANTheme
import design.theme.CorkChargeTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExcavationCorkageScreenAndroidPreview() {
    CorkChargeANTheme {
        ExcavationCorkageScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExplainCorkageScreenAndroidPreview() {
    CorkChargeANTheme {
        ExplainCorkageScreen()
    }
}
