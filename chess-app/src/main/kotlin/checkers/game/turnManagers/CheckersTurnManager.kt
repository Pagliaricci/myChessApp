package checkers.game.turnManagers

import checkers.game.rules.ForcedCapture
import checkers.moveRules.CheckersCaptureMove
import common.board.Board
import common.elements.moveTypes.ClassicMove
import common.elements.players.Player
import common.game.GameEngine
import common.game.turnManager.TurnManager

class CheckersTurnManager( val player: Player) : TurnManager {

    override fun whoseTurnIsIt(): Player {
        return player
    }

    override fun nextTurn(game: GameEngine): TurnManager {
        val players = game.getPlayers()
        val lastBoard = game.getUndoStack().peek().getBoard()

        val actualBoard = game.getBoard()
        val lastMove = actualBoard.moves.lastOrNull()
        if(lastMove != null){
            if(moveWasACapture(lastBoard, lastMove)){
                if(ForcedCapture().theresAPossibleCapture(listOf(lastMove.piece),actualBoard))
                    return this
            }
        }
        return if (player == players[0]) {
            CheckersTurnManager(players[1])
        } else {
            CheckersTurnManager(players[0])
        }

    }

    override fun getOpponent(game: GameEngine): Player {
        val players = game.getPlayers()
        return if (player == players[0]) {
            players[1]
        } else {
            players[0]
        }
    }

    private fun moveWasACapture(board: Board, move: ClassicMove): Boolean {
        return CheckersCaptureMove().isFulfilled(board, move)
    }
}