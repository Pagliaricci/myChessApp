package common.piece.moveRules

import common.board.Board
import common.piece.specialRules.SpecialRule
import common.elements.moveTypes.ClassicMove
import kotlin.math.abs

class MoveLimitation(private val xMax : Int, private val yMax: Int, private val specialMove : SpecialRule?): MoveRule {
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        if(specialMove != null && specialMove.isFulfilled(board, move)) return true
        if(abs(move.from.x - move.to.x) <= xMax && abs(move.from.y - move.to.y) <= yMax) {
            return true
        }
        return false
    }
}