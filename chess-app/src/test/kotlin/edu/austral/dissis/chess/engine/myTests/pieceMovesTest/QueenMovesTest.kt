package edu.austral.dissis.chess.engine.myTests.pieceMovesTest

import common.board.Board
import common.elements.color.Color
import common.elements.moveTypes.ClassicMove
import common.elements.players.Player
import common.elements.position.Position
import common.game.GameEngine
import common.game.gameType.GameType
import common.game.results.InvalidMoveResult
import common.piece.PieceType
import common.piece.factory.PieceFactory
import edu.austral.dissis.chess.engine.game.turnManagers.ClassicChessTurnManager
import edu.austral.dissis.chess.engine.game.types.endConditions.ClassicEndConditions
import edu.austral.dissis.chess.engine.game.types.ruleSets.ClassicChessRuleSet
import edu.austral.dissis.chess.gui.InvalidMove
import org.junit.jupiter.api.Test
import java.util.*

class QueenMovesTest {

    @Test
    fun queenMoveUp(){
        var board = Board(8,8, emptyMap(), emptySet(), emptyList())
        val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
        board = board.putPieceAt(Position(4, 4), queen)
        val move = ClassicMove(Position(4,4), Position(4,8), queen)
        val newBoard = board.movePiece(move)
        assert(newBoard.getPieceAt(Position(4,8)) == queen)
    }
    @Test
    fun queenMoveDown(){
        var board = Board(8,8, emptyMap(), emptySet(), emptyList())
        val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
        board = board.putPieceAt(Position(4, 4), queen)
        val move = ClassicMove(Position(4,4), Position(4,1), queen)
        val newBoard = board.movePiece(move)
        assert(newBoard.getPieceAt(Position(4,1)) == queen)
    }
    @Test
    fun queenMoveRight(){
        var board = Board(8,8, emptyMap(), emptySet(), emptyList())
        val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
        board = board.putPieceAt(Position(4, 4), queen)
        val move = ClassicMove(Position(4,4), Position(8,4), queen)
        val newBoard = board.movePiece(move)
        assert(newBoard.getPieceAt(Position(8,4)) == queen)
    }
    @Test
    fun queenMoveLeft(){
        var board = Board(8,8, emptyMap(), emptySet(), emptyList())
        val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
        board = board.putPieceAt(Position(4, 4), queen)
        val move = ClassicMove(Position(4,4), Position(1,4), queen)
        val newBoard = board.movePiece(move)
        assert(newBoard.getPieceAt(Position(1,4)) == queen)
    }
    @Test
    fun queenMoveUpRight(){
        var board = Board(8,8, emptyMap(), emptySet(), emptyList())
        val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
        board = board.putPieceAt(Position(4, 4), queen)
        val move = ClassicMove(Position(4,4), Position(8,8), queen)
        val newBoard = board.movePiece(move)
        assert(newBoard.getPieceAt(Position(8,8)) == queen)
    }
    @Test
    fun queenMoveUpLeft(){
        var board = Board(8,8, emptyMap(), emptySet(), emptyList())
        val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
        board = board.putPieceAt(Position(4, 4), queen)
        val move = ClassicMove(Position(4,4), Position(1,8), queen)
        val newBoard = board.movePiece(move)
        assert(newBoard.getPieceAt(Position(1,8)) == queen)
    }
    @Test
    fun queenMoveDownRight(){
        var board = Board(8,8, emptyMap(), emptySet(), emptyList())
        val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
        board = board.putPieceAt(Position(4, 4), queen)
        val move = ClassicMove(Position(4,4), Position(8,1), queen)
        val newBoard = board.movePiece(move)
        assert(newBoard.getPieceAt(Position(8,1)) == queen)
    }
    @Test
    fun queenMoveDownLeft(){
        var board = Board(8,8, emptyMap(), emptySet(), emptyList())
        val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
        board = board.putPieceAt(Position(4, 4), queen)
        val move = ClassicMove(Position(4,4), Position(1,1), queen)
        val newBoard = board.movePiece(move)
        assert(newBoard.getPieceAt(Position(1,1)) == queen)
    }
    @Test
    fun queenMoveUpRightBlocked(){
        var board = Board(8,8, emptyMap(), emptySet(), emptyList())
        val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
        val pawn = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.PAWN)
        board = board.putPieceAt(Position(4, 4), queen)
        board = board.putPieceAt(Position(5, 5), pawn)
        val move = ClassicMove(Position(4,4), Position(8,8), queen)
        val newBoard = board.movePiece(move)
        assert(newBoard.getPieceAt(Position(5,5)) == pawn)
    }
@Test
fun queenMoveUpLeftBlocked() {
    var board = Board(8, 8, emptyMap(), emptySet(), emptyList())
    val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
    val pawn = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.PAWN)
    board = board.putPieceAt(Position(4, 4), queen)
    board = board.putPieceAt(Position(3, 5), pawn)
    val move = ClassicMove(Position(4, 4), Position(1, 8), queen)
    val newBoard = board.movePiece(move)
    assert(newBoard.getPieceAt(Position(3, 5)) == pawn)
}
@Test
fun queenMoveDownRightBlocked() {
    var board = Board(8, 8, emptyMap(), emptySet(), emptyList())
    val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
    val pawn = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.PAWN)
    board = board.putPieceAt(Position(4, 4), queen)
    board = board.putPieceAt(Position(5, 3), pawn)
    val move = ClassicMove(Position(4, 4), Position(8, 1), queen)
    val newBoard = board.movePiece(move)
    assert(newBoard.getPieceAt(Position(5, 3)) == pawn)
}
@Test
fun queenMoveDownLeftBlocked() {
    var board = Board(8, 8, emptyMap(), emptySet(), emptyList())
    val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
    val pawn = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.PAWN)
    board = board.putPieceAt(Position(4, 4), queen)
    board = board.putPieceAt(Position(3, 3), pawn)
    val move = ClassicMove(Position(4, 4), Position(1, 1), queen)
    val newBoard = board.movePiece(move)
    assert(newBoard.getPieceAt(Position(3, 3)) == pawn)
}
@Test
fun queenInvalidMove(){
    var board = Board(8,8, emptyMap(), emptySet(), emptyList())
    val queen = PieceFactory().createPiece("1 1", Color.WHITE, PieceType.QUEEN)
    board = board.putPieceAt(Position(4, 4), queen)
    val gameType = GameType(ClassicChessRuleSet(""),ClassicEndConditions(), listOf(Player( Color.WHITE), Player( Color.BLACK)))
    val tm = ClassicChessTurnManager(gameType.getFirstPlayer())

    val game = GameEngine(board,tm,gameType, Stack(), Stack())
    val move = ClassicMove(Position(4,4), Position(8,7), queen)
    val result = game.move(move)
    assert(result is InvalidMoveResult)
}
}