package connection.server.listener

import connection.client.payload.RedoPayload
import connection.server.GameServer
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

class RedoListener(private val gameServer: GameServer): MessageListener<RedoPayload> {
    override fun handleMessage(message: Message<RedoPayload>) {
        val result = gameServer.getGameEngine().redo()
        gameServer.handleSuccessfulMove(result)
    }
}