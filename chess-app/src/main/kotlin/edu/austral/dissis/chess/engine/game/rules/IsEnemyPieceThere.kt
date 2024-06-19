package edu.austral.dissis.chess.engine.game.rules

import common.board.Board
import common.elements.moveTypes.ClassicMove

class IsEnemyPieceThere {
    fun verify (board: Board, move: ClassicMove): Boolean{
        val piece = board.getPieceAt(move.to)
        return piece != null && piece.playersColor != move.piece.playersColor
    }
}