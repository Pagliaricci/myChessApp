package checkers.game.rules

import common.board.Board
import common.elements.moveTypes.ClassicMove
import common.game.GameEngine

import common.game.rules.GameRule

class EmptyTargetPosition: GameRule {
    override fun isFulfilled(game :GameEngine, move: ClassicMove): Boolean {
        return game.getBoard().getPieceAt(move.to) == null
    }

}