package edu.austral.dissis.chess.engine.moveRules

import common.board.Board
import common.piece.moveRules.MoveRule
import common.piece.moveRules.MoveDiagonally
import common.elements.moveTypes.ClassicMove

class KingMoves: MoveRule {
    private val vertical = MoveVertically()
    private val horizontal = MoveHorizontally()
    private val diagonal = MoveDiagonally()
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        return vertical.isFulfilled(board,move) || horizontal.isFulfilled(board,move) || diagonal.isFulfilled(board,move)
    }

}