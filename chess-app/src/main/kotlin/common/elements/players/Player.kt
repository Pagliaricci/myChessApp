package common.elements.players

import common.elements.color.Color

class Player( private val color: Color) {
    fun getColor(): Color {
        return color
    }
}
