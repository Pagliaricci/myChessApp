package common.game.gameType.ruleSet

import common.board.Board
import common.game.actions.Action
import common.game.rules.GameRule
import common.elements.players.Player
import common.elements.moveTypes.ClassicMove

interface RuleSet {
    fun getRules(): List<GameRule>
    fun getMessage():String
    fun getGameActions(): List<Action>
}
