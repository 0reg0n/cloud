package com.linkbox0.android.util

import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.coroutines.CoroutineScope

val LocalActivityScope = staticCompositionLocalOf<CoroutineScope> {
    error("No activity scope provided")
}
