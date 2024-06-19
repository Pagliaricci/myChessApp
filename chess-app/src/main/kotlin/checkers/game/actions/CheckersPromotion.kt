package checkers.game.actions

import checkers.moveRules.CheckersCaptureMove
import common.board.Board
import common.elements.color.Color
import common.elements.moveTypes.ClassicMove
import common.game.actions.Action
import common.piece.Piece
import common.piece.PieceType
import common.piece.moveRules.MoveDiagonally
import common.piece.moveRules.MoveLimitation

class CheckersPromotion: Action {

    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        return if(move.piece.playersColor == Color.WHITE) {
            move.to.y == board.maxRow
        } else {
            move.to.y == 1
        }
    }

    override fun execute(board: Board, move: ClassicMove): Board {

        val newPiece = Piece(move.piece.id, move.piece.playersColor, listOf(MoveDiagonally(),MoveLimitation(1,1,CheckersCaptureMove())), PieceType.QUEEN)
        val newBoard = board.removePieceAt(move.from).removePieceAt(move.to).putPieceAt(move.to, newPiece)
        return Board(board.maxRow, board.maxCol, newBoard.currentBoard, newBoard.pieces, board.moves.plus(move))
    }
}