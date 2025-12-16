package com.example.appnfl.ui.pantallas

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
fun PantallaInfo(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            //Queremos navegar haciar atrás
            onClick = { navController.popBackStack()},
            //Ponemos el botón a la izquierda
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("Vovler")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Desarrollado por Pablo R.D.",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "La mejor APP para ver los mejores equipos de la NFL",
            style = MaterialTheme.typography.titleLarge
        )
    }
}