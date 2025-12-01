package design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

/**
 * KMP 공용 Theme
 * - Android / iOS 둘 다 여기로 들어옴
 * - dynamicColor, LocalContext 등 안드로이드 전용 코드는 제거
 */
@Composable
fun CorkChargeANTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    // Pretendard 폰트 적용된 Typography 생성
    val corkTypography = defaultCorkChargeTypography.copy(
        Display = defaultCorkChargeTypography.Display.copy(
            fontFamily = pretendardFontFamily()
        ),
        HeadLine_XL = defaultCorkChargeTypography.HeadLine_XL.copy(
            fontFamily = pretendardFontFamily()
        ),
        HeadLine_Large = defaultCorkChargeTypography.HeadLine_Large.copy(
            fontFamily = pretendardFontFamily()
        ),
        HeadLine_Medium_B = defaultCorkChargeTypography.HeadLine_Medium_B.copy(
            fontFamily = pretendardFontFamily()
        ),
        HeadLine_Medium_M = defaultCorkChargeTypography.HeadLine_Medium_M.copy(
            fontFamily = pretendardFontFamily()
        ),
        HeadLine_Small = defaultCorkChargeTypography.HeadLine_Small.copy(
            fontFamily = pretendardFontFamily()
        ),
        Body_Medium_M = defaultCorkChargeTypography.Body_Medium_M.copy(
            fontFamily = pretendardFontFamily()
        ),
        Body_Medium_B = defaultCorkChargeTypography.Body_Medium_B.copy(
            fontFamily = pretendardFontFamily()
        ),
        Body_Small = defaultCorkChargeTypography.Body_Small.copy(
            fontFamily = pretendardFontFamily()
        ),
        Body_Medium_R = defaultCorkChargeTypography.Body_Medium_R.copy(
            fontFamily = pretendardFontFamily()
        ),
        Label_Button = defaultCorkChargeTypography.Label_Button.copy(
            fontFamily = pretendardFontFamily()
        ),
        Label_Tab = defaultCorkChargeTypography.Label_Tab.copy(
            fontFamily = pretendardFontFamily()
        ),
        Caption = defaultCorkChargeTypography.Caption.copy(
            fontFamily = pretendardFontFamily()
        ),
        Caption_L_B = defaultCorkChargeTypography.Caption_L_B.copy(
            fontFamily = pretendardFontFamily()
        ),
        Caption_L_M = defaultCorkChargeTypography.Caption_L_M.copy(
            fontFamily = pretendardFontFamily()
        ),
    )

    CompositionLocalProvider(
        LocalCorkChargeColorsProvider provides defaultCorkChargeColors,
        LocalCorkChargeTypographyProvider provides corkTypography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = MaterialTypography, // Material3 Typography (원래 Typography)
            content = content
        )
    }
}

/**
 * 예전 네이티브 코드와 동일한 사용 패턴을 유지하기 위한 object
 */
object CorkChargeTheme {
    val colors: CorkChargeColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCorkChargeColorsProvider.current

    val typography: CorkChargeTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCorkChargeTypographyProvider.current
}
