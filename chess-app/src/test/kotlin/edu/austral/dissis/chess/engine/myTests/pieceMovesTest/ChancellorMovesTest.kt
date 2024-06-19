package edu.austral.dissis.chess.engine.myTests.pieceMovesTest

import common.board.Board
import common.elements.color.Color
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import common.game.factory.GameFactory
import common.game.results.InvalidMoveResult
import common.game.results.SuccessfulMoveResult
import common.piece.Piece
import common.piece.PieceType
import edu.austral.dissis.chess.engine.moveRules.ChancellorMoves
import org.junit.jupiter.api.Test

class ChancellorMovesTest {
    private var board = Board(8,8, emptyMap(), emptySet(), emptyList())
        .putPieceAt(Position(4, 4), Piece("4 4", Color.WHITE, listOf(ChancellorMoves()) ,PieceType.CHANCELLOR))

    private val chancellorGame = GameFactory().createChessGame(board)
    @Test
    fun chancellorMoveUp(){
        chancellorGame.printBoard()
        val move = ClassicMove(Position(4,4), Position(4,8), board.getPieceAt(Position(4,4))!!)
        val result = chancellorGame.move(move)
        assert(result is SuccessfulMoveResult)
    }
    @Test
    fun chancellorMoveDown(){
        val move = ClassicMove(Position(4,4), Position(4,1), board.getPieceAt(Position(4,4))!!)
        val result = chancellorGame.move(move)
        assert(result is SuccessfulMoveResult)
    }
    @Test
    fun chancellorMoveRight(){
        val move = ClassicMove(Position(4,4), Position(8,4), board.getPieceAt(Position(4,4))!!)
        val result = chancellorGame.move(move)
        assert(result is SuccessfulMoveResult)
    }
    @Test
    fun chancellorMoveLeft(){
        val move = ClassicMove(Position(4,4), Position(1,4), board.getPieceAt(Position(4,4))!!)
        val result = chancellorGame.move(move)
        assert(result is SuccessfulMoveResult)
    }
    @Test
    fun chancellorMoveUpRight(){
        val move = ClassicMove(Position(4,4), Position(8,8), board.getPieceAt(Position(4,4))!!)
        val result = chancellorGame.move(move)
        assert(result is InvalidMoveResult)
    }
}