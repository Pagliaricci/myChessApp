package checkers.setUps

import checkers.moveRules.CheckersCaptureMove
import checkers.moveRules.CheckersMoves
import common.board.Board
import common.elements.color.Color
import common.elements.position.Position
import common.piece.Piece
import common.piece.PieceType
import common.piece.moveRules.MoveLimitation

class CaptureAndPromotionSetUp {
    fun setUp(): Board {
        return Board(8, 8, emptyMap(), emptySet(), emptyList()).putPieceAt(Position(2, 1), Piece("2 1", Color.WHITE, listOf(CheckersMoves(), MoveLimitation(1, 1, CheckersCaptureMove())), PieceType.PAWN))
            .putPieceAt(Position(6, 6), Piece("3 2", Color.WHITE, listOf(CheckersMoves(), MoveLimitation(1, 1, CheckersCaptureMove())), PieceType.PAWN))
            .putPieceAt(Position(4, 3), Piece("4 3", Color.BLACK, listOf(CheckersMoves(), MoveLimitation(1, 1, CheckersCaptureMove())), PieceType.PAWN))
            .putPieceAt(Position(7, 7), Piece("8 8", Color.BLACK, listOf(CheckersMoves(), MoveLimitation(1, 1, CheckersCaptureMove())), PieceType.PAWN))
            .putPieceAt(Position(6, 5), Piece("6 5", Color.BLACK, listOf(CheckersMoves(), MoveLimitation(1, 1, CheckersCaptureMove())), PieceType.PAWN))
    }
}