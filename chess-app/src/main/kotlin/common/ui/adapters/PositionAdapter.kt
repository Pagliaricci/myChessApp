package common.ui.adapters

import edu.austral.dissis.chess.gui.Position

class PositionAdapter {
    fun adaptToMyPos(pos: Position): common.elements.position.Position {
        return common.elements.position.Position(pos.column, pos.row)
    }
    fun adaptToTheirPos(pos: common.elements.position.Position): Position{
        return Position(pos.y, pos.x)
    }


}