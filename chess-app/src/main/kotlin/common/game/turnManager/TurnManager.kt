package common.game.turnManager

import common.game.GameEngine
import common.elements.players.Player

interface TurnManager {
    fun whoseTurnIsIt(): Player
    fun nextTurn(game: GameEngine): TurnManager
    fun getOpponent(game: GameEngine): Player
}