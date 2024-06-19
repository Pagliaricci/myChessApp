package connection.server.listener

import connection.server.GameServer
import edu.austral.ingsis.clientserver.ServerConnectionListener

class MyServerConnectionListener(private val gameServer: GameServer): ServerConnectionListener {
    override fun handleClientConnection(clientId: String) {
        println("Client connected: $clientId")
        gameServer.handleClientConnection(clientId)
        gameServer.handleInitialState()

    }

    override fun handleClientConnectionClosed(clientId: String) {
        TODO("Not yet implemented")
    }

}