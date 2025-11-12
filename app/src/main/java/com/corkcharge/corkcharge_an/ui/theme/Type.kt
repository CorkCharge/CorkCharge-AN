package com.corkcharge.corkcharge_an.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.corkcharge.corkcharge_an.R

val corkChargeFontBold = FontFamily(Font(R.font.pretendard_bold))
val corkChargeFontMedium = FontFamily(Font(R.font.pretendard_medium))
val corkChargeFontExtraBold = FontFamily(Font(R.font.pretendard_extrabold))

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
        fontFamily = corkChargeFontExtraBold,
        fontSize = 42.sp,
        lineHeight = 56.sp,
        letterSpacing = (-0.5f / 42f).em
    ),
    HeadLine_XL = TextStyle(
        fontFamily = corkChargeFontBold,
        fontSize = 30.sp,
        lineHeight = 44.sp,
        letterSpacing = (-0.5f / 30f).em
    ),
    HeadLine_Large = TextStyle(
        fontFamily = corkChargeFontBold,
        fontSize = 24.sp,
        lineHeight = 36.sp,
        letterSpacing = (-0.25f / 24f).em
    ),
    HeadLine_Medium_B = TextStyle(
        fontFamily = corkChargeFontBold,
        fontSize = 20.sp,
        lineHeight = 30.sp,
    ),
    HeadLine_Medium_M = TextStyle(
        fontFamily = corkChargeFontMedium,
        fontSize = 20.sp,
        lineHeight = 30.sp,
    ),
    HeadLine_Small = TextStyle(
        fontFamily = corkChargeFontMedium,
        fontSize = 18.sp,
        lineHeight = 28.sp
    ),
    Body_Medium_M = TextStyle(
        fontFamily = corkChargeFontMedium,
        fontSize = 16.sp,
        lineHeight = 26.sp
    ),
    Body_Medium_B = TextStyle(
        fontFamily = corkChargeFontBold,
        fontSize = 16.sp,
        lineHeight = 26.sp
    ),
    Body_Small = TextStyle(
        fontFamily = corkChargeFontMedium,
        fontSize = 14.sp,
        lineHeight = 22.sp
    ),
    Label_Button = TextStyle(
        fontFamily = corkChargeFontBold,
        fontSize = 18.sp,
        lineHeight = 24.sp
    ),
    Label_Tab = TextStyle(
        fontFamily = corkChargeFontMedium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    Caption = TextStyle(
        fontFamily = corkChargeFontMedium,
        fontSize = 10.sp,
        lineHeight = 14.sp
    ),
    Caption_L_B = TextStyle(
        fontFamily = corkChargeFontBold,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    Caption_L_M = TextStyle(
        fontFamily = corkChargeFontMedium,
        fontSize = 12.sp,
        lineHeight = 16.sp
    )
)

val LocalCorkChargeTypographyProvider = staticCompositionLocalOf { defaultCorkChargeTypography }


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)