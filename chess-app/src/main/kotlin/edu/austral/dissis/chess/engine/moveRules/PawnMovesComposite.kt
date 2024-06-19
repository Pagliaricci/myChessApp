package edu.austral.dissis.chess.engine.moveRules

import common.board.Board
import common.piece.moveRules.MoveRule
import common.piece.moveRules.MoveDiagonally
import common.elements.moveTypes.ClassicMove
import common.piece.moveRules.MoveForward
import edu.austral.dissis.chess.engine.game.rules.IsEnemyPieceThere

class PawnMovesComposite: MoveRule {
    private val forward = MoveForward()
    private val vertical = MoveVertically()
    private val diagonal = MoveDiagonally()
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        if(( vertical.isFulfilled(board,move) && !IsEnemyPieceThere().verify(board,move)) || (diagonal.isFulfilled(board,move) && IsEnemyPieceThere().verify(board, move))) {
            return forward.isFulfilled(board,move)
        }
        return false
    }


}