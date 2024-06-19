package checkers.game.types.endConditions

import common.elements.players.Player
import common.game.GameEngine
import common.game.gameType.endConditions.EndCondition

class CheckersEndCondition: EndCondition {
    override fun check(game: GameEngine, player: Player): Boolean {
        val board = game.getBoard()
        val playersPieces = board.getPieces().filter { it.playersColor == player.getColor()}
        return playersPieces.isEmpty()
    }
}