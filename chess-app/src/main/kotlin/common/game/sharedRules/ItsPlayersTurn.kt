package common.game.sharedRules

import common.game.GameEngine
import common.game.rules.GameRule
import common.elements.moveTypes.ClassicMove

class ItsPlayersTurn: GameRule {
    override fun isFulfilled(game: GameEngine, move: ClassicMove): Boolean {
        return game.getCurrentPlayer().getColor() == move.piece.playersColor
    }
}