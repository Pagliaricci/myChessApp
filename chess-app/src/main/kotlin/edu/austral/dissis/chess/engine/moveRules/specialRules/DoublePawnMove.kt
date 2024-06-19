package edu.austral.dissis.chess.engine.moveRules.specialRules

import common.board.Board
import common.elements.color.Color
import common.piece.specialRules.SpecialRule
import common.elements.moveTypes.ClassicMove

class DoublePawnMove: SpecialRule {
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        val piece = board.getPieceAt(move.from)
        return if(piece!!.playersColor == Color.WHITE) {
            move.from.y == 2 && move.to.y == 4
        } else {
            move.from.y == 7 && move.to.y == 5
        }
    }
}