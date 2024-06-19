package connection.server


import common.elements.color.Color
import common.game.GameEngine
import common.game.gameType.GameType
import common.elements.players.Player
import common.ui.UIGameEngine
import edu.austral.dissis.chess.engine.game.turnManagers.ClassicChessTurnManager
import edu.austral.dissis.chess.engine.game.types.endConditions.ClassicEndConditions
import edu.austral.dissis.chess.engine.game.types.ruleSets.ClassicChessRuleSet
import java.util.*

class ChessServer {

    private val gameType = GameType(ClassicChessRuleSet(""), ClassicEndConditions(), listOf(Player(Color.WHITE), Player(Color.BLACK)))
    private val chessTM = ClassicChessTurnManager(gameType.getPlayers()[0])
    private val chessGame = GameEngine(gameType.getInitialBoard(),chessTM, gameType, Stack(), Stack())
    private val engine = UIGameEngine(chessGame)
    private val server = GameServer(engine)
    fun start() {
        server.start()
    }
    fun stop() {
        server.stop()
    }
}
fun main() {
    val server = ChessServer()
    server.start()
}