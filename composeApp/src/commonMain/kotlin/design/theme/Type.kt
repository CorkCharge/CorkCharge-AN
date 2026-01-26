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
import kmp_corkcharge_an.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font

/** 1. KMP Font Loader */
@Composable
fun pretendardFontFamily() = FontFamily(
    Font(Res.font.pretendard_regular, FontWeight.Normal),
    Font(Res.font.pretendard_medium, FontWeight.Medium),
    Font(Res.font.pretendard_bold, FontWeight.Bold),
    Font(Res.font.pretendard_extrabold, FontWeight.ExtraBold)
)

/** 2. Custom Typography Data Class */
@Immutable
data class CorkChargeTypography(
    val Display: TextStyle,
    val HeadLine_XL: TextStyle,
    val HeadLine_Large: TextStyle,
    val HeadLine_Medium_B: TextStyle,
    val HeadLine_Medium_M: TextStyle,
    val HeadLine_Small: TextStyle,
    val Body_Medium_M: TextStyle,
    val Body_Medium_B: TextStyle,
    val Body_Medium_R: TextStyle,
    val Body_Small: TextStyle,
    val Label_Button: TextStyle,
    val Label_Tab: TextStyle,
    val Caption: TextStyle,
    val Caption_L_B: TextStyle,
    val Caption_L_M: TextStyle
)

/** * 3. Typography Factory Function
 * - 이 함수가 FontFamily를 받아 모든 스타일에 일괄 적용합니다.
 */
fun createCorkChargeTypography(fontFamily: FontFamily) = CorkChargeTypography(
    Display = TextStyle(fontFamily = fontFamily, fontSize = 42.sp, lineHeight = 56.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = (-0.01).em),
    HeadLine_XL = TextStyle(fontFamily = fontFamily, fontSize = 30.sp, lineHeight = 44.sp, fontWeight = FontWeight.Bold, letterSpacing = (-0.01).em),
    HeadLine_Large = TextStyle(fontFamily = fontFamily, fontSize = 24.sp, lineHeight = 36.sp, fontWeight = FontWeight.Bold, letterSpacing = (-0.01).em),
    HeadLine_Medium_B = TextStyle(fontFamily = fontFamily, fontSize = 20.sp, lineHeight = 30.sp, fontWeight = FontWeight.Bold),
    HeadLine_Medium_M = TextStyle(fontFamily = fontFamily, fontSize = 20.sp, lineHeight = 30.sp, fontWeight = FontWeight.Medium),
    HeadLine_Small = TextStyle(fontFamily = fontFamily, fontSize = 18.sp, lineHeight = 28.sp, fontWeight = FontWeight.Medium),
    Body_Medium_B = TextStyle(fontFamily = fontFamily, fontSize = 16.sp, lineHeight = 26.sp, fontWeight = FontWeight.Bold),
    Body_Medium_M = TextStyle(fontFamily = fontFamily, fontSize = 16.sp, lineHeight = 26.sp, fontWeight = FontWeight.Medium),
    Body_Medium_R = TextStyle(fontFamily = fontFamily, fontSize = 16.sp, lineHeight = 24.sp, fontWeight = FontWeight.Normal),
    Body_Small = TextStyle(fontFamily = fontFamily, fontSize = 14.sp, lineHeight = 22.sp, fontWeight = FontWeight.Medium),
    Label_Button = TextStyle(fontFamily = fontFamily, fontSize = 18.sp, lineHeight = 24.sp, fontWeight = FontWeight.Bold),
    Label_Tab = TextStyle(fontFamily = fontFamily, fontSize = 14.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium),
    Caption = TextStyle(fontFamily = fontFamily, fontSize = 10.sp, lineHeight = 14.sp, fontWeight = FontWeight.Medium),
    Caption_L_B = TextStyle(fontFamily = fontFamily, fontSize = 12.sp, lineHeight = 16.sp, fontWeight = FontWeight.Bold),
    Caption_L_M = TextStyle(fontFamily = fontFamily, fontSize = 12.sp, lineHeight = 16.sp, fontWeight = FontWeight.Medium)
)

val LocalCorkChargeTypographyProvider = staticCompositionLocalOf { createCorkChargeTypography(FontFamily.Default) }

// Material3 표준 Typography (Pretendard 적용 버전)
fun createMaterialTypography(fontFamily: FontFamily) = Typography(
    bodyLarge = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.5.sp)
    // 필요시 다른 속성 추가
)