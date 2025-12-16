package com.example.appnfl.ui.pantallas

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.items // IMPORTANTE: Necesario para usar items con una lista
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appnfl.data.RepositorioEquipos

@Composable
fun PantallaEquipos(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        // --- CABECERA ---
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Equipos",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(5.dp))

        // --- LISTA CON SECCIONES (Scrollable) ---
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Ocupa todo el espacio disponible empujando el botón abajo
                .padding(vertical = 10.dp)
        ) {
            // Recorremos el mapa de divisiones que creamos en RepositorioEquipos
            RepositorioEquipos.divisiones.forEach { (nombreDivision, equiposDeEsaDivision) ->

                // 1. TÍTULO DE LA DIVISIÓN (Cabecera)
                item {
                    Text(
                        text = nombreDivision, // Ej: "AFC East"
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, bottom = 8.dp, start = 10.dp)
                    )
                }

                // 2. ITEMS (Equipos de esa división)
                items(equiposDeEsaDivision) { equipo ->
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp) // Un poco de margen entre tarjetas
                            .fillMaxWidth()
                            .clickable { navController.navigate("Detalle/${equipo.id}") }
                    ) {
                        Row(
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = equipo.imagen),
                                modifier = Modifier.size(80.dp),
                                contentDescription = "Logo del equipo"
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = equipo.nombre,
                                    style = MaterialTheme.typography.titleLarge
                                )
                                Text(
                                    text = equipo.descripcion,
                                    maxLines = 4,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        }

        // --- BOTÓN INFERIOR (Fijo) ---
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                // Esto evita que la barra de navegación del sistema tape el botón
                .navigationBarsPadding()
                .padding(bottom = 20.dp)
        ) {
            Text("Volver")
        }
    }
}