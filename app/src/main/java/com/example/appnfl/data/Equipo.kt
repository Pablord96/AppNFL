package com.example.appnfl.data

import com.example.appnfl.R

data class Equipo (val id: Int, val nombre: String, val imagen: Int, val descripcion: String)
object RepositorioEquipos{
    val listaEquipos = listOf(
        Equipo(1, "Philadelphia Eagles", R.drawable.eagles, "Equipo ubicado en la ciudad de Philadelphia, con actualmente 2 Superbowls, la última ganada en 2025"),
        Equipo(2, "Las Vegas Raiders", R.drawable.las_vegas, "Equipo ubicado en la ciudad de Las Vegas, con actualmente 3 Superbowls, la última ganada en 1983"),
        Equipo(3, "San Francisco 49ers", R.drawable.san_francisco, "Equipo ubicado en la ciudad de San Francisco, con actualmente 5 Superbowls, la última ganada en 1994")
    )

    //Funcion que devuelva el equipo por id, si no encuentra el quipo devuelve null

    /*
    *  fun getEquipoById(id: Int): Equipo?
    *   for(equipo in listaEquipos){
    *       if(equipo.id == id){
    *           return equipo
    *       }
    * */
    fun getEquipoById(id: Int): Equipo? {
        return listaEquipos.find { it.id == id }
    }
}