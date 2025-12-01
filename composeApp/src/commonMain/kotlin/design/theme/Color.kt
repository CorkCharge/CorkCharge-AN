package design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// gray
val PrimaryColor = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Gray1 = Color(0xFFF9F9FA)
val Gray2 = Color(0xFFECEDEF)
val Gray3 = Color(0xFFDBDDE1)
val Gray4 = Color(0xFFC5C8CF)
val Gray5 = Color(0xFF9FA2AA)
val Gray6 = Color(0xFF80818B)
val Gray7 = Color(0xFF585A68)
val Gray8 = Color(0xFF35353F)

// primary, secondary, point
val BurgundyLight = Color(0xFFE75257)
val BurgundyMedium = Color(0xFFC4363F)
val Burgundy = Color(0xFF90212A)
val BurgundyDark = Color(0xFF3A0D10)

val Sand = Color(0xFFDACBB6)
val SandSoft = Color(0x80DACBB6)
val Glass = Color(0xFFDCDBE8)
val GlassSoft = Color(0x80DCDBE8)

val Olive = Color(0xFF749755)
val OliveSoft = Color(0x80749755)

@Immutable
data class CorkChargeColors(
    val primaryColor: Color,
    val black: Color,
    val gray1: Color,
    val gray2: Color,
    val gray3: Color,
    val gray4: Color,
    val gray5: Color,
    val gray6: Color,
    val gray7: Color,
    val gray8: Color,
    val burgundyLight: Color,
    val burgundyMedium: Color,
    val burgundy: Color,
    val burgundyDark: Color,
    val sand: Color,
    val sandSoft: Color,
    val glass: Color,
    val glassSoft: Color,
    val olive: Color,
    val oliveSoft: Color,
)

val defaultCorkChargeColors = CorkChargeColors(
    primaryColor = PrimaryColor,
    black = Black,
    gray1 = Gray1,
    gray2 = Gray2,
    gray3 = Gray3,
    gray4 = Gray4,
    gray5 = Gray5,
    gray6 = Gray6,
    gray7 = Gray7,
    gray8 = Gray8,
    burgundyLight = BurgundyLight,
    burgundyMedium = BurgundyMedium,
    burgundy = Burgundy,
    burgundyDark = BurgundyDark,
    sand = Sand,
    sandSoft = SandSoft,
    glass = Glass,
    glassSoft = GlassSoft,
    olive = Olive,
    oliveSoft = OliveSoft,
)

val LocalCorkChargeColorsProvider =
    staticCompositionLocalOf { defaultCorkChargeColors }

// Material ColorScheme에서 쓰던 보라색들도 그대로 유지
val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
