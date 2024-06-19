package common.piece

import common.board.Board
import common.elements.color.Color
import common.piece.moveRules.MoveRule
import common.elements.moveTypes.ClassicMove

class Piece(val id: String, val playersColor: Color, val rules: List<MoveRule>, val pieceType: PieceType) {

    fun isValidMove(board: Board, move: ClassicMove): Boolean {return rules.all { it.isFulfilled(board,move) }}
}

