package connection.client.listener

import connection.client.GameClient
import connection.server.payload.ClientPayload
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

class InitialStateListener(private val gameClient: GameClient): MessageListener<ClientPayload> {
    override fun handleMessage(message: Message<ClientPayload>) {
        gameClient.handleInitialState(message.payload.initialState)
    }


}