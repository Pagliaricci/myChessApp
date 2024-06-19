package common.ui

import checkers.setUps.CaptureAndPromotionSetUp
import checkers.setUps.CheckersSetUp
import checkers.setUps.EndGameSetUp
import checkers.setUps.MultipleCapturesSetUp
import common.game.factory.GameFactory
import edu.austral.dissis.chess.engine.setUps.ClassicChessBoardSetUp
import edu.austral.dissis.chess.engine.setUps.variations.ChancellorBoardSetUp
import edu.austral.dissis.chess.gui.*
import javafx.application.Application
import javafx.application.Application.launch
import javafx.scene.Scene
import javafx.stage.Stage


fun main() {
    launch(ChessGameApplication::class.java)
}

class ChessGameApplication : Application() {


    private val chessGame = GameFactory().createChessGame(ClassicChessBoardSetUp().setUp())
    private val chancellorGame = GameFactory().createChessGame(ChancellorBoardSetUp().setUp())
    private val firstCheckGame = GameFactory().createFirstCheckGame(ClassicChessBoardSetUp().setUp())
    private val onlyJumpGame = GameFactory().createOnlyJumpGame(ClassicChessBoardSetUp().setUp())
    private val checkersGame = GameFactory().createCheckersGame(EndGameSetUp().setUp())
    private val multipleCaptureGame = GameFactory().createCheckersGame(MultipleCapturesSetUp().setUp())

    private val gameEngine = UIGameEngine (chancellorGame)
    private val imageResolver = CachedImageResolver(DefaultImageResolver())


    companion object {
        const val GameTitle = "Chess"
    }

    override fun start(primaryStage: Stage) {
        primaryStage.title = GameTitle

        val root = createGameViewFrom(gameEngine, imageResolver)
        primaryStage.scene = Scene(root)

        primaryStage.show()
    }
}