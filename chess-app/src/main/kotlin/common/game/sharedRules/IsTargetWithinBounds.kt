package common.game.sharedRules

import common.board.Board
import common.game.GameEngine
import common.game.rules.GameRule
import common.elements.moveTypes.ClassicMove

class IsTargetWithinBounds: GameRule {
    override fun isFulfilled(game :GameEngine, move: ClassicMove): Boolean {
        val board = game.getBoard()
        val target = move.to
        return (target.x > 0 && target.x <= board.maxRow) && (target.y >0 && target.y <= board.maxCol)
    }
}