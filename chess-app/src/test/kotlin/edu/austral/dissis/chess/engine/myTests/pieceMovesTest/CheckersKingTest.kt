package edu.austral.dissis.chess.engine.myTests.pieceMovesTest

import checkers.setUps.MultipleCapturesSetUp
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import common.game.factory.GameFactory
import common.game.results.SuccessfulMoveResult
import org.junit.jupiter.api.Test

class CheckersKingTest {
    private val board = MultipleCapturesSetUp().setUpWithKings()
    private var checkersGame = GameFactory().createCheckersGame(board)

    @Test
    fun checkersKingMovingRightUp(){
        val result = checkersGame.move(ClassicMove( Position(3, 2), Position(4, 3),checkersGame.getBoard().getPieceAt(Position(3, 2))!!))
        assert (result is SuccessfulMoveResult)
        checkersGame = result.getGame()
    }
    @Test
    fun checkersKingMovingLeftUp(){
        val result = checkersGame.move(ClassicMove( Position(3, 2), Position(2, 3),checkersGame.getBoard().getPieceAt(Position(3, 2))!!))
        assert (result is SuccessfulMoveResult)
        checkersGame = result.getGame()
    }
    @Test
    fun checkersKingMovingRightDown(){
        val result = checkersGame.move(ClassicMove( Position(3, 2), Position(2, 3),checkersGame.getBoard().getPieceAt(Position(3, 2))!!))
        assert (result is SuccessfulMoveResult)
        checkersGame = result.getGame()
    }
    @Test
    fun checkersKingMovingLeftDown(){
        val result = checkersGame.move(ClassicMove( Position(3, 2), Position(2, 1),checkersGame.getBoard().getPieceAt(Position(3, 2))!!))
        assert (result is SuccessfulMoveResult)
        checkersGame = result.getGame()
    }

    @Test
    fun checkersKingCapture(){
        val result = checkersGame.move(ClassicMove( Position(3, 2), Position(4, 3),checkersGame.getBoard().getPieceAt(Position(3, 2))!!))
        assert (result is SuccessfulMoveResult)
        checkersGame = result.getGame()
        val result2 = checkersGame.move(ClassicMove( Position(6, 5), Position(5, 4),checkersGame.getBoard().getPieceAt(Position(6, 5))!!))
        assert (result2 is SuccessfulMoveResult)
        checkersGame = result2.getGame()
        val result3 = checkersGame.move(ClassicMove( Position(4, 3), Position(6, 5),checkersGame.getBoard().getPieceAt(Position(4, 3))!!))
        assert (result3 is SuccessfulMoveResult)
        checkersGame = result3.getGame()
    }


}