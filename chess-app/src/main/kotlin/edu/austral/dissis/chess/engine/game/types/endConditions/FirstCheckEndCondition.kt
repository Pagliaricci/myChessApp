package edu.austral.dissis.chess.engine.game.types.endConditions

import common.elements.players.Player
import common.game.GameEngine
import common.game.gameType.endConditions.EndCondition
import edu.austral.dissis.chess.engine.game.rules.CheckValidator

class FirstCheckEndCondition:EndCondition {
    override fun check(game: GameEngine, player: Player): Boolean {
        return checkWin(game,player)
    }

    private fun checkWin(game: GameEngine, player: Player): Boolean {
        return CheckValidator().playerIsInCheck(game.getBoard(),player)
    }
}