package com.example.appnfl.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appnfl.data.RepositorioEquipos

@Composable
fun PantallaDetalleEquipo(navController: NavHostController, id: Int){
    //Creamos variable Casa donde almacenar el objeto que se tiene que cargar segun el id que recibe
    //la casa en el fichero de datos de un objeto Equipo en el objeto RepositorioEquipos
    //Para evitar errores de id no validos
    val equipo = RepositorioEquipos.getEquipoById(id)?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = equipo.imagen),
            modifier = Modifier.size(80.dp),
            contentDescription = "Logo del equipo"
        )
        Text(text = equipo.nombre,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(text = equipo.descripcion,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Button(onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Text(text = "Volver")
        }
    }
}

//Cambiar color de fondo y mover la imgen dentro de la pantalla. Tambien que se mantenga al girar pantalla y zoom en la imagen

@Preview
@Composable
fun PreviewPantallaDetalleEquipo(){
    PantallaDetalleEquipo(navController = NavHostController(LocalContext.current), id = 1)

}