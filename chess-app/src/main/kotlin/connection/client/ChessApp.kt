package connection.client

import edu.austral.dissis.chess.gui.CachedImageResolver
import edu.austral.dissis.chess.gui.DefaultImageResolver
import edu.austral.dissis.chess.gui.GameView
import common.ui.ChessGameApplication
import javafx.application.Application
import javafx.application.Application.launch
import javafx.scene.Scene
import javafx.stage.Stage

class ChessApp: Application() {


    private val imageResolver = CachedImageResolver(DefaultImageResolver())
    private val gameView = GameView(imageResolver)
    private val gameClient = GameClient(gameView = gameView)


    companion object {
        const val GameTitle = "Chess"
    }
    override fun start(p0: Stage) {
        p0.title = ChessGameApplication.GameTitle
        val root = gameView
        p0.scene = Scene(root)
        p0.show()

        gameClient.connect()

    }
}

fun main() {
    launch(ChessApp::class.java)

}