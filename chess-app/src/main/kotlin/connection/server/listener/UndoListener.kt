package connection.server.listener

import connection.client.payload.UndoPayload
import connection.server.GameServer
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

class UndoListener(private val gameServer: GameServer): MessageListener<UndoPayload> {

    override fun handleMessage(message: Message<UndoPayload>) {
        print("llegue a UndoListener")
        val result = gameServer.getGameEngine().undo()
        gameServer.handleSuccessfulMove(result)
    }
}