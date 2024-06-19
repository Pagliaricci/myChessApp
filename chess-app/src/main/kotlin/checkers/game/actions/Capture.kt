package checkers.game.actions

import checkers.moveRules.CheckersCaptureMove
import common.board.Board
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import common.game.actions.Action

class Capture : Action {
    override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
        return CheckersCaptureMove().isFulfilled(board, move)
    }

    override fun execute(board: Board, move: ClassicMove): Board {
        val middlePos = Position((move.from.x + move.to.x) / 2, (move.from.y + move.to.y) / 2)
        return board.removePieceAt(middlePos).movePiece(move)
    }

}