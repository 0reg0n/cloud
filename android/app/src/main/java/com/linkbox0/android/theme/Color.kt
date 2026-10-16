package com.linkbox0.android.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val BrandBlue = Color(0xFF2F6BFF)
val BrandBlueDark = Color(0xFF2358D8)
val BrandBlueSoft = Color(0xFFEAF1FF)
val BrandGreen = Color(0xFF22C55E)
val BrandGreenText = Color(0xFF1F9D55)
val BrandBackground = Color(0xFFF4F6F9)
val BrandSurface = Color(0xFFFFFFFF)
val BrandText = Color(0xFF1F2733)
val BrandMuted = Color(0xFF8B95A7)
val BrandVariant = Color(0xFFEEF1F5)
val BrandOutline = Color(0xFFDFE5EE)
val BrandRed = Color(0xFFD64545)

val BrandLightColorScheme = lightColorScheme(
    primary = BrandBlue,
    onPrimary = Color.White,
    primaryContainer = BrandBlueSoft,
    onPrimaryContainer = Color(0xFF0B2A6B),
    secondary = BrandGreenText,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFE7F7EE),
    onSecondaryContainer = Color(0xFF0F5132),
    background = BrandBackground,
    onBackground = BrandText,
    surface = BrandSurface,
    onSurface = BrandText,
    surfaceVariant = BrandVariant,
    onSurfaceVariant = Color(0xFF64748B),
    outline = BrandOutline,
    error = BrandRed,
    onError = Color.White,
)

val BrandDarkColorScheme = darkColorScheme(
    primary = Color(0xFF6D8BFF),
    onPrimary = Color(0xFF0B1B3A),
    primaryContainer = Color(0xFF1B2B4D),
    onPrimaryContainer = Color(0xFFD7E2FF),
    secondary = BrandGreen,
    onSecondary = Color(0xFF06281A),
    secondaryContainer = Color(0xFF123524),
    onSecondaryContainer = Color(0xFFC9F2D8),
    background = Color(0xFF12161C),
    onBackground = Color(0xFFE7ECF3),
    surface = Color(0xFF1A1F27),
    onSurface = Color(0xFFE7ECF3),
    surfaceVariant = Color(0xFF252C36),
    onSurfaceVariant = Color(0xFFA6B0BF),
    outline = Color(0xFF3A424E),
    error = Color(0xFFE57373),
    onError = Color(0xFF3A0A0A),
)
