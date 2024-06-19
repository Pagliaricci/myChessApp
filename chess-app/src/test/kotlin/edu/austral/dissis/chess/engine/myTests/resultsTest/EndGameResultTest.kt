package edu.austral.dissis.chess.engine.myTests.resultsTest

import common.elements.color.Color
import common.elements.moveTypes.ClassicMove
import common.elements.players.Player
import common.elements.position.Position
import common.game.GameEngine
import common.game.gameType.GameType
import common.game.results.EndGameResult
import common.game.results.SuccessfulMoveResult
import edu.austral.dissis.chess.engine.game.turnManagers.ClassicChessTurnManager
import edu.austral.dissis.chess.engine.game.types.endConditions.ClassicEndConditions
import edu.austral.dissis.chess.engine.game.types.ruleSets.ClassicChessRuleSet
import edu.austral.dissis.chess.engine.setUps.ClassicChessBoardSetUp
import edu.austral.dissis.chess.engine.setUps.king.CheckMateSetUp
import org.junit.jupiter.api.Test
import java.util.Stack

class EndGameResultTest {
    private val players = listOf(Player(Color.WHITE), Player(Color.BLACK))
    private val chessGameType = GameType(ClassicChessRuleSet(""),ClassicEndConditions(),players)
    val chessTM = ClassicChessTurnManager(chessGameType.getFirstPlayer())

    @Test
    fun testEndGameResult() {
        val game = GameEngine(CheckMateSetUp().setUp(), chessTM,chessGameType,Stack(),Stack())
        val move = ClassicMove(Position(8,7), Position(8,8),game.getBoard().getPieceAt(Position(8,7))!!)
        val result = game.move(move)
        assert(result is EndGameResult)
    }
    @Test
    fun scholarsMate(){
        var game = GameEngine(ClassicChessBoardSetUp().setUp(), chessTM,chessGameType,Stack(),Stack())
        val move = ClassicMove(Position(5,2), Position(5,4),game.getBoard().getPieceAt(Position(5,2))!!)
        val result1 = game.move(move)
        game = result1.getGame()
        assert(result1 is SuccessfulMoveResult)
        val move2 = ClassicMove(Position(5,7), Position(5,5),game.getBoard().getPieceAt(Position(5,7))!!)
        val result2 = game.move(move2)
        game = result2.getGame()
        assert(result2 is SuccessfulMoveResult)
        val move3 = ClassicMove(Position(6,1), Position(3,4),game.getBoard().getPieceAt(Position(6,1))!!)
        val result3 = game.move(move3)
        game = result3.getGame()
        assert(result3 is SuccessfulMoveResult)
        val move4 = ClassicMove(Position(2,8), Position(3,6),game.getBoard().getPieceAt(Position(2,8))!!)
        val result4 = game.move(move4)
        game = result4.getGame()
        assert(result4 is SuccessfulMoveResult)
        val move5 = ClassicMove(Position(4,1), Position(8,5),game.getBoard().getPieceAt(Position(4,1))!!)
        val result5 = game.move(move5)
        game = result5.getGame()
        assert(result5 is SuccessfulMoveResult)
        val move6 = ClassicMove(Position(7,8), Position(6,6),game.getBoard().getPieceAt(Position(7,8))!!)
        val result6 = game.move(move6)
        game = result6.getGame()
        assert(result6 is SuccessfulMoveResult)
        val move7 = ClassicMove(Position(8,5), Position(6,7),game.getBoard().getPieceAt(Position(8,5))!!)
        val result7 = game.move(move7)
        assert(result7 is EndGameResult)
    }
    @Test
    fun foolsMateTest(){
        var game = GameEngine(ClassicChessBoardSetUp().setUp(), chessTM,chessGameType,Stack(),Stack())
        val move = ClassicMove(Position(5,2), Position(5,4),game.getBoard().getPieceAt(Position(5,2))!!)
        val result1 = game.move(move)
        game = result1.getGame()
        assert(result1 is SuccessfulMoveResult)
        val move2 = ClassicMove(Position(6,7), Position(6,5),game.getBoard().getPieceAt(Position(6,7))!!)
        val result2 = game.move(move2)
        game = result2.getGame()
        assert(result2 is SuccessfulMoveResult)
        val move3 = ClassicMove(Position(4,1), Position(6,3),game.getBoard().getPieceAt(Position(4,1))!!)
        val result3 = game.move(move3)
        game = result3.getGame()
        assert(result3 is SuccessfulMoveResult)
        val move4 = ClassicMove(Position(7,7), Position(7,5),game.getBoard().getPieceAt(Position(7,7))!!)
        val result4 = game.move(move4)
        game = result4.getGame()
        assert(result4 is SuccessfulMoveResult)
        val move5 = ClassicMove(Position(6,3), Position(8,5),game.getBoard().getPieceAt(Position(6,3))!!)
        val result5 = game.move(move5)
        assert(result5 is EndGameResult)
    }
}