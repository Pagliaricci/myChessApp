package edu.austral.dissis.chess.engine.myTests.pieceMovesTest

import checkers.setUps.CaptureAndPromotionSetUp
import checkers.setUps.CheckersSetUp
import checkers.setUps.EndGameSetUp
import checkers.setUps.MultipleCapturesSetUp
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import common.game.factory.GameFactory
import common.game.results.EndGameResult
import common.game.results.InvalidMoveResult
import common.game.results.SuccessfulMoveResult
import common.piece.PieceType
import org.junit.jupiter.api.Test

class CheckersPieceTest {

    private var checkersGame = GameFactory().createCheckersGame(CheckersSetUp().setUp())

    @Test
    fun checkersMovingRightUp(){
        val result = checkersGame.move(ClassicMove( Position(4, 3),Position(5, 4),checkersGame.getBoard().getPieceAt(Position(4, 3))!!))
        assert (result is SuccessfulMoveResult)
    }
    @Test
    fun checkersMovingLeftUp(){
        val result = checkersGame.move(ClassicMove( Position(4, 3),Position(3, 4),checkersGame.getBoard().getPieceAt(Position(4, 3))!!))
        assert (result is SuccessfulMoveResult)
    }

    @Test
    fun checkersInvalidMove(){
        val result = checkersGame.move(ClassicMove( Position(4, 3),Position(4, 4),checkersGame.getBoard().getPieceAt(Position(4, 3))!!))
        assert (result is InvalidMoveResult)
    }
    @Test
    fun multipleCaptureTest(){
        val board = MultipleCapturesSetUp().setUp()
        checkersGame = GameFactory().createCheckersGame(board)
        val result = checkersGame.move(ClassicMove( Position(3, 2),Position(5, 4),checkersGame.getBoard().getPieceAt(Position(3, 2))!!))
        assert (result is SuccessfulMoveResult)
        checkersGame = result.getGame()
        val result2 = checkersGame.move(ClassicMove( Position(5, 4),Position(7, 6),checkersGame.getBoard().getPieceAt(Position(5, 4))!!))
        assert (result2 is SuccessfulMoveResult)
    }

    @Test
    fun promotionTest(){
        val board = CaptureAndPromotionSetUp().setUp()
        checkersGame = GameFactory().createCheckersGame(board)
        val result = checkersGame.move(ClassicMove( Position(6, 6),Position(8, 8),checkersGame.getBoard().getPieceAt(Position(6, 6))!!))
        assert (result is SuccessfulMoveResult)
        checkersGame = result.getGame()
        val checkersKing = checkersGame.getBoard().getPieceAt(Position(8, 8))
        assert(checkersKing!!.pieceType == PieceType.QUEEN)
    }

    @Test
    fun endGameTest(){
        val board = EndGameSetUp().setUp()
        checkersGame = GameFactory().createCheckersGame(board)
        val result = checkersGame.move(ClassicMove( Position(3, 2),Position(5, 4),checkersGame.getBoard().getPieceAt(Position(3, 2))!!))
        assert (result is EndGameResult)
    }

}