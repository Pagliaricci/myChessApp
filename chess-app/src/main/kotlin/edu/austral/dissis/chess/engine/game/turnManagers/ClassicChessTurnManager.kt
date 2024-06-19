package edu.austral.dissis.chess.engine.game.turnManagers

import common.game.GameEngine
import common.game.turnManager.TurnManager
import common.elements.players.Player

class ClassicChessTurnManager( val player: Player): TurnManager {

    override fun whoseTurnIsIt(): Player {
        return player
    }
    override fun nextTurn(game: GameEngine): ClassicChessTurnManager {
        val players = game.getPlayers()
        if (player == players[0]){
            return ClassicChessTurnManager(players[1])
        }
        return ClassicChessTurnManager(players[0])
        }

    override fun getOpponent(game: GameEngine): Player {
        val players = game.getPlayers()
        if (player == players[0]){
            return players[1]
        }
        return players[0]
    }
}

