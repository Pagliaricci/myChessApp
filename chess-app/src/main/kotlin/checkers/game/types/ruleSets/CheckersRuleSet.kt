package checkers.game.types.ruleSets

import checkers.game.actions.Capture
import checkers.game.actions.CheckersPromotion
import checkers.game.rules.EmptyTargetPosition
import checkers.game.rules.ForcedCapture
import common.game.actions.Action
import common.game.gameType.ruleSet.RuleSet
import common.game.rules.GameRule
import common.game.sharedRules.IsTargetWithinBounds
import common.game.sharedRules.ItsPlayersTurn

class CheckersRuleSet: RuleSet {
    private val actions = listOf(Capture(),CheckersPromotion())


    override fun getRules(): List<GameRule> {
        return listOf(EmptyTargetPosition(),
            ItsPlayersTurn(),
            IsTargetWithinBounds(),
            ForcedCapture())
    }

    override fun getMessage(): String {
        return ""
    }

    override fun getGameActions(): List<Action> {
        return actions
    }
}