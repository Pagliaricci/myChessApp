package edu.austral.dissis.chess.engine.setUps.variations

import common.board.Board
import common.elements.color.Color
import common.elements.position.Position
import common.piece.Piece
import common.piece.PieceType
import common.piece.moveRules.MoveDiagonally
import common.piece.moveRules.MoveLimitation
import edu.austral.dissis.chess.engine.moveRules.*
import edu.austral.dissis.chess.engine.moveRules.specialRules.Castling
import edu.austral.dissis.chess.engine.moveRules.specialRules.DoublePawnMove

class ChancellorBoardSetUp {

        var map = emptyMap<Position, Piece>()
        var pieces = emptySet<Piece>()
        var board = Board(10, 8, map, pieces, emptyList())

        fun setUp(): Board {
            for (i in 1 until 11) {
                val bPawn = Piece("$i 7", Color.BLACK, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
                board = board.putPieceAt(Position(i, 7), bPawn)
                val wPawn = Piece("$i 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
                board = board.putPieceAt(Position(i, 2), wPawn)
            }
            board = board.putPieceAt(Position(2, 1), Piece("2 1", Color.WHITE, listOf(ChancellorMoves()), PieceType.CHANCELLOR))
            board = board.putPieceAt(Position(9, 1), Piece("9 1", Color.WHITE, listOf(ChancellorMoves()), PieceType.CHANCELLOR))

            board = board.putPieceAt(Position(2, 8), Piece("2 8", Color.BLACK, listOf(ChancellorMoves()), PieceType.CHANCELLOR))
            board = board.putPieceAt(Position(9, 8), Piece("9 8", Color.BLACK, listOf(ChancellorMoves()), PieceType.CHANCELLOR))

            val wRook1 = Piece("1 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
            board = board.putPieceAt(Position(1, 1), wRook1)
            val wRook2 = Piece("10 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
            board = board.putPieceAt(Position(10, 1), wRook2)
            val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
            board = board.putPieceAt(Position(1, 8), bRook1)
            val bRook2 = Piece("10 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
            board = board.putPieceAt(Position(10, 8), bRook2)
            val wBishop1 = Piece("4 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)
            board = board.putPieceAt(Position(4, 1), wBishop1)
            val wBishop2 = Piece("7 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)
            board = board.putPieceAt(Position(7, 1), wBishop2)
            val bBishop1 = Piece("4 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
            board = board.putPieceAt(Position(4, 8), bBishop1)
            val bBishop2 = Piece("7 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
            board = board.putPieceAt(Position(7, 8), bBishop2)
            val wKnight1 = Piece("3 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)
            board = board.putPieceAt(Position(3, 1), wKnight1)
            val wKnight2 = Piece("8 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)
            board = board.putPieceAt(Position(8, 1), wKnight2)
            val bKnight1 = Piece("3 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)
            board = board.putPieceAt(Position(3, 8), bKnight1)
            val bKnight2 = Piece("8 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)
            board = board.putPieceAt(Position(8, 8), bKnight2)
            val wQueen = Piece("5 1", Color.WHITE, listOf(QueenMoves()), PieceType.QUEEN)
            board = board.putPieceAt(Position(5, 1), wQueen)
            val bQueen = Piece("5 8", Color.BLACK, listOf(QueenMoves()), PieceType.QUEEN)
            board = board.putPieceAt(Position(5, 8), bQueen)
            val wKing = Piece("6 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)
            board = board.putPieceAt(Position(6, 1), wKing)
            val bKing = Piece("6 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)
            board = board.putPieceAt(Position(6, 8), bKing)

            return board
        }

}