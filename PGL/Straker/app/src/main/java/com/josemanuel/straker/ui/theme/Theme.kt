
package com.josemanuel.straker.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = StrakerOrange,
    onPrimary = Color.White,
    secondary = StrakerOrangeLight,
    onSecondary = Color(0xFF271006),
    tertiary = StrakerOrangeDark,
    background = StrakerDarkBackground,
    onBackground = StrakerDarkText,
    surface = StrakerDarkSurface,
    onSurface = StrakerDarkText
)

private val LightColorScheme = lightColorScheme(
    primary = StrakerOrange,
    onPrimary = Color.White,
    secondary = StrakerOrangeDark,
    onSecondary = Color.White,
    tertiary = StrakerOrangeLight,
    background = StrakerBackground,
    onBackground = StrakerText,
    surface = StrakerSurface,
    onSurface = StrakerText
)

@Composable
fun StrakerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) {
                androidx.compose.material3.dynamicDarkColorScheme(
                    androidx.compose.ui.platform.LocalContext.current
                )
            } else {
                androidx.compose.material3.dynamicLightColorScheme(
                    androidx.compose.ui.platform.LocalContext.current
                )
            }
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
