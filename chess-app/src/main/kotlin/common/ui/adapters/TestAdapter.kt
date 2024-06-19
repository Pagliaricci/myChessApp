package common.ui.adapters

import common.elements.color.Color
import common.piece.Piece
import common.piece.PieceType

class TestAdapter {
    fun adaptToTestPieceType(piece: Piece): Char {
        var testType = ' '
        if(piece.pieceType == PieceType.PAWN){testType = 'P'}
        if(piece.pieceType == PieceType.BISHOP){testType = 'B'}
        if(piece.pieceType == PieceType.KNIGHT){testType = 'N'}
        if(piece.pieceType == PieceType.KING){testType = 'K'}
        if(piece.pieceType == PieceType.QUEEN){testType = 'Q'}
        if(piece.pieceType == PieceType.ROOK){testType = 'R'}
        return testType
    }

    fun adaptToTestPlayerColor(playersColor: Color): Char {
        return when(playersColor){
            Color.WHITE -> 'W'
            Color.BLACK -> 'B'
            else -> {
                throw IllegalArgumentException("Invalid color")}
        }
    }

    fun adaptFromTestPlayerColor(playerColorSymbol: Char): Color {
        return when(playerColorSymbol){
            'W' -> Color.WHITE
            'B' -> Color.BLACK
            else -> {
                throw IllegalArgumentException("Invalid color")
            }
        }
    }

    fun adaptFromTestPieceType(pieceTypeSymbol: Char): PieceType {
        return when (pieceTypeSymbol) {
            'P' -> PieceType.PAWN
            'B' -> PieceType.BISHOP
            'N' -> PieceType.KNIGHT
            'K' -> PieceType.KING
            'Q' -> PieceType.QUEEN
            'R' -> PieceType.ROOK
            else -> {
                throw IllegalArgumentException("Invalid piece type")
            }
        }
    }
}