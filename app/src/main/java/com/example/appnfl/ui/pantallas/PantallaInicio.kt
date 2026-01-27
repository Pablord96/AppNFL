package com.example.appnfl.ui.pantallas

import androidx.compose.foundation.Image // Import necesario para la imagen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size // Import necesario para el tamaño
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource // Import necesario para cargar recursos
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appnfl.R // Asegúrate de que este import apunte a TU paquete R

@Composable
fun PantallaInicio(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- INICIO DE LA IMAGEN ---
        Image(
            painter = painterResource(id = R.drawable.nfl),
            contentDescription = "Logo de la NFL",
            modifier = Modifier
                .size(200.dp) // Define un tamaño para la imagen (puedes ajustarlo)
                .padding(bottom = 16.dp) // Un poco de espacio antes del texto
        )
        // --- FIN DE LA IMAGEN ---

        Text(
            text = "Bienvenido a la app de la NFL",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate("Equipos") }) {
            Text("Ver Equipo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("Info") }) {
            Text("Sobre la App")
        }
    }
}