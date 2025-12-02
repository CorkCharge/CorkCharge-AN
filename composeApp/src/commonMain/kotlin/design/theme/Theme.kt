package design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

// 1. Material3 표준 ColorScheme 설정 (에러 방지를 위해 명시적 선언)
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Gray8,
    surface = Gray8
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = PrimaryColor,
    surface = PrimaryColor
)

/**
 * KMP 공용 Theme
 */
@Composable
fun CorkChargeANTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // 이제 여기서 DarkColorScheme과 LightColorScheme을 정상적으로 인식합니다.
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    // Type.kt에서 만든 함수들 호출
    val fontFamily = pretendardFontFamily()
    val corkTypography = createCorkChargeTypography(fontFamily)
    val materialTypography = createMaterialTypography(fontFamily)

    CompositionLocalProvider(
        LocalCorkChargeColorsProvider provides defaultCorkChargeColors,
        LocalCorkChargeTypographyProvider provides corkTypography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = materialTypography,
            content = content
        )
    }
}

/**
 * UI 코드에서 편리하게 접근하기 위한 싱글톤 객체
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