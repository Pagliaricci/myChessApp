package connection.server.listener

import connection.client.payload.MovePayload
import connection.server.GameServer
import edu.austral.dissis.chess.gui.GameOver
import edu.austral.dissis.chess.gui.InvalidMove
import edu.austral.dissis.chess.gui.Move
import edu.austral.dissis.chess.gui.NewGameState
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

class MoveListener(private val gameServer: GameServer): MessageListener<MovePayload> {

    override fun handleMessage(message: Message<MovePayload>) {
        println("llegue a MoveListener HandleMessage")
        val from = message.payload.from
        val to = message.payload.to
        val result = gameServer.getGameEngine().applyMove(Move(from, to))
        if(result is InvalidMove){
            gameServer.handleInvalidMove(result)
        }
        if(result is GameOver){
            gameServer.handleGameOver(result )
        }
        if(result is NewGameState)
        gameServer.handleSuccessfulMove(result )
    }

}