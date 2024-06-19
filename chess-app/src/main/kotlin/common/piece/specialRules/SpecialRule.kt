package common.piece.specialRules

import common.board.Board
import common.elements.moveTypes.ClassicMove

interface SpecialRule {
    fun isFulfilled(board: Board, move: ClassicMove): Boolean
}