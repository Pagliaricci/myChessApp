package edu.austral.dissis.chess.engine.myTests.resultsTest

import common.board.Board
import common.elements.color.Color
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import common.game.GameEngine
import common.game.factory.GameFactory
import common.game.results.InvalidMoveResult
import common.game.results.SuccessfulMoveResult
import common.piece.Piece
import common.piece.PieceType
import common.piece.moveRules.MoveForward
import org.junit.jupiter.api.Test

class SuccessfulMoveResultTest {

    @Test
    fun testGetResult() {
        val game = GameFactory().createChessGame(Board(8,8, emptyMap<Position,Piece>(), emptySet<Piece>(), emptyList()))
        assert (game.getBoard().currentBoard.isEmpty())
        assert (game.getBoard().getPieces().isEmpty())

        val newBoard = game.getBoard().putPieceAt(Position(1,1),Piece("a",Color.WHITE, listOf(MoveForward()),PieceType.PAWN))
        assert (newBoard.currentBoard.isNotEmpty())
        assert (newBoard.getPieces().isNotEmpty())
        game.setBoard(newBoard)
        assert (game.getBoard().currentBoard.isNotEmpty())
        assert (game.getBoard().getPieces().isNotEmpty())
        val result = game.move(ClassicMove( Position(1,1),Position(1,2),game.getBoard().getPieceAt(Position(1,1))!!))
        assert (result is SuccessfulMoveResult)
    }

    @Test
    fun testInvalidMove() {
        val game = GameFactory().createChessGame(Board(8,8, emptyMap<Position,Piece>(), emptySet<Piece>(), emptyList()))
        assert (game.getBoard().currentBoard.isEmpty())
        assert (game.getBoard().getPieces().isEmpty())

        val newBoard = game.getBoard().putPieceAt(Position(1,1),Piece("a",Color.WHITE, listOf(MoveForward()),PieceType.PAWN))
        assert (newBoard.currentBoard.isNotEmpty())
        assert (newBoard.getPieces().isNotEmpty())
        game.setBoard(newBoard)
        assert (game.getBoard().currentBoard.isNotEmpty())
        assert (game.getBoard().getPieces().isNotEmpty())
        val result = game.move(ClassicMove( Position(1,1),Position(2,1),game.getBoard().getPieceAt(Position(1,1))!!))
        assert (result is InvalidMoveResult)
    }

    @Test
    fun testUndo(){

        val game = GameFactory().createChessGame(Board(8,8, emptyMap<Position,Piece>(), emptySet<Piece>(), emptyList()))
        assert (game.getBoard().currentBoard.isEmpty())
        assert (game.getBoard().getPieces().isEmpty())

        val newBoard = game.getBoard().putPieceAt(Position(1,1),Piece("a",Color.WHITE, listOf(MoveForward()),PieceType.PAWN))
        assert (newBoard.currentBoard.isNotEmpty())
        assert (newBoard.getPieces().isNotEmpty())
        game.setBoard(newBoard)
        assert (game.getBoard().currentBoard.isNotEmpty())
        assert (game.getBoard().getPieces().isNotEmpty())
        val result = game.move(ClassicMove( Position(1,1),Position(1,2),game.getBoard().getPieceAt(Position(1,1))!!))
        assert (result is SuccessfulMoveResult)
        val newGame = game.undo()
        assert (newGame.getBoard().currentBoard.isNotEmpty())
        assert (newGame.getBoard().getPieces().isNotEmpty())
    }


    @Test
    fun testRedo(){

            val game = GameFactory().createChessGame(Board(8,8, emptyMap<Position,Piece>(), emptySet<Piece>(), emptyList()))
            assert (game.getBoard().currentBoard.isEmpty())
            assert (game.getBoard().getPieces().isEmpty())

            val newBoard = game.getBoard().putPieceAt(Position(1,1),Piece("a",Color.WHITE, listOf(MoveForward()),PieceType.PAWN))
            assert (newBoard.currentBoard.isNotEmpty())
            assert (newBoard.getPieces().isNotEmpty())
            game.setBoard(newBoard)
            assert (game.getBoard().currentBoard.isNotEmpty())
            assert (game.getBoard().getPieces().isNotEmpty())
            val result = game.move(ClassicMove( Position(1,1),Position(1,2),game.getBoard().getPieceAt(Position(1,1))!!))
            assert (result is SuccessfulMoveResult)
            val newGame = game.undo()
            assert (newGame.getBoard().currentBoard.isNotEmpty())
            assert (newGame.getBoard().getPieces().isNotEmpty())
            val newGame2 = newGame.redo()
            assert (newGame2.getBoard().currentBoard.isNotEmpty())
            assert (newGame2.getBoard().getPieces().isNotEmpty())
    }

}