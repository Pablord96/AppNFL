package com.example.appnfl.data

import com.example.appnfl.R

data class Equipo (val id: Int, val nombre: String, val imagen: Int, val descripcion: String)
object RepositorioEquipos{
    val listaEquipos = listOf(
        // AFC East
        Equipo(1, "Buffalo Bills", R.drawable.bills, "Equipo ubicado en la ciudad de Buffalo (New York), actualmente con 0 Superbowls."),
        Equipo(2, "Miami Dolphins", R.drawable.dolphins, "Equipo ubicado en la ciudad de Miami, con actualmente 2 Superbowls, la última ganada en 1973"),
        Equipo(3, "New England Patriots", R.drawable.patriots, "Equipo ubicado en el área de Boston (Foxborough), con actualmente 6 Superbowls, la última ganada en 2018"),
        Equipo(4, "New York Jets", R.drawable.jets, "Equipo ubicado en el área de New York, con actualmente 1 Superbowl, ganada en 1968"),

        // AFC North
        Equipo(5, "Baltimore Ravens", R.drawable.ravens, "Equipo ubicado en la ciudad de Baltimore, con actualmente 2 Superbowls, la última ganada en 2012"),
        Equipo(6, "Cincinnati Bengals", R.drawable.bengals, "Equipo ubicado en la ciudad de Cincinnati, actualmente con 0 Superbowls."),
        Equipo(7, "Cleveland Browns", R.drawable.browns, "Equipo ubicado en la ciudad de Cleveland, actualmente con 0 Superbowls."),
        Equipo(8, "Pittsburgh Steelers", R.drawable.steelers, "Equipo ubicado en la ciudad de Pittsburgh, con actualmente 6 Superbowls, la última ganada en 2008"),

        // AFC South
        Equipo(9, "Houston Texans", R.drawable.texans, "Equipo ubicado en la ciudad de Houston, actualmente con 0 Superbowls."),
        Equipo(10, "Indianapolis Colts", R.drawable.colts, "Equipo ubicado en la ciudad de Indianapolis, con actualmente 2 Superbowls, la última ganada en 2006"),
        Equipo(11, "Jacksonville Jaguars", R.drawable.jaguars, "Equipo ubicado en la ciudad de Jacksonville, actualmente con 0 Superbowls."),
        Equipo(12, "Tennessee Titans", R.drawable.titans, "Equipo ubicado en la ciudad de Nashville, actualmente con 0 Superbowls."),

        // AFC West
        Equipo(13, "Denver Broncos", R.drawable.broncos, "Equipo ubicado en la ciudad de Denver, con actualmente 3 Superbowls, la última ganada en 2015"),
        Equipo(14, "Kansas City Chiefs", R.drawable.chiefs, "Equipo ubicado en la ciudad de Kansas City, con actualmente 4 Superbowls, la última ganada en 2024"),
        Equipo(15, "Las Vegas Raiders", R.drawable.raiders, "Equipo ubicado en la ciudad de Las Vegas, con actualmente 3 Superbowls, la última ganada en 1983"),
        Equipo(16, "Los Angeles Chargers", R.drawable.chargers, "Equipo ubicado en la ciudad de Los Angeles, actualmente con 0 Superbowls."),

        // NFC East
        Equipo(17, "Dallas Cowboys", R.drawable.cowboys, "Equipo ubicado en el área de Dallas, con actualmente 5 Superbowls, la última ganada en 1995"),
        Equipo(18, "New York Giants", R.drawable.giants, "Equipo ubicado en el área de New York, con actualmente 4 Superbowls, la última ganada en 2011"),
        Equipo(19, "Philadelphia Eagles", R.drawable.eagles, "Equipo ubicado en la ciudad de Philadelphia, con actualmente 2 Superbowls, la última ganada en 2025"),
        Equipo(20, "Washington Commanders", R.drawable.commanders, "Equipo ubicado en el área de Washington D.C., con actualmente 3 Superbowls, la última ganada en 1991"),

        // NFC North
        Equipo(21, "Chicago Bears", R.drawable.bears, "Equipo ubicado en la ciudad de Chicago, con actualmente 1 Superbowl, ganada en 1985"),
        Equipo(22, "Detroit Lions", R.drawable.lions, "Equipo ubicado en la ciudad de Detroit, actualmente con 0 Superbowls."),
        Equipo(23, "Green Bay Packers", R.drawable.packers, "Equipo ubicado en la ciudad de Green Bay, con actualmente 4 Superbowls, la última ganada en 2010"),
        Equipo(24, "Minnesota Vikings", R.drawable.vikings, "Equipo ubicado en la ciudad de Minneapolis, actualmente con 0 Superbowls."),

        // NFC South
        Equipo(25, "Atlanta Falcons", R.drawable.falcons, "Equipo ubicado en la ciudad de Atlanta, actualmente con 0 Superbowls."),
        Equipo(26, "Carolina Panthers", R.drawable.panthers, "Equipo ubicado en la ciudad de Charlotte, actualmente con 0 Superbowls."),
        Equipo(27, "New Orleans Saints", R.drawable.saints, "Equipo ubicado en la ciudad de New Orleans, con actualmente 1 Superbowl, ganada en 2009"),
        Equipo(28, "Tampa Bay Buccaneers", R.drawable.buccaneers, "Equipo ubicado en la ciudad de Tampa, con actualmente 2 Superbowls, la última ganada en 2020"),

        // NFC West
        Equipo(29, "Arizona Cardinals", R.drawable.cardinals, "Equipo ubicado en el área de Phoenix, actualmente con 0 Superbowls."),
        Equipo(30, "Los Angeles Rams", R.drawable.rams, "Equipo ubicado en la ciudad de Los Angeles, con actualmente 2 Superbowls, la última ganada en 2021"),
        Equipo(31, "San Francisco 49ers", R.drawable.niners, "Equipo ubicado en el área de San Francisco, con actualmente 5 Superbowls, la última ganada en 1994"),
        Equipo(32, "Seattle Seahawks", R.drawable.seahawks, "Equipo ubicado en la ciudad de Seattle, con actualmente 1 Superbowl, ganada en 2013")
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