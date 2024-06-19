package common.piece.moveRules

import common.board.Board
import common.elements.moveTypes.ClassicMove

interface MoveRule {
    fun isFulfilled(board: Board, move: ClassicMove): Boolean

}