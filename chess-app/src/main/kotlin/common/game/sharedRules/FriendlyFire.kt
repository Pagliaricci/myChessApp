package common.game.sharedRules

import common.game.GameEngine
import common.game.rules.GameRule
import common.elements.moveTypes.ClassicMove

class FriendlyFire: GameRule {
    override fun isFulfilled(game: GameEngine, move: ClassicMove): Boolean {
        val target = game.getBoard().getPieceAt(move.to)
        if (target != null){
            return move.piece.playersColor != target.playersColor
        }
        return true
    }
}