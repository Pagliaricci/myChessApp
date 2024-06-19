package connection.client.listener

import connection.client.GameClient
import connection.client.payload.InvalidMovePayload
import connection.client.payload.SuccessfulMovePayload
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

class InvalidMoveListener(private val gameClient: GameClient): MessageListener<InvalidMovePayload> {

    override fun handleMessage(message: Message<InvalidMovePayload>) {
        println("llegue a GameClient Handling invalid move result")
        gameClient.handleInvalidMoveResult(message.payload.result)
    }
}
