package edu.austral.dissis.chess.engine.game.types.ruleSets

import common.game.actions.Action
import common.game.gameType.ruleSet.RuleSet
import common.game.rules.GameRule
import common.game.sharedRules.FriendlyFire
import common.game.sharedRules.IsTargetWithinBounds
import common.game.sharedRules.ItsPlayersTurn
import edu.austral.dissis.chess.engine.game.actions.CastlingAction
import edu.austral.dissis.chess.engine.game.actions.ChessPromotion
import edu.austral.dissis.chess.engine.game.rules.CheckValidator

class OnlyJumpRuleSet(private val msg : String):RuleSet {
    private val actions = listOf(ChessPromotion(), CastlingAction())
    override fun getRules(): List<GameRule> {
        return listOf(
            ItsPlayersTurn(),
            FriendlyFire(),
            IsTargetWithinBounds(),
            CheckValidator()
        )
    }


    override fun getMessage(): String{
        return msg
    }

    override fun getGameActions(): List<Action> {
        return actions
    }


}