package com.btab.kidsapp.model

data class Game(
    val name: GameName,
    val image: String
)

enum class GameName(name: String) {
    ABECEDARIO("Abecedario"),
    ANIMALES("Animales"),
    VOCALES("Vocales"),
    COLORES("Colores"),
    NUMEROS("Números"),
    FORMAS("Formas"),
    COSAS("Cosas"),
    COMIDAS("Comidas"),
    ROPA("Ropa")
}