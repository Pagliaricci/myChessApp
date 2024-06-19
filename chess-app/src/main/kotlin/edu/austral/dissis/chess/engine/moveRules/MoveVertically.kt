package edu.austral.dissis.chess.engine.moveRules

import common.board.Board
import common.piece.moveRules.MoveRule
import common.elements.moveTypes.ClassicMove

class MoveVertically: MoveRule {
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        return move.from.x == move.to.x && move.from.y != move.to.y
    }

    fun movingUp(from: Int, to: Int): Boolean {
        return from < to
    }
}