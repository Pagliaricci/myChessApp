package edu.austral.dissis.chess.engine.game.rules

import common.board.Board
import common.game.GameEngine
import common.game.rules.GameRule
import common.piece.PieceType
import common.piece.moveRules.MoveDiagonally
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import edu.austral.dissis.chess.engine.moveRules.MoveHorizontally
import edu.austral.dissis.chess.engine.moveRules.MoveVertically
import kotlin.math.abs

class ClearPath: GameRule {
    override fun isFulfilled(game: GameEngine, move: ClassicMove): Boolean {
        if(move.from == move.to) return false
        if(move.piece.pieceType == PieceType.KNIGHT) return true
        val board = game.getBoard()
        val path = getPath(board,move)
        println(path)
        return theresNoPieceInPath(board, path)
    }
    private fun getPath(board: Board, move: ClassicMove): List<Position> {
        val path = mutableListOf<Position>()
        val vertical = MoveVertically()
        val horizontal = MoveHorizontally()
        val diagonal = MoveDiagonally()
        if (vertical.isFulfilled(board,move)) {
            for (i in 1 until abs(move.from.y - move.to.y))
                if (vertical.movingUp(move.from.y, move.to.y)) {
                    path.add(Position(move.from.x, move.from.y + i))
                } else path.add(Position(move.from.x, move.from.y - i))
        }
        if (horizontal.isFulfilled(board,move)) {
            for (i in 1 until abs(move.from.x - move.to.x))
                if (horizontal.movingRight(move.from.x, move.to.x)) {
                    path.add(Position(move.from.x + i, move.from.y))
                } else path.add(Position(move.from.x - i, move.from.y))
        }
        if (diagonal.isFulfilled(board,move)) {
            for (i in 1 until abs(move.from.x - move.to.x))
                if (diagonal.movingRight(move.from.x, move.to.x) && diagonal.movingUp(move.from.y, move.to.y)) {
                    path.add(Position(move.from.x + i, move.from.y + i))
                } else if (diagonal.movingRight(move.from.x, move.to.x) && !diagonal.movingUp(move.from.y, move.to.y)) {
                    path.add(Position(move.from.x + i, move.from.y - i))
                } else if (!diagonal.movingRight(move.from.x, move.to.x) && diagonal.movingUp(move.from.y, move.to.y)) {
                    path.add(Position(move.from.x - i, move.from.y + i))
                } else path.add(Position(move.from.x - i, move.from.y - i))
        }
        return path
    }
    private fun theresNoPieceInPath(board: Board, path: List<Position>): Boolean {
        for(position in path){
            if(board.getPieceAt(position) != null) {
                return false
            }
        }
        return true
    }
}