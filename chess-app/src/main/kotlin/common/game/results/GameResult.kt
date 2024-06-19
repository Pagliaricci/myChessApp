package common.game.results

import common.game.GameEngine
import common.elements.players.Player

interface GameResult {
    fun getGame(): GameEngine
    fun getCurrentPlayersTurn(): Player
    fun getMessage(): String
}