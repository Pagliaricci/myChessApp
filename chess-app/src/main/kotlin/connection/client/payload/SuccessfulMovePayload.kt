package connection.client.payload

import edu.austral.dissis.chess.gui.NewGameState

data class SuccessfulMovePayload(val result: NewGameState) {
}