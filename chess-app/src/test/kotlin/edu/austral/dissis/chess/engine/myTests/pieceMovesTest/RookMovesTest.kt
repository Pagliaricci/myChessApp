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
import edu.austral.dissis.chess.engine.setUps.rook.RookMovesSetUp
import edu.austral.dissis.chess.engine.setUps.rook.RookPathNotClearSetUp
import org.junit.jupiter.api.Test
import java.util.*

class RookMovesTest {
    @Test
    fun rookMovingRight(){
        val gameType = GameType(
            ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(RookMovesSetUp().setUp(),chessTM,gameType, Stack(), Stack())
        val move = ClassicMove(Position(1,1), Position(2,1),game.getBoard().getPieceAt(Position(1,1))!!)
        val result = game.move(move)
        assert(result is SuccessfulMoveResult)
    }
    @Test
    fun rookMovingLeft(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(RookMovesSetUp().setUp(),chessTM,gameType, Stack(), Stack())
        val move = ClassicMove(Position(1,1), Position(0,1),game.getBoard().getPieceAt(Position(1,1))!!)
        val result = game.move(move)
        assert(result is InvalidMoveResult)
    }
    @Test
    fun rookMovingUp(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(RookMovesSetUp().setUp(),chessTM,gameType, Stack(), Stack())
        val move = ClassicMove(Position(1,1), Position(1,7),game.getBoard().getPieceAt(Position(1,1))!!)
        val result = game.move(move)
        assert(result is SuccessfulMoveResult)
    }
    @Test
    fun rookMovingDown(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(RookMovesSetUp().setUp(),chessTM,gameType, Stack(), Stack())
        val move = ClassicMove(Position(1,1), Position(1,0),game.getBoard().getPieceAt(Position(1,1))!!)
        val result = game.move(move)
        assert(result is InvalidMoveResult)
    }
    @Test
    fun rookInvalidMove(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(RookMovesSetUp().setUp(),chessTM,gameType, Stack(), Stack())
        val move = ClassicMove(Position(1,1), Position(7,2),game.getBoard().getPieceAt(Position(1,1))!!)
        val result = game.move(move)
        assert(result is InvalidMoveResult)
    }
    @Test
    fun rookMoveDiagonal(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(RookMovesSetUp().setUp(),chessTM,gameType, Stack(), Stack())
        val move = ClassicMove(Position(1,1), Position(3,3),game.getBoard().getPieceAt(Position(1,1))!!)
        val result = game.move(move)
        assert(result is InvalidMoveResult)
    }
    @Test
    fun rookPathNotClear(){
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(
            Player(Color.WHITE), Player(
            Color.BLACK)
        ))
        val chessTM = ClassicChessTurnManager(gameType.getFirstPlayer())
        val game = GameEngine(RookPathNotClearSetUp().setUp(),chessTM,gameType, Stack(), Stack())
        val move = ClassicMove(Position(1,2), Position(1,4),game.getBoard().getPieceAt(Position(1,2))!!)
        val result = game.move(move)
        assert(result is InvalidMoveResult)
    }
}