package edu.austral.dissis.chess.engine.myTests.predefined

import common.board.Board
import common.elements.color.Color
import common.elements.moveTypes.ClassicMove
import common.elements.players.Player
import common.elements.position.Position
import common.game.GameEngine
import common.game.gameType.GameType
import common.piece.Piece
import common.piece.factory.PieceFactory
import common.ui.adapters.TestAdapter
import edu.austral.dissis.chess.engine.game.turnManagers.ClassicChessTurnManager
import edu.austral.dissis.chess.engine.game.types.endConditions.ClassicEndConditions
import edu.austral.dissis.chess.engine.game.types.ruleSets.ClassicChessRuleSet
import edu.austral.dissis.chess.test.TestBoard
import edu.austral.dissis.chess.test.TestPosition
import edu.austral.dissis.chess.test.Validity
import edu.austral.dissis.chess.test.move.TestMoveRunner
import java.util.*

class MyTestMoveRunner: TestMoveRunner {

    private val gameType = GameType(ClassicChessRuleSet(""),ClassicEndConditions(), listOf(Player(Color.WHITE), Player(Color.BLACK)))
    private val classicChessTurnManager = ClassicChessTurnManager(gameType.getFirstPlayer())
    private var game = GameEngine(gameType.getInitialBoard(), classicChessTurnManager,gameType, Stack(), Stack())

    override fun executeMove(testBoard: TestBoard, from: TestPosition, to: TestPosition): Validity {
        val board = withBoard(testBoard)
        game.setBoard(board)
        val myMove = ClassicMove(Position(from.col,from.row), Position(to.col,to.row), game.getBoard().getPieceAt(Position(from.col,from.row))!!)
        if(!game.canMove(myMove)) return Validity.INVALID
        return Validity.VALID
    }


    private fun withBoard(board: TestBoard): Board {
        val myBoard = mutableMapOf<Position, Piece>()
        val mySet = mutableSetOf<Piece>()
        for((pos,piece) in board.pieces){
            val pieceColor = TestAdapter().adaptFromTestPlayerColor(piece.playerColorSymbol)
            val pieceType = TestAdapter().adaptFromTestPieceType(piece.pieceTypeSymbol)
            val myPiece = PieceFactory().createPiece("${pos.row},${pos.col}",pieceColor,pieceType)
            myBoard[Position(pos.col,pos.row)] = myPiece
            mySet += myPiece
        }
        return Board(8,8,myBoard,mySet, emptyList())
    }
}