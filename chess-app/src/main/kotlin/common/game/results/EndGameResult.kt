package common.game.results


import common.game.GameEngine
import common.elements.players.Player

class EndGameResult(private val game: GameEngine, private val  player: Player, private val message: String):
    GameResult {
    override fun getGame(): GameEngine {
        return game
    }

    override fun getCurrentPlayersTurn(): Player {
        return player
    }

    override fun getMessage(): String{
        return message
    }
}