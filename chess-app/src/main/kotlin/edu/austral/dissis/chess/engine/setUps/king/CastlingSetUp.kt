package edu.austral.dissis.chess.engine.setUps.king

import common.board.Board
import common.elements.color.Color
import common.piece.Piece
import common.piece.PieceType
import common.piece.moveRules.MoveLimitation
import common.elements.position.Position
import edu.austral.dissis.chess.engine.moveRules.KingMoves
import edu.austral.dissis.chess.engine.moveRules.MoveVerticalORHorizontal
import edu.austral.dissis.chess.engine.moveRules.specialRules.Castling

class CastlingSetUp {
    var map = emptyMap<Position, Piece>()
    var pieces = emptySet<Piece>()
    var board = Board(8, 8, map, pieces, emptyList())

    fun setUp(): Board {
        val wRook1 = Piece("1 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
        board = board.putPieceAt(Position(1, 1), wRook1)
        val wRook2 = Piece("8 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
        board = board.putPieceAt(Position(8, 1), wRook2)
        val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
        board = board.putPieceAt(Position(1, 8), bRook1)
        val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
        board = board.putPieceAt(Position(8, 8), bRook2)
        val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
        board = board.putPieceAt(Position(5, 1), wKing)
        val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1,Castling())), PieceType.KING )
        board = board.putPieceAt(Position(5, 8), bKing)
        return board
    }
}