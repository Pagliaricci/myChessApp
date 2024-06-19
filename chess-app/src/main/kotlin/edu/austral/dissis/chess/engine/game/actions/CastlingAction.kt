package edu.austral.dissis.chess.engine.game.actions

import common.board.Board
import common.elements.color.Color
import common.game.actions.Action
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import edu.austral.dissis.chess.engine.moveRules.specialRules.Castling

class CastlingAction: Action {
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        return Castling().isFulfilled(board, move)
    }

    override fun execute(board: Board, move: ClassicMove): Board {
        val king = board.getPieceAt(move.from)!!
        if(Castling().isShortCastling(move)){
            val rookPosition = if(king.playersColor == Color.WHITE) Position(8,1) else Position(8,8)
            val rook = board.getPieceAt(rookPosition)!!
            val rookMove = ClassicMove(rookPosition, Position(6,rookPosition.y),rook)
             return board.movePiece(move).movePiece(rookMove)
        }
        if(Castling().isLongCastling(move)){
            val rookPosition = if(king.playersColor == Color.WHITE) Position(1,1) else Position(1,8)
            val rook = board.getPieceAt(rookPosition)!!
            val rookMove = ClassicMove(rookPosition, Position(4,rookPosition.y),rook)
            return board.movePiece(move).movePiece(rookMove)
        }
        return board
    }
}