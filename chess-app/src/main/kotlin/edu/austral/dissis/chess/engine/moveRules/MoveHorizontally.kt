package edu.austral.dissis.chess.engine.moveRules

import common.board.Board
import common.piece.moveRules.MoveRule
import common.elements.moveTypes.ClassicMove

class MoveHorizontally: MoveRule {
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        return move.from.y == move.to.y && move.from.x != move.to.x
    }

fun movingRight(from: Int, to: Int): Boolean {
        return from < to
    }

}