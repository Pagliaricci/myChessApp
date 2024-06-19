package common.game.gameType.endConditions


import common.game.GameEngine
import common.elements.players.Player

interface EndCondition {
    fun check(game: GameEngine, player: Player): Boolean
}