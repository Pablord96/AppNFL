package com.example.appnfl.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = NFLBlueLight,
    onPrimary = Color.White,
    secondary = NFLRedLight,
    onSecondary = Color.Black,
    tertiary = NFLSilver,
    background = NFLDarkBackground,
    surface = NFLDarkBackground
)

private val LightColorScheme = lightColorScheme(
    primary = NFLBlue,
    onPrimary = Color.White,
    secondary = NFLRed,
    onSecondary = Color.White,
    tertiary = NFLSilver,
    background = Color(0xFFF2F2F2), // Un gris muy suave de fondo
    surface = Color.White

    /* Puedes sobrescribir más colores si lo necesitas */
)

@Composable
fun AppNFLTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // IMPORTANTE: Ponemos esto en false para forzar los colores de la NFL
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
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