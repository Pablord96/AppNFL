package com.example.appnfl

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appnfl.ui.pantallas.PantallaDetalleEquipo
import com.example.appnfl.ui.pantallas.PantallaEquipos
import com.example.appnfl.ui.pantallas.PantallaInfo
import com.example.appnfl.ui.pantallas.PantallaInicio
import com.example.appnfl.ui.theme.AppNFLTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNFLTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()){
                    EquiposApp()
                }
            }
        }
    }
}

@Composable
fun EquiposApp() {
    //creamos un controlador de navegacion
    val navController = rememberNavController()
    //Creamos contenedor de navegación: definir las rutas
    NavHost(navController = navController, startDestination = "Inicio") {
        composable("Inicio") {
            PantallaInicio(navController)
        }
        composable("Equipos") {
            PantallaEquipos(navController)
        }
        composable("Info") {
            PantallaInfo(navController)
        }
        composable(
            "Detalle/{id}", // El {id} actúa como una variable en la URL
            arguments = listOf(
                navArgument("id") { type = NavType.IntType } // Definimos que esa variable es un número entero
            )
        ) { backStackEntry ->
            // Recuperamos el ID de los argumentos de navegación.
            // Si por error viene nulo, usamos el 0 por defecto.
            val id = backStackEntry.arguments?.getInt("id") ?: 0

            // Llamamos a tu pantalla pasando el navController y el id recuperado
            PantallaDetalleEquipo(navController, id)
        }
    }
}
