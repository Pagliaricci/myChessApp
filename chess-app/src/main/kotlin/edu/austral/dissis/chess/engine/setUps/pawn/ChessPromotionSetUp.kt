package edu.austral.dissis.chess.engine.setUps.pawn

import common.board.Board
import common.elements.color.Color
import common.piece.Piece
import common.piece.PieceType
import common.piece.moveRules.MoveLimitation
import common.elements.position.Position
import edu.austral.dissis.chess.engine.moveRules.PawnMovesComposite
import edu.austral.dissis.chess.engine.moveRules.specialRules.DoublePawnMove

class ChessPromotionSetUp {
    var map = emptyMap<Position, Piece>()
    var pieces = emptySet<Piece>()
    var board = Board(8, 8, map, pieces, emptyList())

    fun setUp(): Board {
        val wPiece = Piece("1 7", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
        board = board.putPieceAt(Position(1, 7), wPiece)
        return board
    }
}