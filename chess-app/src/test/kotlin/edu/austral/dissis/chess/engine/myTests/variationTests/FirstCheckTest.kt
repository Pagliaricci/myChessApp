package edu.austral.dissis.chess.engine.myTests.variationTests

import common.elements.moveTypes.ClassicMove
import common.elements.position.Position
import common.game.factory.GameFactory
import edu.austral.dissis.chess.engine.setUps.ClassicChessBoardSetUp
import org.junit.jupiter.api.Test

class FirstCheckTest {
    var firstCheckGame = GameFactory().createFirstCheckGame(ClassicChessBoardSetUp().setUp())

    @Test
    fun testFirstCheck(){
        val move1 = ClassicMove(Position(5,2), Position(5,3), firstCheckGame.getBoard().getPieceAt(Position(5,2))!!)
        val result1 = firstCheckGame.move(move1)
        assert(result1 is common.game.results.SuccessfulMoveResult)
        firstCheckGame = result1.getGame()
        val move2 = ClassicMove(Position(6,7), Position(6,5), firstCheckGame.getBoard().getPieceAt(Position(6,7))!!)
        val result2 = firstCheckGame.move(move2)
        assert(result2 is common.game.results.SuccessfulMoveResult)
        firstCheckGame = result2.getGame()
        val move3 = ClassicMove(Position(4,1), Position(8,5), firstCheckGame.getBoard().getPieceAt(Position(4,1))!!)
        val result3 = firstCheckGame.move(move3)
        assert(result3 is common.game.results.EndGameResult)
    }
}