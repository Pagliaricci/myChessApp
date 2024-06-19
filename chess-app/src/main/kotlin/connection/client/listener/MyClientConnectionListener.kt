package connection.client.listener

import connection.client.GameClient
import edu.austral.ingsis.clientserver.ClientConnectionListener

class MyClientConnectionListener(private val gameClient: GameClient): ClientConnectionListener {
    override fun handleConnection() {
       println("Connected to server")
        gameClient.addListenerToGameView()
    }

    override fun handleConnectionClosed() {
        println("Connection closed")
    }
}