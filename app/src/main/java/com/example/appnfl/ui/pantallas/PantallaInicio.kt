package com.example.appnfl.ui.pantallas

//Definir una pantalla principal con dos botones de ver equipo y el otro que sea sobre la app y un texto encima de los botones que ponga bienvenido a la app de la NFL

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PantallaInicio(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenido a la app de la NFL", // Opcionalmente, usa un recurso de string: stringResource(R.string.bienvenido)
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate("Equipos") }) {
            Text("Ver Equipo") // Opcionalmente, usa un recurso de string: stringResource(R.string.ver_equipo)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("Info") }) {
            Text("Sobre la App") // Opcionalmente, usa un recurso de string: stringResource(R.string.sobre_la_app)
        }
    }
}
