package common.ui

import common.game.results.EndGameResult
import common.game.results.InvalidMoveResult
import edu.austral.dissis.chess.gui.*
import common.ui.adapters.ColorAdapter
import common.ui.adapters.MoveAdapter
import common.ui.adapters.PieceAdapter

class UIGameEngine( private var game: common.game.GameEngine): GameEngine {

    override fun applyMove(move: Move): MoveResult {
        val myMove = MoveAdapter().adapt(move,game.getBoard()) ?: return InvalidMove("No piece at that position")
        val result = game.move(myMove)
        if(result is InvalidMoveResult){
            return InvalidMove(result.getMessage())
        }
        else if(result is EndGameResult){
            return GameOver(ColorAdapter().translatePlayerColor(result.getGame().getCurrentPlayer().getColor()))
        }
        game = result.getGame()
        val playerColor = ColorAdapter().translatePlayerColor(result.getCurrentPlayersTurn().getColor())
        val pieces = PieceAdapter().getChessPieces(game.getBoard())
        return NewGameState(pieces,playerColor,UndoState(canUndo(),canRedo()))
    }

    override fun init(): InitialState {
        val pieces = PieceAdapter().getChessPieces(game.getBoard())
        val maxRow = game.getBoard().maxRow
        val maxCol = game.getBoard().maxCol
        return InitialState(BoardSize(maxRow,maxCol),pieces, ColorAdapter().translatePlayerColor(game.getCurrentPlayer().getColor()))
    }

    override fun redo(): NewGameState {
        game = game.redo()
        return NewGameState(
            PieceAdapter().getChessPieces(game.getBoard()), ColorAdapter().translatePlayerColor(game.getCurrentPlayer().getColor()),
            UndoState(canUndo(),canRedo())
        )
    }

    override fun undo(): NewGameState {
        game = game.undo()
        return NewGameState(PieceAdapter().getChessPieces(game.getBoard()), ColorAdapter().translatePlayerColor(game.getCurrentPlayer().getColor()),
            UndoState(canUndo(),canRedo()))
    }

    private fun canUndo(): Boolean {
        return game.getUndoStack().isNotEmpty()
    }
    private fun canRedo(): Boolean {
        return game.getRedoStack().isNotEmpty()
    }



}