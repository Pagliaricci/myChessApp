package edu.austral.dissis.chess.engine.exam

import common.board.Board
import common.elements.color.Color
import common.game.GameEngine
import common.game.gameType.GameType
import common.piece.Piece
import common.piece.factory.PieceFactory
import common.game.results.EndGameResult
import common.game.results.InvalidMoveResult
import common.elements.players.Player
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import edu.austral.dissis.chess.test.TestBoard
import edu.austral.dissis.chess.test.TestPiece
import edu.austral.dissis.chess.test.TestPosition
import edu.austral.dissis.chess.test.TestSize
import edu.austral.dissis.chess.test.game.*
import common.ui.adapters.TestAdapter
import edu.austral.dissis.chess.engine.game.turnManagers.ClassicChessTurnManager
import edu.austral.dissis.chess.engine.game.types.endConditions.ClassicEndConditions
import edu.austral.dissis.chess.engine.game.types.ruleSets.ClassicChessRuleSet
import java.util.*

class MyEngineTestGameRunner : TestGameRunner {
    private val gameType = GameType(
        ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
        Player(Color.WHITE), Player(
        Color.BLACK)
    ))
    private val turnManager = ClassicChessTurnManager(gameType.getPlayers()[0])
    private var game = GameEngine(gameType.getInitialBoard(),turnManager,gameType, Stack(), Stack())

    override fun executeMove(from: TestPosition, to: TestPosition): TestMoveResult {
        val myMove = ClassicMove(Position(from.col,from.row), Position(to.col,to.row),
            game.getBoard().getPieceAt(Position(from.col,from.row))!!)

        val result = game.move(myMove)
        game = result.getGame()
        if(result is InvalidMoveResult){
            return TestMoveFailure(this.getBoard())
        }
        else if(result is EndGameResult){
            return if(result.getGame().getCurrentPlayer().getColor() == gameType.getPlayers()[0].getColor()){
                WhiteCheckMate(this.getBoard())
            } else{
                BlackCheckMate(this.getBoard())
            }
        }
        return TestMoveSuccess(this)
    }

    override fun getBoard(): TestBoard {
        val pieces = mutableMapOf<TestPosition, TestPiece>()
        val board = game.getBoard()
        val testSize = TestSize(board.maxCol,board.maxRow)
        for ((pos,piece) in board.currentBoard){
            val testPos = TestPosition(pos.y,pos.x)
            pieces[testPos] = TestPiece(TestAdapter().adaptToTestPieceType(piece), TestAdapter().adaptToTestPlayerColor(piece.playersColor))
        }
        return TestBoard(testSize,pieces)

    }

    override fun withBoard(board: TestBoard): TestGameRunner {
        val myBoard = mutableMapOf<Position, Piece>()
        val mySet = mutableSetOf<Piece>()
        for((pos,piece) in board.pieces){
                val pieceColor = TestAdapter().adaptFromTestPlayerColor(piece.playerColorSymbol)
                val pieceType = TestAdapter().adaptFromTestPieceType(piece.pieceTypeSymbol)
                val myPiece = PieceFactory().createPiece("${pos.row},${pos.col}",pieceColor,pieceType)
            myBoard[Position(pos.col,pos.row)] = myPiece
            mySet += myPiece
        }
        game = GameEngine(Board(board.size.rows,board.size.cols,myBoard,mySet,emptyList()),turnManager, gameType, Stack(), Stack())
        return this
    }
    override fun undo(): TestMoveResult {
        val result = game.undo()
        game = result
        return TestMoveSuccess(this)
    }

    override fun redo(): TestMoveResult {
        val result = game.redo()
        game = result
        return TestMoveSuccess(this)
    }
}