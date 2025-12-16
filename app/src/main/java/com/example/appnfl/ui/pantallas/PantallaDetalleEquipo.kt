package com.example.appnfl.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appnfl.data.RepositorioEquipos
import kotlin.random.Random

// 1. Necesitamos este Saver fuera para poder guardar la posición (Offset) al girar
val OffsetSaver = Saver<Offset, Pair<Float, Float>>(
    save = { Pair(it.x, it.y) },
    restore = { (x, y) -> Offset(x, y) }
)

@Composable
fun PantallaDetalleEquipo(navController: NavHostController, id: Int) {
    val equipo = RepositorioEquipos.getEquipoById(id) ?: return

    // --- ESTADOS QUE SOBREVIVEN AL GIRO (rememberSaveable) ---

    // 1. Color de fondo (Guardamos el entero ARGB)
    var colorFondoInt by rememberSaveable { mutableIntStateOf(Color.White.toArgb()) }
    val colorFondo = Color(colorFondoInt)

    // 2. Escala (Zoom)
    var scale by rememberSaveable { mutableFloatStateOf(1f) }

    // 3. Posición (Pan/Movimiento) - Usa nuestro Saver personalizado
    var offset by rememberSaveable(stateSaver = OffsetSaver) { mutableStateOf(Offset.Zero) }

    // --- INTERFAZ ---

    // Usamos Box para que el color de fondo ocupe todo
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                // Esto permite scroll si al hacer zoom o girar el contenido es muy alto
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center, // Centrado Vertical
            horizontalAlignment = Alignment.CenterHorizontally // Centrado Horizontal
        ) {
            // IMAGEN INTERACTIVA
            // Envolvemos la imagen en un Box para capturar los gestos solo en esa zona
            Box(
                modifier = Modifier
                    .size(250.dp) // Tamaño del contenedor de la imagen
                    // GESTO DE RESET (Doble toque)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onDoubleTap = {
                                scale = 1f
                                offset = Offset.Zero
                            }
                        )
                    }
                    // GESTO DE ZOOM Y MOVIMIENTO
                    .pointerInput(Unit) {
                        detectTransformGestures { _, pan, zoom, _ ->
                            scale = (scale * zoom).coerceIn(0.5f, 4f) // Límites del zoom
                            // Movemos la imagen teniendo en cuenta la escala actual
                            val x = pan.x * scale
                            val y = pan.y * scale
                            offset += Offset(x, y)
                        }
                    }
            ) {
                Image(
                    painter = painterResource(id = equipo.imagen),
                    contentDescription = "Logo del equipo",
                    modifier = Modifier
                        .fillMaxSize()
                        // APLICAMOS LAS TRANSFORMACIONES AQUÍ
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
                            translationX = offset.x,
                            translationY = offset.y
                        )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = equipo.nombre,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = equipo.descripcion,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // BOTÓN CAMBIAR FONDO
            Button(
                onClick = {
                    // Genera un color aleatorio totalmente opaco
                    val randomColor = Color(
                        red = Random.nextInt(256),
                        green = Random.nextInt(256),
                        blue = Random.nextInt(256),
                        alpha = 255
                    )
                    colorFondoInt = randomColor.toArgb()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
            ) {
                Text(text = "Cambiar Fondo")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // BOTÓN VOLVER
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
            ) {
                Text(text = "Volver")
            }
        }
    }
}