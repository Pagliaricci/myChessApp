package connection.client.listener

import connection.client.GameClient
import connection.client.payload.SuccessfulMovePayload
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

class SuccessfulMoveListener(private val gameClient: GameClient): MessageListener<SuccessfulMovePayload> {

    override fun handleMessage(message: Message<SuccessfulMovePayload>) {
        println("llegue a GameClient Handling successful move result")
        gameClient.handleSuccessfulMoveResult(message.payload.result)
    }


}