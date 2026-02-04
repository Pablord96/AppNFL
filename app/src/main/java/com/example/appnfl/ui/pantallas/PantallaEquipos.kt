package com.example.appnfl.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape // Necesario para bordes
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults // Para estilizar el botón de volver si quieres
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip // Necesario para recortar la imagen
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appnfl.data.RepositorioEquipos
// Asegúrate de importar tu clase de datos del equipo si está en otro paquete (ej: com.example.appnfl.data.Equipo)

@Composable
fun PantallaEquipos(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            // Usamos el color de fondo gris claro definido en tu Theme (background)
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
    ) {
        // --- CABECERA ---
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Equipos NFL", // Un poco más específico
            style = MaterialTheme.typography.displaySmall, // Estilo muy grande para encabezado principal
            color = MaterialTheme.colorScheme.primary, // Azul NFL
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(5.dp))

        // --- LISTA CON SECCIONES ---
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(vertical = 10.dp)
        ) {
            RepositorioEquipos.divisiones.forEach { (nombreDivision, equiposDeEsaDivision) ->

                // 1. TÍTULO DE LA DIVISIÓN
                item {
                    Text(
                        text = nombreDivision,
                        style = MaterialTheme.typography.headlineSmall, // Fuente gruesa
                        color = MaterialTheme.colorScheme.secondary, // Rojo NFL para diferenciar secciones
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp, bottom = 12.dp, start = 8.dp)
                    )
                }

                // 2. ITEMS (Usando el componente personalizado de abajo)
                items(equiposDeEsaDivision) { equipo ->
                    ItemEquipo(
                        equipo = equipo,
                        onClick = { navController.navigate("Detalle/${equipo.id}") }
                    )
                }
            }
        }

        // --- BOTÓN INFERIOR ---
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .navigationBarsPadding()
                .padding(bottom = 20.dp),
            // Opcional: Hacer el botón "Rojo" (secondary) para salir/volver
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Text("Volver", style = MaterialTheme.typography.labelLarge)
        }
    }
}

// --- COMPONENTE DE TARJETA PERSONALIZADO ---
// Al sacarlo fuera, el código de arriba queda mucho más limpio
@Composable
fun ItemEquipo(
    equipo: com.example.appnfl.data.Equipo, // Asegúrate que 'Equipo' es la clase correcta de tu data class
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 6.dp) // Margen externo
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), // Sombra para efecto 3D
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface, // Fondo Blanco (definido en Theme)
        ),
        shape = RoundedCornerShape(16.dp) // Bordes redondeados modernos
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp) // Padding interno (espacio dentro de la tarjeta)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen del Logo estilizada
            Image(
                painter = painterResource(id = equipo.imagen),
                contentDescription = "Logo de ${equipo.nombre}",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(70.dp)
                    // Opcional: Si los logos no tienen fondo transparente, esto ayuda
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                // Título del Equipo (Usa la fuente "Blocky" y Azul NFL)
                Text(
                    text = equipo.nombre,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                // Descripción pequeña
                Text(
                    text = equipo.descripcion,
                    maxLines = 2, // Limitamos a 2 líneas para que las tarjetas sean uniformes
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f) // Gris oscuro
                )
            }
        }
    }
}