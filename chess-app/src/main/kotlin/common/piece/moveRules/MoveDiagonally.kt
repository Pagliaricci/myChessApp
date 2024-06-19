package common.piece.moveRules

import common.board.Board
import common.elements.moveTypes.ClassicMove
import kotlin.math.abs

class MoveDiagonally: MoveRule {
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        return abs(move.from.x - move.to.x) == abs(move.from.y - move.to.y)
    }

    fun movingRight(from: Int, to: Int): Boolean {
        return from < to
    }
    fun movingUp(from: Int, to: Int): Boolean {
        return from < to
    }
}