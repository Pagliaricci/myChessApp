package edu.austral.dissis.chess.engine.setUps

import common.board.Board
import common.elements.color.Color
import common.piece.Piece
import common.piece.PieceType
import common.piece.moveRules.MoveDiagonally
import common.piece.moveRules.MoveLimitation
import common.elements.position.Position
import edu.austral.dissis.chess.engine.moveRules.*
import edu.austral.dissis.chess.engine.moveRules.specialRules.Castling
import edu.austral.dissis.chess.engine.moveRules.specialRules.DoublePawnMove

class ClassicChessBoardSetUp {
    var map = emptyMap<Position, Piece>()
    var pieces = emptySet<Piece>()
    var board = Board(8, 8, map, pieces, emptyList())

    fun setUp(): Board {
        for (i in 1 until 9) {
            val bPawn = Piece("$i 7", Color.BLACK, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())),
                PieceType.PAWN )
            board = board.putPieceAt(Position(i, 7), bPawn)
            val wPawn = Piece("$i 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1,DoublePawnMove())),
                PieceType.PAWN )
            board = board.putPieceAt(Position(i, 2), wPawn)
        }
        val wRook1 = Piece("1 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
        board = board.putPieceAt(Position(1, 1), wRook1)
        val wRook2 = Piece("8 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
        board = board.putPieceAt(Position(8, 1), wRook2)
        val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
        board = board.putPieceAt(Position(1, 8), bRook1)
        val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
        board = board.putPieceAt(Position(8, 8), bRook2)
        val wBishop1 = Piece("3 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)
        board = board.putPieceAt(Position(3, 1), wBishop1)
        val wBishop2 = Piece("6 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)
        board = board.putPieceAt(Position(6, 1), wBishop2)
        val bBishop1 = Piece("3 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
        board = board.putPieceAt(Position(3, 8), bBishop1)
        val bBishop2 = Piece("6 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
        board = board.putPieceAt(Position(6, 8), bBishop2)
        val wKnight1 = Piece("2 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)
        board = board.putPieceAt(Position(2, 1), wKnight1)
        val wKnight2 = Piece("7 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)
        board = board.putPieceAt(Position(7, 1), wKnight2)
        val bKnight1 = Piece("2 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)
        board = board.putPieceAt(Position(2, 8), bKnight1)
        val bKnight2 = Piece("7 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)
        board = board.putPieceAt(Position(7, 8), bKnight2)
        val wQueen = Piece("4 1", Color.WHITE, listOf(QueenMoves()), PieceType.QUEEN)
        board = board.putPieceAt(Position(4, 1), wQueen)
        val bQueen = Piece("4 8", Color.BLACK, listOf(QueenMoves()), PieceType.QUEEN)
        board = board.putPieceAt(Position(4, 8), bQueen)
        val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)
        board = board.putPieceAt(Position(5, 1), wKing)
        val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)
        board = board.putPieceAt(Position(5, 8), bKing)


        return board
    }
}