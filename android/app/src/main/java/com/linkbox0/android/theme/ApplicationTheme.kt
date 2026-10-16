package com.linkbox0.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun ApplicationTheme(
    content: @Composable () -> Unit
) {
    val isDarkTheme = isSystemInDarkTheme()
    val colorScheme =
        if (isDarkTheme)
            BrandDarkColorScheme
        else
            BrandLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
