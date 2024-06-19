package common.game.gameType
import common.board.Board
import common.game.GameEngine
import common.game.actions.Action
import common.game.gameType.ruleSet.RuleSet
import common.game.gameType.endConditions.EndCondition
import common.elements.players.Player
import common.elements.moveTypes.ClassicMove

class GameType(private val ruleSet: RuleSet, private val endCondition: EndCondition, private val players : List<Player>){

    fun getEndConditions(): List<EndCondition> {
        return listOf(endCondition)
    }

    fun getInitialBoard(): Board {
        val board =  edu.austral.dissis.chess.engine.setUps.ClassicChessBoardSetUp().setUp()
        return board
    }

    fun getRuleSet(): RuleSet {
        return ruleSet
    }

    fun getBoardActions(): List<Action> {
        return ruleSet.getGameActions()
    }

    fun getPlayers(): List<Player> {
        return players
    }

    fun getGameMessage(): String {
        return ""
    }

    fun isEndConditionMet(game: GameEngine, player: Player): Boolean {
        return endCondition.check(game, player)
    }

    fun getAction(board: Board, move: ClassicMove): List<Action?> {
        val actions = mutableListOf<Action?>()
        for (action in getBoardActions()) {
            if (action.isFulfilled(board, move)) {
                actions.add(action)
            }
        }
        return actions
    }

    fun getFirstPlayer(): Player {
        return players[0]
    }
}