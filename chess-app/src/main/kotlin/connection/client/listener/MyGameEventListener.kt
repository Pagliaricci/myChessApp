package connection.client.listener

import connection.client.GameClient
import edu.austral.dissis.chess.gui.GameEventListener
import edu.austral.dissis.chess.gui.Move

class MyGameEventListener(private val gameClient: GameClient): GameEventListener {
    override fun handleMove(move: Move) {
        gameClient.sendMove(move)

    }

    override fun handleRedo() {
        gameClient.redo()
    }

    override fun handleUndo() {
        gameClient.undo()
    }
}