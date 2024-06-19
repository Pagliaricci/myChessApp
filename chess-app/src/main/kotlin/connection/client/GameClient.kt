package connection.client

import com.fasterxml.jackson.core.type.TypeReference
import connection.client.payload.GameOverPayload
import connection.client.payload.InvalidMovePayload
import connection.server.payload.ClientPayload
import connection.client.payload.SuccessfulMovePayload
import connection.client.payload.UndoPayload
import connection.client.listener.*
import edu.austral.dissis.chess.gui.*
import edu.austral.ingsis.clientserver.ClientBuilder
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.netty.client.NettyClientBuilder
import javafx.application.Platform
import java.net.InetSocketAddress

class GameClient(private val builder: ClientBuilder = NettyClientBuilder.createDefault(),private val gameView: GameView ) {


    private val gameEventListener = MyGameEventListener(this)
    private val client = builder
        .withAddress(InetSocketAddress("localhost", 8080))
        .withConnectionListener(MyClientConnectionListener(this))
        .addMessageListener("initialState", object : TypeReference<Message<ClientPayload>>(){}, InitialStateListener(this))
        .addMessageListener("invalidMove", object : TypeReference<Message<InvalidMovePayload>>(){}, InvalidMoveListener(this))
        .addMessageListener("successfulMove", object : TypeReference<Message<SuccessfulMovePayload>>(){}, SuccessfulMoveListener(this))
        .addMessageListener("gameOver", object : TypeReference<Message<GameOverPayload>>(){}, GameOverListener(this))
        .build()

    private lateinit var clientId: String


    fun connect() {
        client.connect()
    }
    fun disconnect() {
        client.closeConnection()
    }
    fun handleId(clientId: String) {
        this.clientId = clientId
    }

    fun handleInitialState(initialState: InitialState) {
        Platform.runLater{
            gameView.handleInitialState(initialState)
        }

    }

    fun addListenerToGameView(){
        gameView.addListener(gameEventListener)
    }

    fun sendMove(move: Move){
        println("llegue a GameClient send move")
        client.send(Message("move", move))
    }

    fun handleGameOverResult(result: MoveResult) {
        println("llegue a GameClient Handling Game Over result")
        Platform.runLater{
            gameView.handleMoveResult(result)
        }
    }
    fun handleSuccessfulMoveResult(result: MoveResult) {
        println("llegue a GameClient Handling Successful Move result")
        Platform.runLater{
            gameView.handleMoveResult(result)
        }
    }
    fun handleInvalidMoveResult(result: MoveResult) {
        println("llegue a GameClient Handling Invalid Move result")
        Platform.runLater{
            gameView.handleMoveResult(result)
        }
    }

    fun undo() {
        client.send(Message("undo", UndoPayload(true)))
    }
    fun redo() {
        client.send(Message("redo", UndoPayload(true)))
    }



}
