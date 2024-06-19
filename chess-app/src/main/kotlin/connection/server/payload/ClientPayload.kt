package connection.server.payload

import edu.austral.dissis.chess.gui.InitialState

data class ClientPayload(val clientId: String, val initialState: InitialState) {
}