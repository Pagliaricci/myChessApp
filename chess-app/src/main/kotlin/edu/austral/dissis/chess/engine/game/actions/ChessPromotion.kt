package edu.austral.dissis.chess.engine.game.actions

import common.board.Board
import common.elements.color.Color
import common.game.actions.Action
import common.piece.Piece
import common.piece.PieceType
import common.piece.moveRules.MoveDiagonally
import common.elements.moveTypes.ClassicMove
import edu.austral.dissis.chess.engine.moveRules.MoveHorizontally
import edu.austral.dissis.chess.engine.moveRules.MoveVertically

class ChessPromotion: Action {
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        val piece = board.getPieceAt(move.from)
        if (piece!!.pieceType == PieceType.PAWN) {
            return if (piece.playersColor == Color.WHITE) {
                move.to.y == board.maxRow
            } else {
                move.to.y == 1
            }
        }
        return false
    }

    override fun execute(board: Board, move: ClassicMove): Board {
        val piece = board.getPieceAt(move.from)
        val newPiece = Piece(piece!!.id, piece.playersColor, listOf(MoveDiagonally(), MoveVertically(),MoveHorizontally()), PieceType.QUEEN)
        val newBoard = board.removePieceAt(move.from).putPieceAt(move.to, newPiece)
        return Board(board.maxRow, board.maxCol, newBoard.currentBoard, newBoard.pieces, board.moves.plus(move))
    }
}