package com.example.appnfl

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.appnfl.ui.pantallas.PantallaInicio
import com.example.appnfl.ui.theme.AppNFLTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNFLTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()){ innerPadding ->
                    EquiposApp()
        }
    }
}

@Composable
fun EquiposApp() {
    //creamos un controlador de navegacion
    val navController = rememberNavController()
    //Creamos contenedor de navegación: definir las rutas
    NavHost(NavHostController = navController, startDestination = "Inicio") {
        composable("Inicio") {
            PantallaInicio(navController = navController)
        }
    }
}}