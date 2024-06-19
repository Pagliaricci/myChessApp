package common.piece.moveRules

import common.board.Board
import common.elements.color.Color
import common.elements.moveTypes.ClassicMove

class MoveForward: MoveRule {
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {

        return if (move.piece.playersColor == Color.WHITE) {
            move.from.y < move.to.y
        } else {
            move.from.y > move.to.y
        }
    }

}