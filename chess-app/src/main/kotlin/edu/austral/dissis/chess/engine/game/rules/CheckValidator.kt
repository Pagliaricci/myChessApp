package edu.austral.dissis.chess.engine.game.rules

import common.board.Board
import common.game.GameEngine
import common.game.rules.GameRule
import common.game.factory.GameFactory
import common.elements.players.Player
import common.elements.moveTypes.ClassicMove

class CheckValidator: GameRule {
    override fun isFulfilled(game: GameEngine, move: ClassicMove): Boolean {
        return !moveWouldPutInCheck(game, move)
    }

    fun playerIsInCheck(board: Board, player: Player): Boolean {
        val kingPos= board.getKingPosition(player.getColor())
        val opponentPieces = board.getPieces().filter { it.playersColor != player.getColor()}
        for(piece in opponentPieces){
            val piecePos = board.getPositionOf(piece)
            val move = ClassicMove(piecePos, kingPos, piece)
            val aux = GameFactory().createChessGame(board)
            if(piece.isValidMove(board, ClassicMove(piecePos, kingPos, piece)) && ClearPath().isFulfilled(aux, move)){
                return true
            }
        }
        return false
    }

    fun moveWouldPutInCheck(game: GameEngine, move: ClassicMove): Boolean {
        val newBoard = game.getBoard().movePiece(move)
        return playerIsInCheck(newBoard,game.getCurrentPlayer())
    }

}