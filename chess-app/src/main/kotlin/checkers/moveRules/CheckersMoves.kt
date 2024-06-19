package checkers.moveRules

import common.board.Board
import common.elements.moveTypes.ClassicMove
import common.piece.moveRules.*
import common.piece.moveRules.MoveRule

class CheckersMoves:MoveRule {
    private val diagonal = MoveDiagonally()
    private val forward = MoveForward()

    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        return diagonal.isFulfilled(board, move) && forward.isFulfilled(board, move)
    }

}