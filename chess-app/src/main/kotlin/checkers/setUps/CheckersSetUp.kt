package checkers.setUps

import checkers.moveRules.CheckersCaptureMove
import checkers.moveRules.CheckersMoves
import common.board.Board
import common.elements.color.Color
import common.elements.position.Position
import common.piece.Piece
import common.piece.PieceType
import common.piece.moveRules.MoveLimitation

class CheckersSetUp {

    fun setUp(): Board {
        val map = mutableMapOf<Position, Piece>()
        val pieces = mutableSetOf<Piece>()
        for (i in 1..8) {
            for (j in 1..8) {
                if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
                    if (i <= 3) {
                        val piece = Piece("$i$j", Color.WHITE, listOf(CheckersMoves(), MoveLimitation(1, 1, CheckersCaptureMove())), PieceType.PAWN)
                        map[Position(j, i)] = piece
                        pieces.add(piece)
                    } else if (i >= 6) {
                        val piece = Piece("$i$j", Color.BLACK, listOf(CheckersMoves(), MoveLimitation(1, 1, CheckersCaptureMove())), PieceType.PAWN)
                        map[Position(j, i)] = piece
                        pieces.add(piece)
                    }
                }
            }
        }
        return Board(8, 8, map, pieces, emptyList())
    }

}