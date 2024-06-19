package checkers.game.rules

import checkers.moveRules.CheckersCaptureMove
import common.board.Board
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import common.game.GameEngine
import common.game.factory.GameFactory
import common.game.rules.GameRule
import common.piece.Piece

class ForcedCapture: GameRule {
    override fun isFulfilled(game: GameEngine, move: ClassicMove): Boolean {
        val board = game.getBoard()
        val playersPieces = board.getPieces().filter { it.playersColor == move.piece.playersColor}
        if(theresAPossibleCapture(playersPieces, board)) {
            return CheckersCaptureMove().isFulfilled(board, move)
        }
        return true
    }

    fun theresAPossibleCapture(playersPieces: List<Piece>, board: Board): Boolean {
        for(piece in playersPieces) {
            for (i in 1 until board.maxRow) {
                for (j in 1 until board.maxCol) {
                    val move = ClassicMove(board.getPositionOf(piece), Position(i, j), piece)
                    if( piece.isValidMove(board,move) && CheckersCaptureMove().isFulfilled(board,move)
                        && EmptyTargetPosition().isFulfilled(GameFactory().createCheckersGame(board),move)){
                        return true
                    }
                }
            }
        }
        return false
    }
}