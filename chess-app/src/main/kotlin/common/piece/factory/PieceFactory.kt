package common.piece.factory

import common.elements.color.Color
import common.piece.moveRules.MoveRule
import common.piece.Piece
import common.piece.PieceType
import common.piece.moveRules.MoveDiagonally
import common.piece.moveRules.MoveLimitation
import edu.austral.dissis.chess.engine.moveRules.*
import edu.austral.dissis.chess.engine.moveRules.specialRules.Castling
import edu.austral.dissis.chess.engine.moveRules.specialRules.DoublePawnMove

class PieceFactory {
    fun createPiece(id: String, playerColor: Color, pieceType: PieceType): Piece {
        val pieceRules = getPieceRules(pieceType)
        return Piece(id, playerColor, pieceRules, pieceType)
    }

    private fun getPieceRules(pieceType: PieceType): List<MoveRule> {
        return when(pieceType) {
            PieceType.PAWN -> listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove()))
            PieceType.ROOK -> listOf(MoveVerticalORHorizontal())
            PieceType.KNIGHT -> listOf(MoveLShape())
            PieceType.BISHOP -> listOf(MoveDiagonally())
            PieceType.QUEEN -> listOf(QueenMoves())
            PieceType.KING -> listOf(KingMoves(), MoveLimitation(1,1, Castling()))
            PieceType.CHANCELLOR -> listOf(ChancellorMoves())

        }
    }
}