package connection.client.listener

import connection.client.GameClient
import connection.client.payload.GameOverPayload
import connection.client.payload.SuccessfulMovePayload
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

class GameOverListener(private val gameClient: GameClient): MessageListener<GameOverPayload> {

    override fun handleMessage(message: Message<GameOverPayload>) {
        println("llegue a GameClient Handling successful move result")
        gameClient.handleGameOverResult(message.payload.result)
    }


}