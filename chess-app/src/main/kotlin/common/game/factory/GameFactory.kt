package common.game.factory

import checkers.game.turnManagers.CheckersTurnManager
import checkers.game.types.endConditions.CheckersEndCondition
import checkers.game.types.ruleSets.CheckersRuleSet
import common.board.Board
import common.elements.color.Color
import common.game.GameEngine
import common.game.gameType.GameType
import common.elements.players.Player
import edu.austral.dissis.chess.engine.game.turnManagers.ClassicChessTurnManager
import edu.austral.dissis.chess.engine.game.types.endConditions.ClassicEndConditions
import edu.austral.dissis.chess.engine.game.types.endConditions.FirstCheckEndCondition
import edu.austral.dissis.chess.engine.game.types.ruleSets.ClassicChessRuleSet
import edu.austral.dissis.chess.engine.game.types.ruleSets.OnlyJumpRuleSet

import java.util.*

class GameFactory {
    fun createChessGame (board: Board): GameEngine {
        val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(Player(Color.WHITE), Player(Color.BLACK)))
        return GameEngine(board, ClassicChessTurnManager(gameType.getFirstPlayer()),gameType, Stack(), Stack())
    }
    fun createCheckersGame (board: Board): GameEngine {
        val gameType = GameType(CheckersRuleSet(), CheckersEndCondition(), listOf(Player(Color.WHITE), Player(Color.BLACK)))
        return GameEngine(board, CheckersTurnManager(gameType.getFirstPlayer()),gameType, Stack(), Stack())
    }

    fun createFirstCheckGame (board: Board): GameEngine {
        val gameType = GameType(ClassicChessRuleSet(""), FirstCheckEndCondition(), listOf(Player(Color.WHITE), Player(Color.BLACK)))
        return GameEngine(board, ClassicChessTurnManager(gameType.getFirstPlayer()),gameType, Stack(), Stack())
    }

    fun createOnlyJumpGame(board: Board): GameEngine {
        val gameType = GameType(OnlyJumpRuleSet("No clear path"), ClassicEndConditions(), listOf(Player(Color.WHITE), Player(Color.BLACK)))
        return GameEngine(board, ClassicChessTurnManager(gameType.getFirstPlayer()),gameType, Stack(), Stack())
    }

}