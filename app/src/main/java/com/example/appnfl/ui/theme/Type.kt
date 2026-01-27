package com.example.appnfl.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    // Estilo para texto normal
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    // Estilo para Títulos (ej. "Bienvenido a la app...")
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default, // Si tienes una fuente "Slab" o "Block", úsala aquí
        fontWeight = FontWeight.ExtraBold, // Muy negrita para impacto deportivo
        fontSize = 28.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    // Estilo para Botones
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp, // Botones más grandes
        letterSpacing = 1.sp // Espaciado para legibilidad
    )
)