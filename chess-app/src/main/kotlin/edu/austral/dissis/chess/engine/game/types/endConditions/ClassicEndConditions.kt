package edu.austral.dissis.chess.engine.game.types.endConditions

import common.game.GameEngine
import common.game.sharedRules.FriendlyFire
import common.game.gameType.endConditions.EndCondition
import common.elements.players.Player
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import edu.austral.dissis.chess.engine.game.rules.CheckValidator
import edu.austral.dissis.chess.engine.game.rules.ClearPath

class ClassicEndConditions: EndCondition {

    private fun checkWin(game: GameEngine, player: Player): Boolean {
           if(CheckValidator().playerIsInCheck(game.getBoard(),player)){
               return !isThereAnyValidMove(game,player)
           }
              return false
        }

    override fun check(game: GameEngine, player: Player): Boolean {
        return checkWin(game,player)
    }
    private fun isThereAnyValidMove(game: GameEngine, player: Player): Boolean {
        val board = game.getBoard()
        val pieces = board.getPieces().filter { it.playersColor == player.getColor() }
        for (piece in pieces) {
            for (i in 1..8) {
                for (j in 1..8) {
                    val move = ClassicMove(board.getPositionOf(piece), Position(i, j), piece)
                    if(piece.isValidMove(board,move) && ClearPath().isFulfilled(game,move)
                         && FriendlyFire().isFulfilled(game,move)){
                            val newBoard = board.movePiece(move)
                            if (!CheckValidator().playerIsInCheck(newBoard, player)) {
                                val position = board.getPositionOf(piece)
                                println("llegue con $piece desde ${position.x} ,${position.y}a $i,$j tipo ${piece.pieceType}")
                                return true
                            }
                        }
                }
            }
        }
        return false
    }


}