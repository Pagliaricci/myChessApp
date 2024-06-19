package edu.austral.dissis.chess.engine.moveRules

import common.board.Board
import common.piece.moveRules.MoveRule
import common.elements.moveTypes.ClassicMove

class MoveVerticalORHorizontal: MoveRule {
    private val vertical = MoveVertically()
    private val horizontal = MoveHorizontally()
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        return vertical.isFulfilled(board, move) || horizontal.isFulfilled(board, move)
    }
}