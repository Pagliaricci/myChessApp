package common.ui.adapters

import common.elements.color.Color
import edu.austral.dissis.chess.gui.PlayerColor

class ColorAdapter {
    fun translatePlayerColor(color: Color): PlayerColor {
        return when (color) {
            Color.WHITE -> PlayerColor.WHITE
            Color.BLACK -> PlayerColor.BLACK
        }

    }

}