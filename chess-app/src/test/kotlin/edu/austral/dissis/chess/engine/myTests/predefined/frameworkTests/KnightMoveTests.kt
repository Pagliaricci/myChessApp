package edu.austral.dissis.chess.engine.myTests.predefined.frameworkTests

import edu.austral.dissis.chess.engine.myTests.predefined.MyTestMoveRunner
import edu.austral.dissis.chess.test.TestPosition
import edu.austral.dissis.chess.test.Validity.INVALID
import edu.austral.dissis.chess.test.move.MoveTester
import edu.austral.dissis.chess.test.parser.ParseSettings
import org.junit.jupiter.api.Test

class KnightMoveTests {
    private val moveTester: MoveTester = MoveTester(MyTestMoveRunner())

    @Test
    fun `test basic knight moves`() {
        moveTester.testMove(
            "/moves/knight/valid_moves.txt",
            TestPosition(5, 4),
            ParseSettings(INVALID))
    }
}