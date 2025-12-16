package com.example.appnfl.ui.pantallas

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
fun PantallaEquipos(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
        ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Equipos",
            style = MaterialTheme.typography.headlineLarge,
            // Añade estas dos líneas para centrar el texto
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(5.dp))
        //Lista de Equipos
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            items(RepositorioEquipos.listaEquipos.size){
                index:Int->val equipo = RepositorioEquipos.listaEquipos[index]
                //Con cada elemento de la lista queremos meterlo en un Card
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable {navController.navigate("Detalle/${equipo.id}")}
                ){
                    Row(
                        modifier = Modifier
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = equipo.imagen),
                            modifier = Modifier.size(80.dp),
                            contentDescription = "Logo del equipo"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = equipo.nombre, style = MaterialTheme.typography.titleLarge)
                            //Descripcion del equipo
                            Text(text = equipo.descripcion, maxLines = 4)
                        }
                    }
                }
            }//Items
            //Boton tiene que estar dentro de un Item
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    //Queremos navegar haciar atrás
                    onClick = { navController.popBackStack()},
                    //Ponemos el botón a la izquierda
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Text("Vovler")
                }
            }
        }
    }
}