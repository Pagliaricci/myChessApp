package edu.austral.dissis.chess.engine.moveRules

import common.board.Board
import common.piece.moveRules.MoveRule
import common.elements.moveTypes.ClassicMove
import kotlin.math.abs

class MoveLShape: MoveRule {
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        return (oneHorizontal(move) && twoVertical(move)) || (twoHorizontal(move) && oneVertical(move))
    }
    private fun oneHorizontal(move: ClassicMove): Boolean{
        return abs(move.from.x - move.to.x) == 1
    }
    private fun oneVertical(move: ClassicMove): Boolean{
        return abs(move.from.y - move.to.y) == 1
    }
    private fun twoHorizontal(move: ClassicMove): Boolean{
        return abs(move.from.x - move.to.x) == 2
    }
    private fun twoVertical(move: ClassicMove): Boolean{
        return abs(move.from.y - move.to.y) == 2
    }
}