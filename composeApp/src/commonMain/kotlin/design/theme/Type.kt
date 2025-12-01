package design.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import kmp_corkcharge_an.composeapp.generated.resources.Res
import kmp_corkcharge_an.composeapp.generated.resources.pretendard_bold
import kmp_corkcharge_an.composeapp.generated.resources.pretendard_extrabold
import kmp_corkcharge_an.composeapp.generated.resources.pretendard_medium
import kmp_corkcharge_an.composeapp.generated.resources.pretendard_regular
import org.jetbrains.compose.resources.Font

// ───────────────────────────────────────────────────────────────
// 1) Pretendard FontFamily (KMP용)
// ───────────────────────────────────────────────────────────────

/**
 * composeResources 기반 Pretendard FontFamily
 * - Medium / Bold / ExtraBold 3종만 사용
 */
@Composable
fun pretendardFontFamily(): FontFamily {
    return FontFamily(
        Font(
            resource = Res.font.pretendard_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.pretendard_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.pretendard_extrabold,
            weight = FontWeight.ExtraBold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.pretendard_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        )
    )
}

@Immutable
data class CorkChargeTypography(
    // Display
    val Display: TextStyle,

    // Headline
    val HeadLine_XL: TextStyle,
    val HeadLine_Large: TextStyle,
    val HeadLine_Medium_B: TextStyle,
    val HeadLine_Medium_M: TextStyle,
    val HeadLine_Small: TextStyle,

    // Body
    val Body_Medium_M: TextStyle,
    val Body_Medium_B: TextStyle,
    val Body_Small: TextStyle,
    val Body_Medium_R: TextStyle,

    // Label
    val Label_Button: TextStyle,
    val Label_Tab: TextStyle,

    // Footnote, Caption
    val Caption: TextStyle,
    val Caption_L_B: TextStyle,
    val Caption_L_M: TextStyle
)
val defaultCorkChargeTypography = CorkChargeTypography(
    Display = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 42.sp,
        lineHeight = 56.sp,
        letterSpacing = (-0.5f / 42f).em,
        fontWeight = FontWeight.ExtraBold
    ),
    HeadLine_XL = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 30.sp,
        lineHeight = 44.sp,
        letterSpacing = (-0.5f / 30f).em,
        fontWeight = FontWeight.Bold
    ),
    HeadLine_Large = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 24.sp,
        lineHeight = 36.sp,
        letterSpacing = (-0.25f / 24f).em,
        fontWeight = FontWeight.Bold
    ),
    HeadLine_Medium_B = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.Medium
    ),
    HeadLine_Medium_M = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.Medium
    ),
    HeadLine_Small = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Medium
    ),
    Body_Medium_M = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight.Medium
    ),
    Body_Medium_B = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight.Bold,
    ),
    Body_Small = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Medium
    ),
    Body_Medium_R = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Normal
    ),
    Label_Button = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    Label_Tab = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Medium
    ),
    Caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 10.sp,
        lineHeight = 14.sp,
        fontWeight = FontWeight.Medium
    ),
    Caption_L_B = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    Caption_L_M = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium
    )
)

val LocalCorkChargeTypographyProvider =
    staticCompositionLocalOf { defaultCorkChargeTypography }

// Material3 Typography – 필요하면 그대로 사용
val MaterialTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)
