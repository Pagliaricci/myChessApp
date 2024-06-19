package common.game.actions

import common.board.Board
import common.elements.moveTypes.ClassicMove

interface Action {
    fun isFulfilled(board: Board, move: ClassicMove): Boolean
    fun execute(board: Board, move: ClassicMove): Board
}