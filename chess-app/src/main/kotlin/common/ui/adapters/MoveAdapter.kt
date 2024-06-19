package common.ui.adapters

import common.board.Board
import common.elements.moveTypes.ClassicMove
import edu.austral.dissis.chess.gui.Move

class MoveAdapter {
    fun adapt(move: Move, board: Board): ClassicMove? {
        val fromPos = PositionAdapter().adaptToMyPos(move.from)
        val toPos = PositionAdapter().adaptToMyPos(move.to)
        if(!board.containsPiece(fromPos)) return null
        val piece = board.getPieceAt(fromPos)
        return ClassicMove(fromPos,toPos,piece!!)
    }

}