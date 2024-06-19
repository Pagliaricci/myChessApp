package edu.austral.dissis.chess.engine.game.types.ruleSets

import common.board.Board
import common.game.actions.Action
import common.game.rules.GameRule
import common.game.sharedRules.FriendlyFire
import common.game.sharedRules.IsTargetWithinBounds
import common.game.sharedRules.ItsPlayersTurn
import common.game.gameType.ruleSet.RuleSet
import common.elements.players.Player
import common.elements.moveTypes.ClassicMove
import edu.austral.dissis.chess.engine.game.actions.CastlingAction
import edu.austral.dissis.chess.engine.game.actions.ChessPromotion
import edu.austral.dissis.chess.engine.game.rules.CheckValidator
import edu.austral.dissis.chess.engine.game.rules.ClearPath

class ClassicChessRuleSet(private var msg: String) : RuleSet {
    private val actions = listOf(ChessPromotion(), CastlingAction())

    override fun getRules(): List<GameRule> {
        return listOf(
            ClearPath(),
            ItsPlayersTurn(),
            FriendlyFire(),
            IsTargetWithinBounds(),
            CheckValidator())
    }


    override fun getMessage(): String{
        return msg
    }

    override fun getGameActions(): List<Action> {
        return actions
    }


}