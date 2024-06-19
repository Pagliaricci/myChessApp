package edu.austral.dissis.chess.engine.moveRules

import common.board.Board
import common.piece.moveRules.MoveRule
import common.piece.moveRules.MoveDiagonally
import common.elements.moveTypes.ClassicMove

class QueenMoves: MoveRule {
    val moves = listOf(
        MoveVerticalORHorizontal(),
        MoveDiagonally()
    )

    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        return moves.any { it.isFulfilled(board, move) }
    }

}