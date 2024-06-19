package common.game.rules


import common.game.GameEngine
import common.elements.moveTypes.ClassicMove

interface GameRule {
    fun isFulfilled(game: GameEngine, move: ClassicMove): Boolean
}