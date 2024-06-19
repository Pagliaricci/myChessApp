package edu.austral.dissis.chess.engine.myTests.pieceMovesTest

import common.elements.color.Color
import common.elements.moveTypes.ClassicMove
import common.elements.players.Player
import common.elements.position.Position
import common.game.GameEngine
import common.game.gameType.GameType
import common.game.results.InvalidMoveResult
import common.game.results.SuccessfulMoveResult
import edu.austral.dissis.chess.engine.game.turnManagers.ClassicChessTurnManager
import edu.austral.dissis.chess.engine.game.types.endConditions.ClassicEndConditions
import edu.austral.dissis.chess.engine.game.types.ruleSets.ClassicChessRuleSet
import edu.austral.dissis.chess.engine.setUps.ClassicChessBoardSetUp
import edu.austral.dissis.chess.engine.setUps.king.CastlingSetUp
import org.junit.jupiter.api.Test
import java.util.*

class CastlingTest {

    private val players = listOf(Player(Color.WHITE), Player(Color.BLACK))
    private val chessGameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(),players)
    val chessTM = ClassicChessTurnManager(chessGameType.getFirstPlayer())

    @Test
    fun testCastling() {
        val game = GameEngine(ClassicChessBoardSetUp().setUp(), chessTM, chessGameType, Stack(), Stack())
        val move = ClassicMove(Position(5,1), Position(3,1), game.getBoard().getPieceAt(Position(5,1))!!)
        val result = game.move(move)
        assert(result is InvalidMoveResult)
        game.setBoard(CastlingSetUp().setUp())
        val move2 = ClassicMove(Position(5,1), Position(3,1), game.getBoard().getPieceAt(Position(5,1))!!)
        val result2 = game.move(move2)
        assert(result2 is SuccessfulMoveResult)
    }
}