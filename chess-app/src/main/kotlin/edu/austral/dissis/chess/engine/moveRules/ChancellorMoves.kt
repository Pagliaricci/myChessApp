package edu.austral.dissis.chess.engine.moveRules

import common.board.Board
import common.elements.moveTypes.ClassicMove
import common.piece.moveRules.MoveRule

class ChancellorMoves: MoveRule {
    private val lShapeMove = MoveLShape()
    private val rookMove = MoveVerticalORHorizontal()
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        return lShapeMove.isFulfilled(board, move) || rookMove.isFulfilled(board, move)
    }

}