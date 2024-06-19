package edu.austral.dissis.chess.engine.moveRules.specialRules

import common.board.Board
import common.elements.color.Color
import common.piece.Piece
import common.piece.specialRules.SpecialRule
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position

class Castling: SpecialRule {
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        if(isShortCastling(move)){
            return isShortCastlingPossible(board,move)
        }
        if(isLongCastling(move)){
            return isLongCastlingPossible(board,move)
        }
        return false
    }

    fun isShortCastling( move: ClassicMove): Boolean {
        return (move.from.x == 5 && move.from.y == 1 && move.to.x == 7 && move.to.y == 1) ||
                (move.from.x == 5 && move.from.y == 8 && move.to.x == 7 && move.to.y == 8)
    }
    fun isLongCastling( move: ClassicMove): Boolean {
        return (move.from.x == 5 && move.from.y == 1 && move.to.x == 3 && move.to.y == 1) ||
                (move.from.x == 5 && move.from.y == 8 && move.to.x == 3 && move.to.y == 8)
    }
    private fun isShortCastlingPossible(board: Board, move: ClassicMove): Boolean {

        val king = board.getPieceAt(move.from)!!
        val rook = if(king.playersColor == Color.WHITE) board.getPieceAt(Position(8,1)) else board.getPieceAt(Position(8,8))
        if (rook == null) return false
        return !(hasMoved(board,king) || hasMoved(board,rook))
    }
    private fun isLongCastlingPossible(board: Board, move: ClassicMove): Boolean {
        val king = board.getPieceAt(move.from)!!
        val rook = if(king.playersColor == Color.WHITE) board.getPieceAt(Position(1,1)) else board.getPieceAt(Position(1,8))
        if (rook == null) return false
        return !(hasMoved(board,king) || hasMoved(board,rook))
    }
    private fun hasMoved(board: Board, piece: Piece): Boolean {
        return board.moves.any { it.piece == piece }
    }
}