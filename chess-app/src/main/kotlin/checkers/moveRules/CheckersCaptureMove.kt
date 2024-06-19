package checkers.moveRules

import common.board.Board
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import common.piece.specialRules.SpecialRule
import kotlin.math.abs

class CheckersCaptureMove: SpecialRule{
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        if ( abs(move.from.x - move.to.x) != 2 || abs(move.from.y - move.to.y) != 2 ) return false
        val middlePos = Position((move.from.x + move.to.x) / 2, (move.from.y + move.to.y) / 2)
        return board.getPieceAt(middlePos) != null && board.getPieceAt(middlePos)!!.playersColor != move.piece.playersColor
    }
}