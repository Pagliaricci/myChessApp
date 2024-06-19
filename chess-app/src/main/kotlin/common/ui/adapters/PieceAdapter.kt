package common.ui.adapters

import common.board.Board
import common.piece.Piece
import edu.austral.dissis.chess.gui.ChessPiece
import java.util.*

class PieceAdapter() {

    fun adapt(piece: Piece, board: Board): ChessPiece {
        val playerColor = ColorAdapter().translatePlayerColor(piece.playersColor)
        val position = PositionAdapter().adaptToTheirPos(board.getPositionOf(piece))

        val pieceType = piece.pieceType.toString().lowercase(Locale.ROOT)
        return ChessPiece(piece.id, playerColor, position, pieceType)
    }

    fun getChessPieces(board: Board): List<ChessPiece> {
        val pieces = mutableListOf<ChessPiece>()
        for (piece in board.getPieces()) {
            pieces.add(adapt(piece, board))
        }
        return pieces
    }

}