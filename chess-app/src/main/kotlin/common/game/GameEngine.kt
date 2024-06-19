package common.game

import common.board.Board
import common.game.actions.Action
import common.game.gameType.GameType
import common.game.results.EndGameResult
import common.game.results.GameResult
import common.game.results.InvalidMoveResult
import common.game.results.SuccessfulMoveResult
import common.elements.players.Player
import common.elements.moveTypes.ClassicMove
import common.game.turnManager.TurnManager

import java.util.*

class GameEngine(private var board: Board, private val turnManager: TurnManager, private val gameType: GameType, private val undoStack: Stack<GameEngine>, private val redoStack: Stack<GameEngine>) {

    fun move(move: ClassicMove): GameResult {
        if (!canMove(move)) {
            return InvalidMoveResult(this, turnManager.whoseTurnIsIt(), gameType.getGameMessage())
        }
        undoStack.push(this)
        val actions = gameType.getAction(board, move)
        if (actions.isNotEmpty()) {
            return applyActions(actions, move)
        }
        val newBoard = board.movePiece(move)
        if(!gameType.isEndConditionMet(GameEngine(newBoard, turnManager, gameType, undoStack, redoStack), turnManager.getOpponent(this))) {
            val newTM = turnManager.nextTurn(this)
            val newGame = GameEngine(newBoard, newTM, gameType, undoStack, redoStack)
            return SuccessfulMoveResult(newGame, newGame.getCurrentPlayer(), gameType.getGameMessage())
        }
        return EndGameResult(GameEngine(newBoard,turnManager,gameType,undoStack,redoStack), turnManager.whoseTurnIsIt(), gameType.getGameMessage())
    }

    private fun applyActions(actions: List<Action?>, move: ClassicMove): GameResult {
        var newBoard = board
        for (action in actions){
            newBoard = action!!.execute(newBoard, move)
        }
        if(!gameType.isEndConditionMet(GameEngine(newBoard, turnManager, gameType, undoStack, redoStack), turnManager.getOpponent(this))) {
            val newGame = GameEngine(newBoard, turnManager.nextTurn(GameEngine(newBoard, turnManager, gameType, undoStack, redoStack)), gameType, undoStack, redoStack)
            return SuccessfulMoveResult(newGame, newGame.getCurrentPlayer(), gameType.getGameMessage())
        }
        return EndGameResult(GameEngine(newBoard,turnManager,gameType,undoStack,redoStack), turnManager.whoseTurnIsIt(), gameType.getGameMessage())
    }


    fun canMove(move: ClassicMove): Boolean {
        for (rule in gameType.getRuleSet().getRules()) {
            if (!rule.isFulfilled(this, move)) {
                return false
            }
        }
        return board.getPieceAt(move.from)?.isValidMove(board, move) ?: false
    }

    fun getCurrentPlayer(): Player {
        return turnManager.whoseTurnIsIt()
    }
    fun getBoard(): Board {
        return board
    }
    fun getPlayers(): List<Player> {
        return gameType.getPlayers()
    }

    fun getTurnManager(): TurnManager {
        return turnManager
    }

    fun getGameType(): GameType {

        return gameType
    }

    fun getUndoStack(): Stack<GameEngine> {
        return undoStack
    }

    fun getRedoStack(): Stack<GameEngine> {
        return redoStack
    }

    fun undo(): GameEngine {
        if (undoStack.isEmpty()) {
            return this
        }
        val lastGame = undoStack.pop()
        redoStack.push(this)
        return lastGame
    }


    fun redo(): GameEngine {
        if (redoStack.isEmpty()) {
            return this
        }
        val lastGame = redoStack.pop()
        undoStack.push(this)
        return lastGame
    }

    fun setBoard(board: Board) {
        this.board = board
    }

    fun printBoard() {
        board.printBoard()
    }


}