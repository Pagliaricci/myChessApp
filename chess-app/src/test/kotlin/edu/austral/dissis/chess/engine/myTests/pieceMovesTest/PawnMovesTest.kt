package edu.austral.dissis.chess.engine.myTests.pieceMovesTest

import common.elements.color.Color
import common.game.GameEngine
import common.game.gameType.GameType
import common.game.results.InvalidMoveResult
import common.game.results.SuccessfulMoveResult
import common.elements.players.Player
import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import edu.austral.dissis.chess.engine.game.turnManagers.ClassicChessTurnManager
import edu.austral.dissis.chess.engine.game.types.endConditions.ClassicEndConditions
import edu.austral.dissis.chess.engine.game.types.ruleSets.ClassicChessRuleSet
import edu.austral.dissis.chess.engine.setUps.pawn.ChessPromotionSetUp
import edu.austral.dissis.chess.engine.setUps.pawn.PathNotClearSetUp
import edu.austral.dissis.chess.engine.setUps.pawn.PawnCaptureSetUp
import org.junit.jupiter.api.Test
import java.util.Stack

class PawnMovesTest {
    @Test
    fun pawnMovingOneUp(){
        val gameType = GameType(
            ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(gameType.getInitialBoard(),chessTM,gameType,Stack(),Stack())
        val move = ClassicMove(Position(1,2), Position(1,3),game.getBoard().getPieceAt(Position(1,2))!!)
        val result = game.move(move)
        assert(result is SuccessfulMoveResult)
    }
    @Test
    fun pawnMovingTwoUp(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(gameType.getInitialBoard(),chessTM,gameType,Stack(),Stack())
        val move = ClassicMove(Position(1,2), Position(1,4),game.getBoard().getPieceAt(Position(1,2))!!)
        val result = game.move(move)
        assert(result is SuccessfulMoveResult)
    }
    @Test
    fun promotion(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(ChessPromotionSetUp().setUp(),chessTM,gameType,Stack(),Stack())
        val move = ClassicMove(Position(1,7), Position(1,8),game.getBoard().getPieceAt(Position(1,7))!!)
        val result = game.move(move)
        assert(result is SuccessfulMoveResult)
    }
    @Test
    fun pawnInvalidMove(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(gameType.getInitialBoard(),chessTM,gameType,Stack(),Stack())
        val move = ClassicMove(Position(1,2), Position(1,5),game.getBoard().getPieceAt(Position(1,2))!!)
        val result = game.move(move)
        assert(result is InvalidMoveResult)
    }
    @Test
    fun pawnMoveBackwards(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(gameType.getInitialBoard(),chessTM,gameType,Stack(),Stack())
        val move = ClassicMove(Position(1,2), Position(1,1),game.getBoard().getPieceAt(Position(1,2))!!)
        val result = game.move(move)
        assert(result is InvalidMoveResult)
    }
    @Test
    fun pawnMoveDiagonal(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(gameType.getInitialBoard(),chessTM,gameType,Stack(),Stack())
        val move = ClassicMove(Position(1,2), Position(2,3),game.getBoard().getPieceAt(Position(1,2))!!)
        val result = game.move(move)
        assert(result is InvalidMoveResult)
    }
    @Test
    fun pawnPathNotClear(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(PathNotClearSetUp().setUp(),chessTM,gameType,Stack(),Stack())
        val move = ClassicMove(Position(1,2), Position(1,4),game.getBoard().getPieceAt(Position(1,2))!!)
        val result = game.move(move)
        assert(result is InvalidMoveResult)
    }
    @Test
    fun pawnCapture(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(PawnCaptureSetUp().setUp(),chessTM,gameType,Stack(),Stack())
        val move = ClassicMove(Position(1,2), Position(2,3),game.getBoard().getPieceAt(Position(1,2))!!)
        val result = game.move(move)
        assert(result is SuccessfulMoveResult)
    }
}