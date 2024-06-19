package connection.server

import com.fasterxml.jackson.core.type.TypeReference
import connection.client.payload.*
import connection.server.listener.MoveListener
import connection.server.listener.MyServerConnectionListener
import connection.server.listener.RedoListener
import connection.server.listener.UndoListener
import connection.server.payload.ClientPayload
import edu.austral.dissis.chess.gui.*
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.ServerBuilder
import edu.austral.ingsis.clientserver.netty.server.NettyServerBuilder
import edu.austral.ingsis.clientserver.serialization.json.JsonSerializer

class GameServer(private val engine: GameEngine, private val builder: ServerBuilder = NettyServerBuilder.createDefault()) {


    private val server = builder
        .withPort(8080)
        .withConnectionListener(MyServerConnectionListener(this))
        .addMessageListener("move", object : TypeReference<Message<MovePayload>>(){}, MoveListener(this))
        .addMessageListener("undo",object :TypeReference<Message<UndoPayload>>(){}, UndoListener(this))
        .addMessageListener("redo",object :TypeReference<Message<RedoPayload>>(){}, RedoListener(this))
        .build()

    fun start() {
        server.start()
    }
    fun stop() {
        server.stop()
    }


    fun handleClientConnection(clientId: String) {
        server.sendMessage( clientId,Message("initialState", ClientPayload(clientId,engine.init())))
    }

    fun handleInitialState() {
        val initialState = engine.init()
        val initialStateSerialized = JsonSerializer().serialize(initialState)
        server.broadcast(Message("initialState", initialStateSerialized))
    }
    fun getGameEngine(): GameEngine {
        return engine
    }

    fun handleInvalidMove(result: InvalidMove) {
        server.broadcast(Message("invalidMove", InvalidMovePayload(result)))
    }

    fun handleGameOver(result: GameOver) {
        server.broadcast(Message("gameOver", GameOverPayload(result)))
    }

    fun handleSuccessfulMove(result: NewGameState) {
        server.broadcast(Message("successfulMove", SuccessfulMovePayload(result )))
    }


}