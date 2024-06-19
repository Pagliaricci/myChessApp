# detekt

## Metrics

* 264 number of properties

* 205 number of functions

* 103 number of classes

* 43 number of packages

* 97 number of kt files

## Complexity Report

* 2,481 lines of code (loc)

* 2,016 source lines of code (sloc)

* 1,111 logical lines of code (lloc)

* 77 comment lines of code (cloc)

* 348 cyclomatic complexity (mcc)

* 156 cognitive complexity

* 229 number of total code smells

* 3% comment source ratio

* 313 mcc per 1,000 lloc

* 206 code smells per 1,000 lloc

## Findings (229)

### complexity, ComplexCondition (1)

Complex conditions should be simplified and extracted into well-named methods if necessary.

[Documentation](https://detekt.dev/docs/rules/complexity#complexcondition)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/PawnMovesComposite.kt:14:12
```
This condition is too complex (4). Defined complexity threshold for conditions is set to '4'
```
```kotlin
11     private val vertical = MoveVertically()
12     private val diagonal = MoveDiagonally()
13     override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
14         if(( vertical.isFulfilled(board,move) && !IsEnemyPieceThere().verify(board,move)) || (diagonal.isFulfilled(board,move) && IsEnemyPieceThere().verify(board, move))) {
!!            ^ error
15             return forward.isFulfilled(board,move)
16         }
17         return false

```

### complexity, CyclomaticComplexMethod (1)

Prefer splitting up complex methods into smaller, easier to test methods.

[Documentation](https://detekt.dev/docs/rules/complexity#cyclomaticcomplexmethod)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/rules/ClearPath.kt:22:17
```
The function getPath appears to be too complex based on Cyclomatic Complexity (complexity: 15). Defined complexity threshold for methods is set to '15'
```
```kotlin
19         println(path)
20         return theresNoPieceInPath(board, path)
21     }
22     private fun getPath(board: Board, move: ClassicMove): List<Position> {
!!                 ^ error
23         val path = mutableListOf<Position>()
24         val vertical = MoveVertically()
25         val horizontal = MoveHorizontally()

```

### complexity, NestedBlockDepth (1)

Excessive nesting leads to hidden complexity. Prefer extracting code to make it easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#nestedblockdepth)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/types/endConditions/ClassicEndConditions.kt:24:17
```
Function isThereAnyValidMove is nested too deeply.
```
```kotlin
21     override fun check(game: GameEngine, player: Player): Boolean {
22         return checkWin(game,player)
23     }
24     private fun isThereAnyValidMove(game: GameEngine, player: Player): Boolean {
!!                 ^ error
25         val board = game.getBoard()
26         val pieces = board.getPieces().filter { it.playersColor == player.getColor() }
27         for (piece in pieces) {

```

### empty-blocks, EmptyClassBlock (9)

Empty block of code detected. As they serve no purpose they should be removed.

[Documentation](https://detekt.dev/docs/rules/empty-blocks#emptyclassblock)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/elements/moveTypes/ClassicMove.kt:8:80
```
The class or object ClassicMove is empty.
```
```kotlin
5  import common.piece.Piece
6  import common.elements.position.Position
7  
8  data class ClassicMove(val from: Position, val to: Position, val piece: Piece) {
!                                                                                 ^ error
9  
10 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/elements/position/Position.kt:3:46
```
The class or object Position is empty.
```
```kotlin
1 package common.elements.position
2 
3 data class Position( val x: Int, val y: Int) {
!                                              ^ error
4 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/payload/GameOverPayload.kt:4:44
```
The class or object GameOverPayload is empty.
```
```kotlin
1 package connection.client.payload
2 
3 import edu.austral.dissis.chess.gui.GameOver
4 class GameOverPayload(val result: GameOver){
!                                            ^ error
5 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/payload/InvalidMovePayload.kt:6:51
```
The class or object InvalidMovePayload is empty.
```
```kotlin
3  import edu.austral.dissis.chess.gui.InvalidMove
4  
5  
6  class InvalidMovePayload(val result:  InvalidMove){
!                                                    ^ error
7  }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/payload/MovePayload.kt:6:62
```
The class or object MovePayload is empty.
```
```kotlin
3  import edu.austral.dissis.chess.gui.NewGameState
4  import edu.austral.dissis.chess.gui.Position
5  
6  data class MovePayload(val from: Position, val to: Position) {
!                                                               ^ error
7  }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/payload/RedoPayload.kt:3:40
```
The class or object RedoPayload is empty.
```
```kotlin
1 package connection.client.payload
2 
3 class RedoPayload(val result: Boolean) {
!                                        ^ error
4 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/payload/SuccessfulMovePayload.kt:5:60
```
The class or object SuccessfulMovePayload is empty.
```
```kotlin
2 
3 import edu.austral.dissis.chess.gui.NewGameState
4 
5 data class SuccessfulMovePayload(val result: NewGameState) {
!                                                            ^ error
6 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/payload/UndoPayload.kt:3:39
```
The class or object UndoPayload is empty.
```
```kotlin
1 package connection.client.payload
2 
3 class UndoPayload(val result: Boolean){
!                                       ^ error
4 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/server/payload/ClientPayload.kt:5:80
```
The class or object ClientPayload is empty.
```
```kotlin
2 
3 import edu.austral.dissis.chess.gui.InitialState
4 
5 data class ClientPayload(val clientId: String, val initialState: InitialState) {
!                                                                                ^ error
6 }

```

### empty-blocks, EmptyDefaultConstructor (1)

Empty block of code detected. As they serve no purpose they should be removed.

[Documentation](https://detekt.dev/docs/rules/empty-blocks#emptydefaultconstructor)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/adapters/PieceAdapter.kt:8:19
```
An empty default constructor can be removed.
```
```kotlin
5  import edu.austral.dissis.chess.gui.ChessPiece
6  import java.util.*
7  
8  class PieceAdapter() {
!                    ^ error
9  
10     fun adapt(piece: Piece, board: Board): ChessPiece {
11         val playerColor = ColorAdapter().translatePlayerColor(piece.playersColor)

```

### empty-blocks, EmptyKtFile (2)

Empty block of code detected. As they serve no purpose they should be removed.

[Documentation](https://detekt.dev/docs/rules/empty-blocks#emptyktfile)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/test/kotlin/edu/austral/dissis/chess/engine/MessageProviderKtTest.kt:1:1
```
The empty Kotlin file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\test\kotlin\edu\austral\dissis\chess\engine\MessageProviderKtTest.kt can be removed.
```
```kotlin
1 
! ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/test/kotlin/edu/austral/dissis/chess/engine/SetBoardTest.kt:1:1
```
The empty Kotlin file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\test\kotlin\edu\austral\dissis\chess\engine\SetBoardTest.kt can be removed.
```
```kotlin
1 
! ^ error

```

### exceptions, TooGenericExceptionThrown (1)

The thrown exception is too generic. Prefer throwing project specific exceptions to handle error cases.

[Documentation](https://detekt.dev/docs/rules/exceptions#toogenericexceptionthrown)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/board/Board.kt:51:9
```
Exception is a too generic Exception. Prefer throwing specific exceptions that indicate a specific error case.
```
```kotlin
48         if(pieces.contains(piece)){
49             return currentBoard.filterValues { it == piece }.keys.first()
50         }
51         throw Exception("Piece not found")
!!         ^ error
52     }
53 
54     fun getPieces(): List<Piece> {

```

### style, MagicNumber (90)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/UIGameEngine.kt:30:39
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
27     override fun init(): InitialState {
28         val pieces = PieceAdapter().getChessPieces(game.getBoard())
29         println(pieces)
30         return InitialState(BoardSize(8,8),pieces, ColorAdapter().translatePlayerColor(game.getCurrentPlayer().getColor()))
!!                                       ^ error
31     }
32 
33     override fun redo(): NewGameState {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/UIGameEngine.kt:30:41
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
27     override fun init(): InitialState {
28         val pieces = PieceAdapter().getChessPieces(game.getBoard())
29         println(pieces)
30         return InitialState(BoardSize(8,8),pieces, ColorAdapter().translatePlayerColor(game.getCurrentPlayer().getColor()))
!!                                         ^ error
31     }
32 
33     override fun redo(): NewGameState {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/GameClient.kt:22:53
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
19 
20     private val gameEventListener = MyGameEventListener(this)
21     private val client = builder
22         .withAddress(InetSocketAddress("localhost", 8080))
!!                                                     ^ error
23         .withConnectionListener(MyClientConnectionListener(this))
24         .addMessageListener("initialState", object : TypeReference<Message<ClientPayload>>(){}, InitialStateListener(this))
25         .addMessageListener("invalidMove", object : TypeReference<Message<InvalidMovePayload>>(){}, InvalidMoveListener(this))

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/server/GameServer.kt:20:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
17 
18 
19     private val server = builder
20         .withPort(8080)
!!                   ^ error
21         .withConnectionListener(MyServerConnectionListener(this))
22         .addMessageListener("move", object : TypeReference<Message<MovePayload>>(){}, MoveListener(this))
23         .addMessageListener("undo",object :TypeReference<Message<UndoPayload>>(){}, UndoListener(this))

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/CastlingAction.kt:18:78
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
15     override fun execute(board: Board, move: ClassicMove): Board {
16         val king = board.getPieceAt(move.from)!!
17         if(Castling().isShortCastling(move)){
18             val rookPosition = if(king.playersColor == Color.WHITE) Position(8,1) else Position(8,8)
!!                                                                              ^ error
19             val rook = board.getPieceAt(rookPosition)!!
20             val rookMove = ClassicMove(rookPosition, Position(6,rookPosition.y),rook)
21              return board.movePiece(move).movePiece(rookMove)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/CastlingAction.kt:18:97
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
15     override fun execute(board: Board, move: ClassicMove): Board {
16         val king = board.getPieceAt(move.from)!!
17         if(Castling().isShortCastling(move)){
18             val rookPosition = if(king.playersColor == Color.WHITE) Position(8,1) else Position(8,8)
!!                                                                                                 ^ error
19             val rook = board.getPieceAt(rookPosition)!!
20             val rookMove = ClassicMove(rookPosition, Position(6,rookPosition.y),rook)
21              return board.movePiece(move).movePiece(rookMove)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/CastlingAction.kt:18:99
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
15     override fun execute(board: Board, move: ClassicMove): Board {
16         val king = board.getPieceAt(move.from)!!
17         if(Castling().isShortCastling(move)){
18             val rookPosition = if(king.playersColor == Color.WHITE) Position(8,1) else Position(8,8)
!!                                                                                                   ^ error
19             val rook = board.getPieceAt(rookPosition)!!
20             val rookMove = ClassicMove(rookPosition, Position(6,rookPosition.y),rook)
21              return board.movePiece(move).movePiece(rookMove)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/CastlingAction.kt:20:63
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
17         if(Castling().isShortCastling(move)){
18             val rookPosition = if(king.playersColor == Color.WHITE) Position(8,1) else Position(8,8)
19             val rook = board.getPieceAt(rookPosition)!!
20             val rookMove = ClassicMove(rookPosition, Position(6,rookPosition.y),rook)
!!                                                               ^ error
21              return board.movePiece(move).movePiece(rookMove)
22         }
23         if(Castling().isLongCastling(move)){

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/CastlingAction.kt:24:99
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
21              return board.movePiece(move).movePiece(rookMove)
22         }
23         if(Castling().isLongCastling(move)){
24             val rookPosition = if(king.playersColor == Color.WHITE) Position(1,1) else Position(1,8)
!!                                                                                                   ^ error
25             val rook = board.getPieceAt(rookPosition)!!
26             val rookMove = ClassicMove(rookPosition, Position(4,rookPosition.y),rook)
27             return board.movePiece(move).movePiece(rookMove)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/CastlingAction.kt:26:63
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
23         if(Castling().isLongCastling(move)){
24             val rookPosition = if(king.playersColor == Color.WHITE) Position(1,1) else Position(1,8)
25             val rook = board.getPieceAt(rookPosition)!!
26             val rookMove = ClassicMove(rookPosition, Position(4,rookPosition.y),rook)
!!                                                               ^ error
27             return board.movePiece(move).movePiece(rookMove)
28         }
29         return board

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/types/endConditions/ClassicEndConditions.kt:28:26
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
25         val board = game.getBoard()
26         val pieces = board.getPieces().filter { it.playersColor == player.getColor() }
27         for (piece in pieces) {
28             for (i in 1..8) {
!!                          ^ error
29                 for (j in 1..8) {
30                     val move = ClassicMove(board.getPositionOf(piece), Position(i, j), piece)
31                     if(piece.isValidMove(board,move) && ClearPath().isFulfilled(game,move)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/types/endConditions/ClassicEndConditions.kt:29:30
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
26         val pieces = board.getPieces().filter { it.playersColor == player.getColor() }
27         for (piece in pieces) {
28             for (i in 1..8) {
29                 for (j in 1..8) {
!!                              ^ error
30                     val move = ClassicMove(board.getPositionOf(piece), Position(i, j), piece)
31                     if(piece.isValidMove(board,move) && ClearPath().isFulfilled(game,move)
32                          && FriendlyFire().isFulfilled(game,move)){

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:22:32
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
19     }
20 
21     fun isShortCastling( move: ClassicMove): Boolean {
22         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 7 && move.to.y == 1) ||
!!                                ^ error
23                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 7 && move.to.y == 8)
24     }
25     fun isLongCastling( move: ClassicMove): Boolean {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:22:70
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
19     }
20 
21     fun isShortCastling( move: ClassicMove): Boolean {
22         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 7 && move.to.y == 1) ||
!!                                                                      ^ error
23                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 7 && move.to.y == 8)
24     }
25     fun isLongCastling( move: ClassicMove): Boolean {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:23:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
20 
21     fun isShortCastling( move: ClassicMove): Boolean {
22         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 7 && move.to.y == 1) ||
23                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 7 && move.to.y == 8)
!!                                 ^ error
24     }
25     fun isLongCastling( move: ClassicMove): Boolean {
26         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 3 && move.to.y == 1) ||

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:23:53
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
20 
21     fun isShortCastling( move: ClassicMove): Boolean {
22         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 7 && move.to.y == 1) ||
23                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 7 && move.to.y == 8)
!!                                                     ^ error
24     }
25     fun isLongCastling( move: ClassicMove): Boolean {
26         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 3 && move.to.y == 1) ||

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:23:71
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
20 
21     fun isShortCastling( move: ClassicMove): Boolean {
22         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 7 && move.to.y == 1) ||
23                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 7 && move.to.y == 8)
!!                                                                       ^ error
24     }
25     fun isLongCastling( move: ClassicMove): Boolean {
26         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 3 && move.to.y == 1) ||

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:23:89
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
20 
21     fun isShortCastling( move: ClassicMove): Boolean {
22         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 7 && move.to.y == 1) ||
23                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 7 && move.to.y == 8)
!!                                                                                         ^ error
24     }
25     fun isLongCastling( move: ClassicMove): Boolean {
26         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 3 && move.to.y == 1) ||

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:26:32
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
23                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 7 && move.to.y == 8)
24     }
25     fun isLongCastling( move: ClassicMove): Boolean {
26         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 3 && move.to.y == 1) ||
!!                                ^ error
27                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 3 && move.to.y == 8)
28     }
29     private fun isShortCastlingPossible(board: Board, move: ClassicMove): Boolean {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:26:70
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
23                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 7 && move.to.y == 8)
24     }
25     fun isLongCastling( move: ClassicMove): Boolean {
26         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 3 && move.to.y == 1) ||
!!                                                                      ^ error
27                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 3 && move.to.y == 8)
28     }
29     private fun isShortCastlingPossible(board: Board, move: ClassicMove): Boolean {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:27:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
24     }
25     fun isLongCastling( move: ClassicMove): Boolean {
26         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 3 && move.to.y == 1) ||
27                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 3 && move.to.y == 8)
!!                                 ^ error
28     }
29     private fun isShortCastlingPossible(board: Board, move: ClassicMove): Boolean {
30         val king = board.getPieceAt(move.from)!!

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:27:53
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
24     }
25     fun isLongCastling( move: ClassicMove): Boolean {
26         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 3 && move.to.y == 1) ||
27                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 3 && move.to.y == 8)
!!                                                     ^ error
28     }
29     private fun isShortCastlingPossible(board: Board, move: ClassicMove): Boolean {
30         val king = board.getPieceAt(move.from)!!

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:27:71
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
24     }
25     fun isLongCastling( move: ClassicMove): Boolean {
26         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 3 && move.to.y == 1) ||
27                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 3 && move.to.y == 8)
!!                                                                       ^ error
28     }
29     private fun isShortCastlingPossible(board: Board, move: ClassicMove): Boolean {
30         val king = board.getPieceAt(move.from)!!

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:27:89
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
24     }
25     fun isLongCastling( move: ClassicMove): Boolean {
26         return (move.from.x == 5 && move.from.y == 1 && move.to.x == 3 && move.to.y == 1) ||
27                 (move.from.x == 5 && move.from.y == 8 && move.to.x == 3 && move.to.y == 8)
!!                                                                                         ^ error
28     }
29     private fun isShortCastlingPossible(board: Board, move: ClassicMove): Boolean {
30         val king = board.getPieceAt(move.from)!!

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:31:83
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
28     }
29     private fun isShortCastlingPossible(board: Board, move: ClassicMove): Boolean {
30         val king = board.getPieceAt(move.from)!!
31         val rook = if(king.playersColor == Color.WHITE) board.getPieceAt(Position(8,1)) else board.getPieceAt(Position(8,8))
!!                                                                                   ^ error
32         return !(hasMoved(board,king) || hasMoved(board,rook!!))
33     }
34     private fun isLongCastlingPossible(board: Board, move: ClassicMove): Boolean {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:31:120
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
28     }
29     private fun isShortCastlingPossible(board: Board, move: ClassicMove): Boolean {
30         val king = board.getPieceAt(move.from)!!
31         val rook = if(king.playersColor == Color.WHITE) board.getPieceAt(Position(8,1)) else board.getPieceAt(Position(8,8))
!!                                                                                                                        ^ error
32         return !(hasMoved(board,king) || hasMoved(board,rook!!))
33     }
34     private fun isLongCastlingPossible(board: Board, move: ClassicMove): Boolean {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:31:122
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
28     }
29     private fun isShortCastlingPossible(board: Board, move: ClassicMove): Boolean {
30         val king = board.getPieceAt(move.from)!!
31         val rook = if(king.playersColor == Color.WHITE) board.getPieceAt(Position(8,1)) else board.getPieceAt(Position(8,8))
!!                                                                                                                          ^ error
32         return !(hasMoved(board,king) || hasMoved(board,rook!!))
33     }
34     private fun isLongCastlingPossible(board: Board, move: ClassicMove): Boolean {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:36:122
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
33     }
34     private fun isLongCastlingPossible(board: Board, move: ClassicMove): Boolean {
35         val king = board.getPieceAt(move.from)!!
36         val rook = if(king.playersColor == Color.WHITE) board.getPieceAt(Position(1,1)) else board.getPieceAt(Position(1,8))
!!                                                                                                                          ^ error
37         return !(hasMoved(board,king) || hasMoved(board,rook!!))
38     }
39     private fun hasMoved(board: Board, piece: Piece): Boolean {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/DoublePawnMove.kt:12:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
9      override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
10         val piece = board.getPieceAt(move.from)
11         return if(piece!!.playersColor == Color.WHITE) {
12             move.from.y == 2 && move.to.y == 4
!!                                              ^ error
13         } else {
14             move.from.y == 7 && move.to.y == 5
15         }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/DoublePawnMove.kt:14:28
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
11         return if(piece!!.playersColor == Color.WHITE) {
12             move.from.y == 2 && move.to.y == 4
13         } else {
14             move.from.y == 7 && move.to.y == 5
!!                            ^ error
15         }
16     }
17 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/DoublePawnMove.kt:14:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
11         return if(piece!!.playersColor == Color.WHITE) {
12             move.from.y == 2 && move.to.y == 4
13         } else {
14             move.from.y == 7 && move.to.y == 5
!!                                              ^ error
15         }
16     }
17 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:17:23
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
14 class ClassicChessBoardSetUp {
15     var map = emptyMap<Position, Piece>()
16     var pieces = emptySet<Piece>()
17     var board = Board(8, 8, map, pieces, emptyList())
!!                       ^ error
18 
19     fun setUp(): Board {
20         for (i in 1 until 9) {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:17:26
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
14 class ClassicChessBoardSetUp {
15     var map = emptyMap<Position, Piece>()
16     var pieces = emptySet<Piece>()
17     var board = Board(8, 8, map, pieces, emptyList())
!!                          ^ error
18 
19     fun setUp(): Board {
20         for (i in 1 until 9) {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:20:27
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
17     var board = Board(8, 8, map, pieces, emptyList())
18 
19     fun setUp(): Board {
20         for (i in 1 until 9) {
!!                           ^ error
21             val bPawn = Piece("$i 7", Color.BLACK, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())),
22                 PieceType.PAWN )
23             board = board.putPieceAt(Position(i, 7), bPawn).getHisBoard()

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:23:50
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
20         for (i in 1 until 9) {
21             val bPawn = Piece("$i 7", Color.BLACK, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())),
22                 PieceType.PAWN )
23             board = board.putPieceAt(Position(i, 7), bPawn).getHisBoard()
!!                                                  ^ error
24             val wPawn = Piece("$i 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1,DoublePawnMove())),
25                 PieceType.PAWN )
26             board = board.putPieceAt(Position(i, 2), wPawn).getHisBoard()

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:31:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
28         val wRook1 = Piece("1 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
29         board = board.putPieceAt(Position(1, 1), wRook1).getHisBoard()
30         val wRook2 = Piece("8 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
31         board = board.putPieceAt(Position(8, 1), wRook2).getHisBoard()
!!                                           ^ error
32         val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
33         board = board.putPieceAt(Position(1, 8), bRook1).getHisBoard()
34         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:33:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
30         val wRook2 = Piece("8 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
31         board = board.putPieceAt(Position(8, 1), wRook2).getHisBoard()
32         val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
33         board = board.putPieceAt(Position(1, 8), bRook1).getHisBoard()
!!                                              ^ error
34         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
35         board = board.putPieceAt(Position(8, 8), bRook2).getHisBoard()
36         val wBishop1 = Piece("3 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:35:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
32         val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
33         board = board.putPieceAt(Position(1, 8), bRook1).getHisBoard()
34         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
35         board = board.putPieceAt(Position(8, 8), bRook2).getHisBoard()
!!                                           ^ error
36         val wBishop1 = Piece("3 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)
37         board = board.putPieceAt(Position(3, 1), wBishop1).getHisBoard()
38         val wBishop2 = Piece("6 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:35:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
32         val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
33         board = board.putPieceAt(Position(1, 8), bRook1).getHisBoard()
34         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
35         board = board.putPieceAt(Position(8, 8), bRook2).getHisBoard()
!!                                              ^ error
36         val wBishop1 = Piece("3 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)
37         board = board.putPieceAt(Position(3, 1), wBishop1).getHisBoard()
38         val wBishop2 = Piece("6 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:37:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
34         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK)
35         board = board.putPieceAt(Position(8, 8), bRook2).getHisBoard()
36         val wBishop1 = Piece("3 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)
37         board = board.putPieceAt(Position(3, 1), wBishop1).getHisBoard()
!!                                           ^ error
38         val wBishop2 = Piece("6 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)
39         board = board.putPieceAt(Position(6, 1), wBishop2).getHisBoard()
40         val bBishop1 = Piece("3 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:39:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
36         val wBishop1 = Piece("3 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)
37         board = board.putPieceAt(Position(3, 1), wBishop1).getHisBoard()
38         val wBishop2 = Piece("6 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)
39         board = board.putPieceAt(Position(6, 1), wBishop2).getHisBoard()
!!                                           ^ error
40         val bBishop1 = Piece("3 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
41         board = board.putPieceAt(Position(3, 8), bBishop1).getHisBoard()
42         val bBishop2 = Piece("6 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:41:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
38         val wBishop2 = Piece("6 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)
39         board = board.putPieceAt(Position(6, 1), wBishop2).getHisBoard()
40         val bBishop1 = Piece("3 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
41         board = board.putPieceAt(Position(3, 8), bBishop1).getHisBoard()
!!                                           ^ error
42         val bBishop2 = Piece("6 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
43         board = board.putPieceAt(Position(6, 8), bBishop2).getHisBoard()
44         val wKnight1 = Piece("2 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:41:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
38         val wBishop2 = Piece("6 1", Color.WHITE, listOf(MoveDiagonally()), PieceType.BISHOP)
39         board = board.putPieceAt(Position(6, 1), wBishop2).getHisBoard()
40         val bBishop1 = Piece("3 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
41         board = board.putPieceAt(Position(3, 8), bBishop1).getHisBoard()
!!                                              ^ error
42         val bBishop2 = Piece("6 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
43         board = board.putPieceAt(Position(6, 8), bBishop2).getHisBoard()
44         val wKnight1 = Piece("2 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:43:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
40         val bBishop1 = Piece("3 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
41         board = board.putPieceAt(Position(3, 8), bBishop1).getHisBoard()
42         val bBishop2 = Piece("6 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
43         board = board.putPieceAt(Position(6, 8), bBishop2).getHisBoard()
!!                                           ^ error
44         val wKnight1 = Piece("2 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)
45         board = board.putPieceAt(Position(2, 1), wKnight1).getHisBoard()
46         val wKnight2 = Piece("7 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:43:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
40         val bBishop1 = Piece("3 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
41         board = board.putPieceAt(Position(3, 8), bBishop1).getHisBoard()
42         val bBishop2 = Piece("6 8", Color.BLACK, listOf(MoveDiagonally()), PieceType.BISHOP)
43         board = board.putPieceAt(Position(6, 8), bBishop2).getHisBoard()
!!                                              ^ error
44         val wKnight1 = Piece("2 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)
45         board = board.putPieceAt(Position(2, 1), wKnight1).getHisBoard()
46         val wKnight2 = Piece("7 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:47:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
44         val wKnight1 = Piece("2 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)
45         board = board.putPieceAt(Position(2, 1), wKnight1).getHisBoard()
46         val wKnight2 = Piece("7 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)
47         board = board.putPieceAt(Position(7, 1), wKnight2).getHisBoard()
!!                                           ^ error
48         val bKnight1 = Piece("2 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)
49         board = board.putPieceAt(Position(2, 8), bKnight1).getHisBoard()
50         val bKnight2 = Piece("7 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:49:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
46         val wKnight2 = Piece("7 1", Color.WHITE, listOf(MoveLShape()), PieceType.KNIGHT)
47         board = board.putPieceAt(Position(7, 1), wKnight2).getHisBoard()
48         val bKnight1 = Piece("2 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)
49         board = board.putPieceAt(Position(2, 8), bKnight1).getHisBoard()
!!                                              ^ error
50         val bKnight2 = Piece("7 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)
51         board = board.putPieceAt(Position(7, 8), bKnight2).getHisBoard()
52         val wQueen = Piece("4 1", Color.WHITE, listOf(QueenMoves()), PieceType.QUEEN)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:51:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
48         val bKnight1 = Piece("2 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)
49         board = board.putPieceAt(Position(2, 8), bKnight1).getHisBoard()
50         val bKnight2 = Piece("7 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)
51         board = board.putPieceAt(Position(7, 8), bKnight2).getHisBoard()
!!                                           ^ error
52         val wQueen = Piece("4 1", Color.WHITE, listOf(QueenMoves()), PieceType.QUEEN)
53         board = board.putPieceAt(Position(4, 1), wQueen).getHisBoard()
54         val bQueen = Piece("4 8", Color.BLACK, listOf(QueenMoves()), PieceType.QUEEN)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:51:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
48         val bKnight1 = Piece("2 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)
49         board = board.putPieceAt(Position(2, 8), bKnight1).getHisBoard()
50         val bKnight2 = Piece("7 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)
51         board = board.putPieceAt(Position(7, 8), bKnight2).getHisBoard()
!!                                              ^ error
52         val wQueen = Piece("4 1", Color.WHITE, listOf(QueenMoves()), PieceType.QUEEN)
53         board = board.putPieceAt(Position(4, 1), wQueen).getHisBoard()
54         val bQueen = Piece("4 8", Color.BLACK, listOf(QueenMoves()), PieceType.QUEEN)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:53:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
50         val bKnight2 = Piece("7 8", Color.BLACK, listOf(MoveLShape()), PieceType.KNIGHT)
51         board = board.putPieceAt(Position(7, 8), bKnight2).getHisBoard()
52         val wQueen = Piece("4 1", Color.WHITE, listOf(QueenMoves()), PieceType.QUEEN)
53         board = board.putPieceAt(Position(4, 1), wQueen).getHisBoard()
!!                                           ^ error
54         val bQueen = Piece("4 8", Color.BLACK, listOf(QueenMoves()), PieceType.QUEEN)
55         board = board.putPieceAt(Position(4, 8), bQueen).getHisBoard()
56         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:55:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
52         val wQueen = Piece("4 1", Color.WHITE, listOf(QueenMoves()), PieceType.QUEEN)
53         board = board.putPieceAt(Position(4, 1), wQueen).getHisBoard()
54         val bQueen = Piece("4 8", Color.BLACK, listOf(QueenMoves()), PieceType.QUEEN)
55         board = board.putPieceAt(Position(4, 8), bQueen).getHisBoard()
!!                                           ^ error
56         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)
57         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
58         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:55:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
52         val wQueen = Piece("4 1", Color.WHITE, listOf(QueenMoves()), PieceType.QUEEN)
53         board = board.putPieceAt(Position(4, 1), wQueen).getHisBoard()
54         val bQueen = Piece("4 8", Color.BLACK, listOf(QueenMoves()), PieceType.QUEEN)
55         board = board.putPieceAt(Position(4, 8), bQueen).getHisBoard()
!!                                              ^ error
56         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)
57         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
58         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:57:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
54         val bQueen = Piece("4 8", Color.BLACK, listOf(QueenMoves()), PieceType.QUEEN)
55         board = board.putPieceAt(Position(4, 8), bQueen).getHisBoard()
56         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)
57         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
!!                                           ^ error
58         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)
59         board = board.putPieceAt(Position(5, 8), bKing).getHisBoard()
60 

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:59:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
56         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)
57         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
58         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)
59         board = board.putPieceAt(Position(5, 8), bKing).getHisBoard()
!!                                           ^ error
60 
61 
62         return board

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:59:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
56         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)
57         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
58         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING)
59         board = board.putPieceAt(Position(5, 8), bKing).getHisBoard()
!!                                              ^ error
60 
61 
62         return board

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CastlingSetUp.kt:16:23
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
13 class CastlingSetUp {
14     var map = emptyMap<Position, Piece>()
15     var pieces = emptySet<Piece>()
16     var board = Board(8, 8, map, pieces, emptyList())
!!                       ^ error
17 
18     fun setUp(): Board {
19         val wRook1 = Piece("1 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CastlingSetUp.kt:16:26
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
13 class CastlingSetUp {
14     var map = emptyMap<Position, Piece>()
15     var pieces = emptySet<Piece>()
16     var board = Board(8, 8, map, pieces, emptyList())
!!                          ^ error
17 
18     fun setUp(): Board {
19         val wRook1 = Piece("1 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CastlingSetUp.kt:22:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
19         val wRook1 = Piece("1 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
20         board = board.putPieceAt(Position(1, 1), wRook1).getHisBoard()
21         val wRook2 = Piece("8 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
22         board = board.putPieceAt(Position(8, 1), wRook2).getHisBoard()
!!                                           ^ error
23         val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
24         board = board.putPieceAt(Position(1, 8), bRook1).getHisBoard()
25         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CastlingSetUp.kt:24:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
21         val wRook2 = Piece("8 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
22         board = board.putPieceAt(Position(8, 1), wRook2).getHisBoard()
23         val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
24         board = board.putPieceAt(Position(1, 8), bRook1).getHisBoard()
!!                                              ^ error
25         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
26         board = board.putPieceAt(Position(8, 8), bRook2).getHisBoard()
27         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CastlingSetUp.kt:26:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
23         val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
24         board = board.putPieceAt(Position(1, 8), bRook1).getHisBoard()
25         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
26         board = board.putPieceAt(Position(8, 8), bRook2).getHisBoard()
!!                                           ^ error
27         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
28         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
29         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1,Castling())), PieceType.KING )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CastlingSetUp.kt:26:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
23         val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
24         board = board.putPieceAt(Position(1, 8), bRook1).getHisBoard()
25         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
26         board = board.putPieceAt(Position(8, 8), bRook2).getHisBoard()
!!                                              ^ error
27         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
28         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
29         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1,Castling())), PieceType.KING )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CastlingSetUp.kt:28:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
25         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
26         board = board.putPieceAt(Position(8, 8), bRook2).getHisBoard()
27         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
28         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
!!                                           ^ error
29         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1,Castling())), PieceType.KING )
30         board = board.putPieceAt(Position(5, 8), bKing).getHisBoard()
31         return board

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CastlingSetUp.kt:30:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
27         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
28         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
29         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1,Castling())), PieceType.KING )
30         board = board.putPieceAt(Position(5, 8), bKing).getHisBoard()
!!                                           ^ error
31         return board
32     }
33 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CastlingSetUp.kt:30:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
27         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
28         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
29         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1,Castling())), PieceType.KING )
30         board = board.putPieceAt(Position(5, 8), bKing).getHisBoard()
!!                                              ^ error
31         return board
32     }
33 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CheckMateSetUp.kt:16:23
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
13 class CheckMateSetUp {
14     var map = emptyMap<Position, Piece>()
15     var pieces = emptySet<Piece>()
16     var board = Board(8, 8, map, pieces, emptyList())
!!                       ^ error
17 
18     fun setUp(): Board {
19         val wRook1 = Piece("1 7", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CheckMateSetUp.kt:16:26
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
13 class CheckMateSetUp {
14     var map = emptyMap<Position, Piece>()
15     var pieces = emptySet<Piece>()
16     var board = Board(8, 8, map, pieces, emptyList())
!!                          ^ error
17 
18     fun setUp(): Board {
19         val wRook1 = Piece("1 7", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CheckMateSetUp.kt:20:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
17 
18     fun setUp(): Board {
19         val wRook1 = Piece("1 7", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
20         board = board.putPieceAt(Position(1, 7), wRook1).getHisBoard()
!!                                              ^ error
21         val wRook2 = Piece("8 7", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
22         board = board.putPieceAt(Position(8, 7), wRook2).getHisBoard()
23         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CheckMateSetUp.kt:22:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
19         val wRook1 = Piece("1 7", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
20         board = board.putPieceAt(Position(1, 7), wRook1).getHisBoard()
21         val wRook2 = Piece("8 7", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
22         board = board.putPieceAt(Position(8, 7), wRook2).getHisBoard()
!!                                           ^ error
23         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
24         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
25         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CheckMateSetUp.kt:22:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
19         val wRook1 = Piece("1 7", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
20         board = board.putPieceAt(Position(1, 7), wRook1).getHisBoard()
21         val wRook2 = Piece("8 7", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
22         board = board.putPieceAt(Position(8, 7), wRook2).getHisBoard()
!!                                              ^ error
23         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
24         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
25         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CheckMateSetUp.kt:24:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
21         val wRook2 = Piece("8 7", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
22         board = board.putPieceAt(Position(8, 7), wRook2).getHisBoard()
23         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
24         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
!!                                           ^ error
25         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
26         board = board.putPieceAt(Position(5, 8), bKing).getHisBoard()
27         return board

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CheckMateSetUp.kt:26:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
23         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
24         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
25         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
26         board = board.putPieceAt(Position(5, 8), bKing).getHisBoard()
!!                                           ^ error
27         return board
28     }
29 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CheckMateSetUp.kt:26:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
23         val wKing = Piece("5 1", Color.WHITE, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
24         board = board.putPieceAt(Position(5, 1), wKing).getHisBoard()
25         val bKing = Piece("5 8", Color.BLACK, listOf(KingMoves(), MoveLimitation(1,1, Castling())), PieceType.KING )
26         board = board.putPieceAt(Position(5, 8), bKing).getHisBoard()
!!                                              ^ error
27         return board
28     }
29 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/ChessPromotionSetUp.kt:15:23
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
12 class ChessPromotionSetUp {
13     var map = emptyMap<Position, Piece>()
14     var pieces = emptySet<Piece>()
15     var board = Board(8, 8, map, pieces, emptyList())
!!                       ^ error
16 
17     fun setUp(): Board {
18         val wPiece = Piece("1 7", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/ChessPromotionSetUp.kt:15:26
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
12 class ChessPromotionSetUp {
13     var map = emptyMap<Position, Piece>()
14     var pieces = emptySet<Piece>()
15     var board = Board(8, 8, map, pieces, emptyList())
!!                          ^ error
16 
17     fun setUp(): Board {
18         val wPiece = Piece("1 7", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/ChessPromotionSetUp.kt:19:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
16 
17     fun setUp(): Board {
18         val wPiece = Piece("1 7", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
19         board = board.putPieceAt(Position(1, 7), wPiece).getHisBoard()
!!                                              ^ error
20         return board
21     }
22 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/PathNotClearSetUp.kt:15:23
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
12 class PathNotClearSetUp {
13     private var map = emptyMap<Position, Piece>()
14     var pieces = emptySet<Piece>()
15     var board = Board(8, 8, map, pieces, emptyList())
!!                       ^ error
16 
17     fun setUp(): Board {
18         val wPiece = Piece("1 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/PathNotClearSetUp.kt:15:26
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
12 class PathNotClearSetUp {
13     private var map = emptyMap<Position, Piece>()
14     var pieces = emptySet<Piece>()
15     var board = Board(8, 8, map, pieces, emptyList())
!!                          ^ error
16 
17     fun setUp(): Board {
18         val wPiece = Piece("1 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/PathNotClearSetUp.kt:21:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
18         val wPiece = Piece("1 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
19         board = board.putPieceAt(Position(1, 2), wPiece).getHisBoard()
20         val bPiece = Piece("1 3", Color.BLACK, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
21         board = board.putPieceAt(Position(1, 3), bPiece).getHisBoard()
!!                                              ^ error
22         return board
23     }
24 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/PawnCaptureSetUp.kt:15:23
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
12 class PawnCaptureSetUp {
13     var map = emptyMap<Position, Piece>()
14     var pieces = emptySet<Piece>()
15     var board = Board(8, 8, map, pieces, emptyList())
!!                       ^ error
16 
17     fun setUp(): Board {
18         val wPiece = Piece("1 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/PawnCaptureSetUp.kt:15:26
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
12 class PawnCaptureSetUp {
13     var map = emptyMap<Position, Piece>()
14     var pieces = emptySet<Piece>()
15     var board = Board(8, 8, map, pieces, emptyList())
!!                          ^ error
16 
17     fun setUp(): Board {
18         val wPiece = Piece("1 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/PawnCaptureSetUp.kt:21:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
18         val wPiece = Piece("1 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
19         board = board.putPieceAt(Position(1, 2), wPiece).getHisBoard()
20         val bPiece = Piece("2 3", Color.BLACK, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
21         board = board.putPieceAt(Position(2, 3), bPiece).getHisBoard()
!!                                              ^ error
22         return board
23     }
24 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/rook/RookMovesSetUp.kt:13:23
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
10 class RookMovesSetUp {
11     private var map = emptyMap<Position, Piece>()
12     var pieces = emptySet<Piece>()
13     var board = Board(8, 8, map, pieces, emptyList())
!!                       ^ error
14 
15     fun setUp(): Board {
16         val wRook1 = Piece("1 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/rook/RookMovesSetUp.kt:13:26
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
10 class RookMovesSetUp {
11     private var map = emptyMap<Position, Piece>()
12     var pieces = emptySet<Piece>()
13     var board = Board(8, 8, map, pieces, emptyList())
!!                          ^ error
14 
15     fun setUp(): Board {
16         val wRook1 = Piece("1 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/rook/RookMovesSetUp.kt:19:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
16         val wRook1 = Piece("1 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
17         board = board.putPieceAt(Position(1, 1), wRook1).getHisBoard()
18         val wRook2 = Piece("8 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
19         board = board.putPieceAt(Position(8, 1), wRook2).getHisBoard()
!!                                           ^ error
20         val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
21         board = board.putPieceAt(Position(1, 8), bRook1).getHisBoard()
22         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/rook/RookMovesSetUp.kt:21:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
18         val wRook2 = Piece("8 1", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
19         board = board.putPieceAt(Position(8, 1), wRook2).getHisBoard()
20         val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
21         board = board.putPieceAt(Position(1, 8), bRook1).getHisBoard()
!!                                              ^ error
22         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
23         board = board.putPieceAt(Position(8, 8), bRook2).getHisBoard()
24         return board

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/rook/RookMovesSetUp.kt:23:43
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
20         val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
21         board = board.putPieceAt(Position(1, 8), bRook1).getHisBoard()
22         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
23         board = board.putPieceAt(Position(8, 8), bRook2).getHisBoard()
!!                                           ^ error
24         return board
25     }
26 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/rook/RookMovesSetUp.kt:23:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
20         val bRook1 = Piece("1 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
21         board = board.putPieceAt(Position(1, 8), bRook1).getHisBoard()
22         val bRook2 = Piece("8 8", Color.BLACK, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
23         board = board.putPieceAt(Position(8, 8), bRook2).getHisBoard()
!!                                              ^ error
24         return board
25     }
26 }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/rook/RookPathNotClearSetUp.kt:16:23
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
13 class RookPathNotClearSetUp {
14     var map = emptyMap<Position, Piece>()
15     var pieces = emptySet<Piece>()
16     var board = Board(8, 8, map, pieces, emptyList())
!!                       ^ error
17 
18     fun setUp(): Board {
19         val wRook = Piece("1 2", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/rook/RookPathNotClearSetUp.kt:16:26
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
13 class RookPathNotClearSetUp {
14     var map = emptyMap<Position, Piece>()
15     var pieces = emptySet<Piece>()
16     var board = Board(8, 8, map, pieces, emptyList())
!!                          ^ error
17 
18     fun setUp(): Board {
19         val wRook = Piece("1 2", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/rook/RookPathNotClearSetUp.kt:22:46
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
19         val wRook = Piece("1 2", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
20         board = board.putPieceAt(Position(1, 2), wRook).getHisBoard()
21         val bPiece = Piece("1 3", Color.BLACK, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
22         board = board.putPieceAt(Position(1, 3), bPiece).getHisBoard()
!!                                              ^ error
23         return board
24     }
25 }

```

### style, MaxLineLength (19)

Line detected, which is longer than the defined maximum line length in the code style.

[Documentation](https://detekt.dev/docs/rules/style#maxlinelength)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/GameEngine.kt:16:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
13 
14 import java.util.*
15 
16 class GameEngine(private val board: Board, private val turnManager: TurnManager, private val gameType: GameType, private val undoStack: Stack<GameEngine>, private val redoStack: Stack<GameEngine>) {
!! ^ error
17 
18     fun move(move: ClassicMove): GameResult {
19         if (!canMove(move)) {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/GameEngine.kt:29:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
26             return applyAction(action, move)
27         }
28         val newBoard = board.movePiece(move)
29         if(!gameType.isEndConditionMet(GameEngine(newBoard, turnManager, gameType, undoStack, redoStack), turnManager.nextTurn(this).whoseTurnIsIt())) {
!! ^ error
30             val newTM = turnManager.nextTurn(this)
31             val newGame = GameEngine(newBoard, newTM, gameType, undoStack, redoStack)
32             return SuccessfulMoveResult(newGame, newGame.getCurrentPlayer(), gameType.getGameMessage())

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/GameEngine.kt:34:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
31             val newGame = GameEngine(newBoard, newTM, gameType, undoStack, redoStack)
32             return SuccessfulMoveResult(newGame, newGame.getCurrentPlayer(), gameType.getGameMessage())
33         }
34         return EndGameResult(GameEngine(newBoard,turnManager,gameType,undoStack,redoStack), turnManager.whoseTurnIsIt(), gameType.getGameMessage())
!! ^ error
35     }
36 
37     private fun applyAction(action: Action, move: ClassicMove): GameResult {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/GameEngine.kt:39:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
36 
37     private fun applyAction(action: Action, move: ClassicMove): GameResult {
38         val newBoard = action.execute(board, move)
39         if(!gameType.isEndConditionMet(GameEngine(newBoard, turnManager, gameType, undoStack, redoStack), turnManager.nextTurn(this).whoseTurnIsIt())) {
!! ^ error
40             val newGame = GameEngine(newBoard, turnManager.nextTurn(this), gameType, undoStack, redoStack)
41             return SuccessfulMoveResult(newGame, newGame.getCurrentPlayer(), gameType.getGameMessage())
42         }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/GameEngine.kt:43:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
40             val newGame = GameEngine(newBoard, turnManager.nextTurn(this), gameType, undoStack, redoStack)
41             return SuccessfulMoveResult(newGame, newGame.getCurrentPlayer(), gameType.getGameMessage())
42         }
43         return EndGameResult(GameEngine(newBoard,turnManager,gameType,undoStack,redoStack), turnManager.whoseTurnIsIt(), gameType.getGameMessage())
!! ^ error
44     }
45 
46     private fun itsActionMove(move: ClassicMove): Boolean {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/Main.kt:29:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
26         Color.BLACK)
27     ))
28     private val newChessTM = ClassicChessTurnManager(newChessGameType.getPlayers()[0])
29     private val newChessGame = GameEngine(edu.austral.dissis.chess.engine.setUps.ClassicChessBoardSetUp().setUp(), newChessTM, newChessGameType, Stack(), Stack())
!! ^ error
30 
31 
32     private val gameEngine = UIGameEngine (newChessGame)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/UIGameEngine.kt:36:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
33     override fun redo(): NewGameState {
34         game = game.redo()
35         return NewGameState(
36             PieceAdapter().getChessPieces(game.getBoard()), ColorAdapter().translatePlayerColor(game.getCurrentPlayer().getColor()),
!! ^ error
37             UndoState(canUndo(),canRedo())
38         )
39     }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/UIGameEngine.kt:44:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
41     override fun undo(): NewGameState {
42         game = game.undo()
43         return NewGameState(
44             PieceAdapter().getChessPieces(game.getBoard()), ColorAdapter().translatePlayerColor(game.getCurrentPlayer().getColor()),
!! ^ error
45             UndoState(canUndo(),canRedo()))
46     }
47 

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/GameClient.kt:26:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
23         .withConnectionListener(MyClientConnectionListener(this))
24         .addMessageListener("initialState", object : TypeReference<Message<ClientPayload>>(){}, InitialStateListener(this))
25         .addMessageListener("invalidMove", object : TypeReference<Message<InvalidMovePayload>>(){}, InvalidMoveListener(this))
26         .addMessageListener("successfulMove", object : TypeReference<Message<SuccessfulMovePayload>>(){}, SuccessfulMoveListener(this))
!! ^ error
27         .addMessageListener("gameOver", object : TypeReference<Message<GameOverPayload>>(){}, GameOverListener(this))
28         .build()
29 

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/ChessPromotion.kt:28:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
25 
26     override fun execute(board: Board, move: ClassicMove): Board {
27         val piece = board.getPieceAt(move.from)
28         val newPiece = Piece(piece!!.id, piece.playersColor, listOf(MoveDiagonally(), MoveVertically(),MoveHorizontally()), PieceType.QUEEN)
!! ^ error
29         val newBoard = board.removePieceAt(move.from).putPieceAt(move.to, newPiece).getHisBoard()
30         return Board(board.maxRow, board.maxCol, newBoard.currentBoard, newBoard.pieces, board.moves.plus(move))
31     }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/PawnMovesComposite.kt:14:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
11     private val vertical = MoveVertically()
12     private val diagonal = MoveDiagonally()
13     override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
14         if(( vertical.isFulfilled(board,move) && !IsEnemyPieceThere().verify(board,move)) || (diagonal.isFulfilled(board,move) && IsEnemyPieceThere().verify(board, move))) {
!! ^ error
15             return forward.isFulfilled(board,move)
16         }
17         return false

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/ChessPromotionSetUp.kt:18:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
15     var board = Board(8, 8, map, pieces, emptyList())
16 
17     fun setUp(): Board {
18         val wPiece = Piece("1 7", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
!! ^ error
19         board = board.putPieceAt(Position(1, 7), wPiece).getHisBoard()
20         return board
21     }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/PathNotClearSetUp.kt:18:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
15     var board = Board(8, 8, map, pieces, emptyList())
16 
17     fun setUp(): Board {
18         val wPiece = Piece("1 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
!! ^ error
19         board = board.putPieceAt(Position(1, 2), wPiece).getHisBoard()
20         val bPiece = Piece("1 3", Color.BLACK, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
21         board = board.putPieceAt(Position(1, 3), bPiece).getHisBoard()

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/PathNotClearSetUp.kt:20:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
17     fun setUp(): Board {
18         val wPiece = Piece("1 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
19         board = board.putPieceAt(Position(1, 2), wPiece).getHisBoard()
20         val bPiece = Piece("1 3", Color.BLACK, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
!! ^ error
21         board = board.putPieceAt(Position(1, 3), bPiece).getHisBoard()
22         return board
23     }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/PawnCaptureSetUp.kt:18:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
15     var board = Board(8, 8, map, pieces, emptyList())
16 
17     fun setUp(): Board {
18         val wPiece = Piece("1 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
!! ^ error
19         board = board.putPieceAt(Position(1, 2), wPiece).getHisBoard()
20         val bPiece = Piece("2 3", Color.BLACK, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
21         board = board.putPieceAt(Position(2, 3), bPiece).getHisBoard()

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/PawnCaptureSetUp.kt:20:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
17     fun setUp(): Board {
18         val wPiece = Piece("1 2", Color.WHITE, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
19         board = board.putPieceAt(Position(1, 2), wPiece).getHisBoard()
20         val bPiece = Piece("2 3", Color.BLACK, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
!! ^ error
21         board = board.putPieceAt(Position(2, 3), bPiece).getHisBoard()
22         return board
23     }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/rook/RookPathNotClearSetUp.kt:21:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
18     fun setUp(): Board {
19         val wRook = Piece("1 2", Color.WHITE, listOf(MoveVerticalORHorizontal()), PieceType.ROOK )
20         board = board.putPieceAt(Position(1, 2), wRook).getHisBoard()
21         val bPiece = Piece("1 3", Color.BLACK, listOf(PawnMovesComposite(), MoveLimitation(1,1, DoublePawnMove())), PieceType.PAWN )
!! ^ error
22         board = board.putPieceAt(Position(1, 3), bPiece).getHisBoard()
23         return board
24     }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/test/kotlin/edu/austral/dissis/chess/engine/exam/MyEngineTestGameRunner.kt:60:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
57         val testSize = TestSize(board.maxCol,board.maxRow)
58         for ((pos,piece) in board.currentBoard){
59             val testPos = TestPosition(pos.y,pos.x)
60             pieces[testPos] = TestPiece(TestAdapter().adaptToTestPieceType(piece), TestAdapter().adaptToTestPlayerColor(piece.playersColor))
!! ^ error
61         }
62         return TestBoard(testSize,pieces)
63 

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/test/kotlin/edu/austral/dissis/chess/engine/exam/MyEngineTestGameRunner.kt:76:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
73             myBoard[Position(pos.col,pos.row)] = myPiece
74             mySet += myPiece
75         }
76         game = GameEngine(Board(board.size.rows,board.size.cols,myBoard,mySet,emptyList()),turnManager, gameType, Stack(), Stack())
!! ^ error
77         return this
78     }
79     override fun undo(): TestMoveResult {

```

### style, NewLineAtEndOfFile (86)

Checks whether files end with a line separator.

[Documentation](https://detekt.dev/docs/rules/style#newlineatendoffile)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/board/Board.kt:62:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\board\Board.kt is not ending with a new line.
```
```kotlin
59         return currentBoard.filterValues { it.pieceType == PieceType.KING && it.playersColor == color }.keys.first()
60     }
61 
62 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/board/boardResults/InvalidBoardResult.kt:10:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\board\boardResults\InvalidBoardResult.kt is not ending with a new line.
```
```kotlin
7      override fun getHisBoard(): Board {
8          return board
9      }
10 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/board/boardResults/SuccessfulBoardResult.kt:10:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\board\boardResults\SuccessfulBoardResult.kt is not ending with a new line.
```
```kotlin
7          return board
8      }
9  
10 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/elements/color/Color.kt:5:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\elements\color\Color.kt is not ending with a new line.
```
```kotlin
2 
3 enum class Color {
4     WHITE, BLACK
5 }
!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/elements/moveTypes/ClassicMove.kt:10:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\elements\moveTypes\ClassicMove.kt is not ending with a new line.
```
```kotlin
7  
8  data class ClassicMove(val from: Position, val to: Position, val piece: Piece) {
9  
10 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/elements/position/Position.kt:4:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\elements\position\Position.kt is not ending with a new line.
```
```kotlin
1 package common.elements.position
2 
3 data class Position( val x: Int, val y: Int) {
4 }
!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/GameEngine.kt:111:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\GameEngine.kt is not ending with a new line.
```
```kotlin
108     }
109 
110 
111 }
!!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/actions/Action.kt:9:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\actions\Action.kt is not ending with a new line.
```
```kotlin
6  interface Action {
7      fun isFulfilled(board: Board, move: ClassicMove): Boolean
8      fun execute(board: Board, move: ClassicMove): Board
9  }
!   ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/factory/GameFactory.kt:23:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\factory\GameFactory.kt is not ending with a new line.
```
```kotlin
20         ))
21         return GameEngine(board, ClassicChessTurnManager(Player(Color.WHITE)),gameType, Stack(), Stack())
22     }
23 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/factory/sharedRules/FriendlyFire.kt:16:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\factory\sharedRules\FriendlyFire.kt is not ending with a new line.
```
```kotlin
13         }
14         return true
15     }
16 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/factory/sharedRules/IsTargetWithinBounds.kt:13:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\factory\sharedRules\IsTargetWithinBounds.kt is not ending with a new line.
```
```kotlin
10         val target = move.to
11         return (target.x > 0 && target.x <= board.maxRow) && (target.y >0 && target.y <= board.maxCol)
12     }
13 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/factory/sharedRules/ItsPlayersTurn.kt:11:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\factory\sharedRules\ItsPlayersTurn.kt is not ending with a new line.
```
```kotlin
8      override fun isFulfilled(game: GameEngine, move: ClassicMove): Boolean {
9          return game.getCurrentPlayer().getColor() == move.piece.playersColor
10     }
11 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/gameType/GameType.kt:54:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\gameType\GameType.kt is not ending with a new line.
```
```kotlin
51     fun getFirstPlayer(): Player {
52         return players[0]
53     }
54 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/gameType/endConditions/EndCondition.kt:9:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\gameType\endConditions\EndCondition.kt is not ending with a new line.
```
```kotlin
6  
7  interface EndCondition {
8      fun check(game: GameEngine, player: Player): Boolean
9  }
!   ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/results/EndGameResult.kt:20:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\results\EndGameResult.kt is not ending with a new line.
```
```kotlin
17     override fun getMessage(): String{
18         return message
19     }
20 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/results/GameResult.kt:10:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\results\GameResult.kt is not ending with a new line.
```
```kotlin
7      fun getGame(): GameEngine
8      fun getCurrentPlayersTurn(): Player
9      fun getMessage(): String
10 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/results/InvalidMoveResult.kt:21:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\results\InvalidMoveResult.kt is not ending with a new line.
```
```kotlin
18         return message
19     }
20 
21 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/results/SuccessfulMoveResult.kt:19:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\results\SuccessfulMoveResult.kt is not ending with a new line.
```
```kotlin
16     override fun getMessage(): String{
17         return message
18     }
19 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/rules/GameRule.kt:9:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\rules\GameRule.kt is not ending with a new line.
```
```kotlin
6  
7  interface GameRule {
8      fun isFulfilled(game: GameEngine, move: ClassicMove): Boolean
9  }
!   ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/turnManager/TurnManager.kt:10:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\game\turnManager\TurnManager.kt is not ending with a new line.
```
```kotlin
7      val player: Player
8      fun whoseTurnIsIt(): Player
9      fun nextTurn(game: GameEngine): TurnManager
10 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/piece/PieceType.kt:12:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\piece\PieceType.kt is not ending with a new line.
```
```kotlin
9      KING,
10     CHECKERS,
11     CHECKERS_KING
12 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/piece/factory/PieceFactory.kt:31:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\piece\factory\PieceFactory.kt is not ending with a new line.
```
```kotlin
28             PieceType.CHECKERS_KING -> TODO()
29         }
30     }
31 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/piece/moveRules/MoveDiagonally.kt:18:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\piece\moveRules\MoveDiagonally.kt is not ending with a new line.
```
```kotlin
15     fun movingUp(from: Int, to: Int): Boolean {
16         return from < to
17     }
18 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/piece/moveRules/MoveLimitation.kt:16:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\piece\moveRules\MoveLimitation.kt is not ending with a new line.
```
```kotlin
13         }
14         return false
15     }
16 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/piece/moveRules/MoveRule.kt:9:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\piece\moveRules\MoveRule.kt is not ending with a new line.
```
```kotlin
6  interface MoveRule {
7      fun isFulfilled(board: Board, move: ClassicMove): Boolean
8  
9  }
!   ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/piece/specialRules/SpecialRule.kt:8:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\piece\specialRules\SpecialRule.kt is not ending with a new line.
```
```kotlin
5  
6  interface SpecialRule {
7      fun isFulfilled(board: Board, move: ClassicMove): Boolean
8  }
!   ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/Main.kt:47:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\ui\Main.kt is not ending with a new line.
```
```kotlin
44 
45         primaryStage.show()
46     }
47 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/UIGameEngine.kt:57:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\ui\UIGameEngine.kt is not ending with a new line.
```
```kotlin
54 
55 
56 
57 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/adapters/ColorAdapter.kt:15:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\ui\adapters\ColorAdapter.kt is not ending with a new line.
```
```kotlin
12 
13     }
14 
15 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/adapters/MoveAdapter.kt:16:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\ui\adapters\MoveAdapter.kt is not ending with a new line.
```
```kotlin
13         return ClassicMove(fromPos,toPos,piece!!)
14     }
15 
16 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/adapters/PieceAdapter.kt:26:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\ui\adapters\PieceAdapter.kt is not ending with a new line.
```
```kotlin
23         return pieces
24     }
25 
26 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/adapters/PositionAdapter.kt:14:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\ui\adapters\PositionAdapter.kt is not ending with a new line.
```
```kotlin
11     }
12 
13 
14 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/adapters/TestAdapter.kt:51:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\common\ui\adapters\TestAdapter.kt is not ending with a new line.
```
```kotlin
48             }
49         }
50     }
51 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/ChessApp.kt:37:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\client\ChessApp.kt is not ending with a new line.
```
```kotlin
34 fun main() {
35     launch(ChessApp::class.java)
36 
37 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/listener/GameOverListener.kt:17:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\client\listener\GameOverListener.kt is not ending with a new line.
```
```kotlin
14     }
15 
16 
17 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/listener/InitialStateListener.kt:14:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\client\listener\InitialStateListener.kt is not ending with a new line.
```
```kotlin
11     }
12 
13 
14 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/listener/MyClientConnectionListener.kt:15:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\client\listener\MyClientConnectionListener.kt is not ending with a new line.
```
```kotlin
12     override fun handleConnectionClosed() {
13         println("Connection closed")
14     }
15 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/listener/MyGameEventListener.kt:20:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\client\listener\MyGameEventListener.kt is not ending with a new line.
```
```kotlin
17     override fun handleUndo() {
18         gameClient.undo()
19     }
20 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/listener/SuccessfulMoveListener.kt:16:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\client\listener\SuccessfulMoveListener.kt is not ending with a new line.
```
```kotlin
13     }
14 
15 
16 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/payload/GameOverPayload.kt:5:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\client\payload\GameOverPayload.kt is not ending with a new line.
```
```kotlin
2 
3 import edu.austral.dissis.chess.gui.GameOver
4 class GameOverPayload(val result: GameOver){
5 }
!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/payload/InvalidMovePayload.kt:7:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\client\payload\InvalidMovePayload.kt is not ending with a new line.
```
```kotlin
4  
5  
6  class InvalidMovePayload(val result:  InvalidMove){
7  }
!   ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/payload/MovePayload.kt:7:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\client\payload\MovePayload.kt is not ending with a new line.
```
```kotlin
4  import edu.austral.dissis.chess.gui.Position
5  
6  data class MovePayload(val from: Position, val to: Position) {
7  }
!   ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/payload/RedoPayload.kt:4:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\client\payload\RedoPayload.kt is not ending with a new line.
```
```kotlin
1 package connection.client.payload
2 
3 class RedoPayload(val result: Boolean) {
4 }
!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/payload/SuccessfulMovePayload.kt:6:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\client\payload\SuccessfulMovePayload.kt is not ending with a new line.
```
```kotlin
3  import edu.austral.dissis.chess.gui.NewGameState
4  
5  data class SuccessfulMovePayload(val result: NewGameState) {
6  }
!   ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/payload/UndoPayload.kt:4:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\client\payload\UndoPayload.kt is not ending with a new line.
```
```kotlin
1 package connection.client.payload
2 
3 class UndoPayload(val result: Boolean){
4 }
!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/server/ChessServer.kt:35:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\server\ChessServer.kt is not ending with a new line.
```
```kotlin
32 fun main() {
33     val server = ChessServer()
34     server.start()
35 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/server/GameServer.kt:61:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\server\GameServer.kt is not ending with a new line.
```
```kotlin
58     }
59 
60 
61 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/server/listener/MoveListener.kt:29:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\server\listener\MoveListener.kt is not ending with a new line.
```
```kotlin
26         gameServer.handleSuccessfulMove(result )
27     }
28 
29 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/server/listener/MyServerConnectionListener.kt:18:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\server\listener\MyServerConnectionListener.kt is not ending with a new line.
```
```kotlin
15         TODO("Not yet implemented")
16     }
17 
18 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/server/listener/RedoListener.kt:13:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\server\listener\RedoListener.kt is not ending with a new line.
```
```kotlin
10         val result = gameServer.getGameEngine().redo()
11         gameServer.handleSuccessfulMove(result)
12     }
13 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/server/listener/UndoListener.kt:15:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\server\listener\UndoListener.kt is not ending with a new line.
```
```kotlin
12         val result = gameServer.getGameEngine().undo()
13         gameServer.handleSuccessfulMove(result)
14     }
15 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/server/payload/ClientPayload.kt:6:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\connection\server\payload\ClientPayload.kt is not ending with a new line.
```
```kotlin
3  import edu.austral.dissis.chess.gui.InitialState
4  
5  data class ClientPayload(val clientId: String, val initialState: InitialState) {
6  }
!   ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/CastlingAction.kt:31:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\game\actions\CastlingAction.kt is not ending with a new line.
```
```kotlin
28         }
29         return board
30     }
31 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/CheckersCapture.kt:15:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\game\actions\CheckersCapture.kt is not ending with a new line.
```
```kotlin
12     override fun execute(board: Board, move: ClassicMove): Board {
13         return board
14     }
15 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/CheckersPromotion.kt:15:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\game\actions\CheckersPromotion.kt is not ending with a new line.
```
```kotlin
12     override fun execute(board: Board, move: ClassicMove): Board {
13         return board
14     }
15 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/ChessCapture.kt:20:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\game\actions\ChessCapture.kt is not ending with a new line.
```
```kotlin
17     override fun execute(board: Board, move: ClassicMove): Board {
18         return board.removePieceAt(move.to).movePiece(move)
19     }
20 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/ChessPromotion.kt:32:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\game\actions\ChessPromotion.kt is not ending with a new line.
```
```kotlin
29         val newBoard = board.removePieceAt(move.from).putPieceAt(move.to, newPiece).getHisBoard()
30         return Board(board.maxRow, board.maxCol, newBoard.currentBoard, newBoard.pieces, board.moves.plus(move))
31     }
32 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/rules/CheckValidator.kt:34:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\game\rules\CheckValidator.kt is not ending with a new line.
```
```kotlin
31         return playerIsInCheck(newBoard,game.getCurrentPlayer())
32     }
33 
34 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/rules/ClearPath.kt:59:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\game\rules\ClearPath.kt is not ending with a new line.
```
```kotlin
56         }
57         return true
58     }
59 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/rules/IsEnemyPieceThere.kt:11:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\game\rules\IsEnemyPieceThere.kt is not ending with a new line.
```
```kotlin
8          val piece = board.getPieceAt(move.to)
9          return piece != null && piece.playersColor != move.piece.playersColor
10     }
11 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/types/endConditions/ClassicEndConditions.kt:47:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\game\types\endConditions\ClassicEndConditions.kt is not ending with a new line.
```
```kotlin
44     }
45 
46 
47 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/types/ruleSets/ClassicChessRuleSet.kt:45:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\game\types\ruleSets\ClassicChessRuleSet.kt is not ending with a new line.
```
```kotlin
42     }
43 
44 
45 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/KingMoves.kt:16:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\rules\KingMoves.kt is not ending with a new line.
```
```kotlin
13         return vertical.isFulfilled(board,move) || horizontal.isFulfilled(board,move) || diagonal.isFulfilled(board,move)
14     }
15 
16 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/MoveForward.kt:19:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\rules\MoveForward.kt is not ending with a new line.
```
```kotlin
16         }
17     }
18 
19 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/MoveHorizontally.kt:16:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\rules\MoveHorizontally.kt is not ending with a new line.
```
```kotlin
13         return from < to
14     }
15 
16 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/MoveLShape.kt:24:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\rules\MoveLShape.kt is not ending with a new line.
```
```kotlin
21     private fun twoVertical(move: ClassicMove): Boolean{
22         return abs(move.from.y - move.to.y) == 2
23     }
24 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/MoveVerticalORHorizontal.kt:13:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\rules\MoveVerticalORHorizontal.kt is not ending with a new line.
```
```kotlin
10     override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
11         return vertical.isFulfilled(board, move) || horizontal.isFulfilled(board, move)
12     }
13 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/MoveVertically.kt:15:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\rules\MoveVertically.kt is not ending with a new line.
```
```kotlin
12     fun movingUp(from: Int, to: Int): Boolean {
13         return from < to
14     }
15 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/PawnMovesComposite.kt:21:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\rules\PawnMovesComposite.kt is not ending with a new line.
```
```kotlin
18     }
19 
20 
21 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/QueenMoves.kt:18:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\rules\QueenMoves.kt is not ending with a new line.
```
```kotlin
15         return moves.any { it.isFulfilled(board, move) }
16     }
17 
18 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:43:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\rules\specialRules\Castling.kt is not ending with a new line.
```
```kotlin
40         return board.moves.any { it.piece == piece }
41     }
42 
43 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/DoublePawnMove.kt:17:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\rules\specialRules\DoublePawnMove.kt is not ending with a new line.
```
```kotlin
14             move.from.y == 7 && move.to.y == 5
15         }
16     }
17 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:64:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\setUps\ClassicChessBoardSetUp.kt is not ending with a new line.
```
```kotlin
61 
62         return board
63     }
64 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CastlingSetUp.kt:33:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\setUps\king\CastlingSetUp.kt is not ending with a new line.
```
```kotlin
30         board = board.putPieceAt(Position(5, 8), bKing).getHisBoard()
31         return board
32     }
33 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/king/CheckMateSetUp.kt:29:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\setUps\king\CheckMateSetUp.kt is not ending with a new line.
```
```kotlin
26         board = board.putPieceAt(Position(5, 8), bKing).getHisBoard()
27         return board
28     }
29 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/ChessPromotionSetUp.kt:22:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\setUps\pawn\ChessPromotionSetUp.kt is not ending with a new line.
```
```kotlin
19         board = board.putPieceAt(Position(1, 7), wPiece).getHisBoard()
20         return board
21     }
22 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/PathNotClearSetUp.kt:24:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\setUps\pawn\PathNotClearSetUp.kt is not ending with a new line.
```
```kotlin
21         board = board.putPieceAt(Position(1, 3), bPiece).getHisBoard()
22         return board
23     }
24 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/pawn/PawnCaptureSetUp.kt:24:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\setUps\pawn\PawnCaptureSetUp.kt is not ending with a new line.
```
```kotlin
21         board = board.putPieceAt(Position(2, 3), bPiece).getHisBoard()
22         return board
23     }
24 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/rook/RookMovesSetUp.kt:26:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\setUps\rook\RookMovesSetUp.kt is not ending with a new line.
```
```kotlin
23         board = board.putPieceAt(Position(8, 8), bRook2).getHisBoard()
24         return board
25     }
26 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/rook/RookPathNotClearSetUp.kt:25:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\main\kotlin\edu\austral\dissis\chess\engine\setUps\rook\RookPathNotClearSetUp.kt is not ending with a new line.
```
```kotlin
22         board = board.putPieceAt(Position(1, 3), bPiece).getHisBoard()
23         return board
24     }
25 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/test/kotlin/edu/austral/dissis/chess/engine/exam/MyEngineTestGameRunner.kt:90:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\test\kotlin\edu\austral\dissis\chess\engine\exam\MyEngineTestGameRunner.kt is not ending with a new line.
```
```kotlin
87         game = result
88         return TestMoveSuccess(this)
89     }
90 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/test/kotlin/edu/austral/dissis/chess/engine/pieceMovesTest/PawnMovesTest.kt:117:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\test\kotlin\edu\austral\dissis\chess\engine\pieceMovesTest\PawnMovesTest.kt is not ending with a new line.
```
```kotlin
114         val result = game.move(move)
115         assert(result is SuccessfulMoveResult)
116     }
117 }
!!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/test/kotlin/edu/austral/dissis/chess/engine/pieceMovesTest/RookMovesTest.kt:104:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\test\kotlin\edu\austral\dissis\chess\engine\pieceMovesTest\RookMovesTest.kt is not ending with a new line.
```
```kotlin
101         val result = game.move(move)
102         assert(result is InvalidMoveResult)
103     }
104 }
!!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/test/kotlin/edu/austral/dissis/chess/engine/predefined/DummyTestMoveRunner.kt:23:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\test\kotlin\edu\austral\dissis\chess\engine\predefined\DummyTestMoveRunner.kt is not ending with a new line.
```
```kotlin
20     override fun executeMove(testBoard: TestBoard, from: TestPosition, to: TestPosition): Validity {
21         return if (to in validMoves) Validity.VALID else return Validity.INVALID
22     }
23 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/test/kotlin/edu/austral/dissis/chess/engine/predefined/KnightMoveTests.kt:61:2
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\test\kotlin\edu\austral\dissis\chess\engine\predefined\KnightMoveTests.kt is not ending with a new line.
```
```kotlin
58 //        )
59 //    }
60 
61 }
!!  ^ error

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/test/kotlin/edu/austral/dissis/chess/engine/predefined/MyTestMoveRunner.kt:29:4
```
The file C:\Users\pablo\projects\DisSist\chess-Pagliaricci\engine\src\test\kotlin\edu\austral\dissis\chess\engine\predefined\MyTestMoveRunner.kt is not ending with a new line.
```
```kotlin
26 //        }
27 //        return ChessBoard(8,8,myBoard,mySet, emptyList())
28 //    }
29 //}
!!    ^ error

```

### style, ReturnCount (7)

Restrict the number of return statements in methods.

[Documentation](https://detekt.dev/docs/rules/style#returncount)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/GameEngine.kt:18:9
```
Function move has 4 return statements which exceeds the limit of 2.
```
```kotlin
15 
16 class GameEngine(private val board: Board, private val turnManager: TurnManager, private val gameType: GameType, private val undoStack: Stack<GameEngine>, private val redoStack: Stack<GameEngine>) {
17 
18     fun move(move: ClassicMove): GameResult {
!!         ^ error
19         if (!canMove(move)) {
20             return InvalidMoveResult(this, turnManager.whoseTurnIsIt(), gameType.getGameMessage())
21         }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/piece/moveRules/MoveLimitation.kt:9:18
```
Function isFulfilled has 3 return statements which exceeds the limit of 2.
```
```kotlin
6  import kotlin.math.abs
7  
8  class MoveLimitation(private val xMax : Int, private val yMax: Int, private val specialMove : SpecialRule?): MoveRule {
9      override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
!                   ^ error
10         if(specialMove != null && specialMove.isFulfilled(board, move)) return true
11         if(abs(move.from.x - move.to.x) <= xMax && abs(move.from.y - move.to.y) <= yMax) {
12             return true

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/UIGameEngine.kt:12:18
```
Function applyMove has 4 return statements which exceeds the limit of 2.
```
```kotlin
9  
10 class UIGameEngine( private var game: common.game.GameEngine): GameEngine {
11 
12     override fun applyMove(move: Move): MoveResult {
!!                  ^ error
13         val myMove = MoveAdapter().adapt(move,game.getBoard()) ?: return InvalidMove("No piece at that position")
14         val result = game.move(myMove)
15         if(result is InvalidMoveResult){

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/CastlingAction.kt:15:18
```
Function execute has 3 return statements which exceeds the limit of 2.
```
```kotlin
12         return Castling().isFulfilled(board, move)
13     }
14 
15     override fun execute(board: Board, move: ClassicMove): Board {
!!                  ^ error
16         val king = board.getPieceAt(move.from)!!
17         if(Castling().isShortCastling(move)){
18             val rookPosition = if(king.playersColor == Color.WHITE) Position(8,1) else Position(8,8)

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/game/actions/ChessPromotion.kt:14:18
```
Function isFulfilled has 3 return statements which exceeds the limit of 2.
```
```kotlin
11 import edu.austral.dissis.chess.engine.rules.MoveVertically
12 
13 class ChessPromotion: Action {
14     override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
!!                  ^ error
15         val piece = board.getPieceAt(move.from)
16         if (piece!!.pieceType == PieceType.PAWN) {
17             if (piece.playersColor == Color.WHITE) {

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/rules/specialRules/Castling.kt:11:18
```
Function isFulfilled has 3 return statements which exceeds the limit of 2.
```
```kotlin
8  import common.elements.position.Position
9  
10 class Castling: SpecialRule {
11     override fun isFulfilled(board: Board, move: ClassicMove): Boolean {
!!                  ^ error
12         if(isShortCastling(move)){
13             return isShortCastlingPossible(board,move)
14         }

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/test/kotlin/edu/austral/dissis/chess/engine/exam/MyEngineTestGameRunner.kt:34:18
```
Function executeMove has 3 return statements which exceeds the limit of 2.
```
```kotlin
31     private val turnManager = ClassicChessTurnManager(gameType.getPlayers()[0])
32     private var game = GameEngine(gameType.getInitialBoard(),turnManager,gameType, Stack(), Stack())
33 
34     override fun executeMove(from: TestPosition, to: TestPosition): TestMoveResult {
!!                  ^ error
35         val myMove = ClassicMove(
36             Position(from.col,from.row), Position(to.col,to.row),
37             game.getBoard().getPieceAt(Position(from.col,from.row))!!)

```

### style, UnusedPrivateMember (1)

Private function is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedprivatemember)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/game/GameEngine.kt:46:17
```
Private function `itsActionMove` is unused.
```
```kotlin
43         return EndGameResult(GameEngine(newBoard,turnManager,gameType,undoStack,redoStack), turnManager.whoseTurnIsIt(), gameType.getGameMessage())
44     }
45 
46     private fun itsActionMove(move: ClassicMove): Boolean {
!!                 ^ error
47         for (action in gameType.getBoardActions()) {
48             if (action.isFulfilled(board,move)) {
49                 return true

```

### style, UnusedPrivateProperty (1)

Property is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedprivateproperty)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/board/boardResults/SuccessfulBoardResult.kt:4:41
```
Private property `msg` is unused.
```
```kotlin
1 package common.board.boardResults
2 
3 import common.board.Board
4 class SuccessfulBoardResult(private val msg: String, private val board: Board): BoardResult {
!                                         ^ error
5 
6     override fun getHisBoard(): Board {
7         return board

```

### style, WildcardImport (9)

Wildcard imports should be replaced with imports using fully qualified class names. Wildcard imports can lead to naming conflicts. A library update can introduce naming clashes with your classes which results in compilation errors.

[Documentation](https://detekt.dev/docs/rules/style#wildcardimport)

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/piece/factory/PieceFactory.kt:9:1
```
edu.austral.dissis.chess.engine.rules.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
6  import common.piece.PieceType
7  import common.piece.moveRules.MoveDiagonally
8  import common.piece.moveRules.MoveLimitation
9  import edu.austral.dissis.chess.engine.rules.*
!  ^ error
10 import edu.austral.dissis.chess.engine.rules.specialRules.Castling
11 import edu.austral.dissis.chess.engine.rules.specialRules.DoublePawnMove
12 

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/Main.kt:10:1
```
edu.austral.dissis.chess.gui.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
7  import edu.austral.dissis.chess.engine.game.turnManagers.ClassicChessTurnManager
8  import edu.austral.dissis.chess.engine.game.types.endConditions.ClassicEndConditions
9  import edu.austral.dissis.chess.engine.game.types.ruleSets.ClassicChessRuleSet
10 import edu.austral.dissis.chess.gui.*
!! ^ error
11 import javafx.application.Application
12 import javafx.application.Application.launch
13 import javafx.scene.Scene

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/common/ui/UIGameEngine.kt:5:1
```
edu.austral.dissis.chess.gui.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
2 
3 import common.game.results.EndGameResult
4 import common.game.results.InvalidMoveResult
5 import edu.austral.dissis.chess.gui.*
! ^ error
6 import common.ui.adapters.ColorAdapter
7 import common.ui.adapters.MoveAdapter
8 import common.ui.adapters.PieceAdapter

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/GameClient.kt:9:1
```
connection.client.listener.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
6  import connection.server.payload.ClientPayload
7  import connection.client.payload.SuccessfulMovePayload
8  import connection.client.payload.UndoPayload
9  import connection.client.listener.*
!  ^ error
10 import edu.austral.dissis.chess.gui.*
11 import edu.austral.ingsis.clientserver.ClientBuilder
12 import edu.austral.ingsis.clientserver.Message

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/client/GameClient.kt:10:1
```
edu.austral.dissis.chess.gui.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
7  import connection.client.payload.SuccessfulMovePayload
8  import connection.client.payload.UndoPayload
9  import connection.client.listener.*
10 import edu.austral.dissis.chess.gui.*
!! ^ error
11 import edu.austral.ingsis.clientserver.ClientBuilder
12 import edu.austral.ingsis.clientserver.Message
13 import edu.austral.ingsis.clientserver.netty.client.NettyClientBuilder

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/server/GameServer.kt:4:1
```
connection.client.payload.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
1 package connection.server
2 
3 import com.fasterxml.jackson.core.type.TypeReference
4 import connection.client.payload.*
! ^ error
5 import connection.server.listener.MoveListener
6 import connection.server.listener.MyServerConnectionListener
7 import connection.server.listener.RedoListener

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/connection/server/GameServer.kt:10:1
```
edu.austral.dissis.chess.gui.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
7  import connection.server.listener.RedoListener
8  import connection.server.listener.UndoListener
9  import connection.server.payload.ClientPayload
10 import edu.austral.dissis.chess.gui.*
!! ^ error
11 import edu.austral.ingsis.clientserver.Message
12 import edu.austral.ingsis.clientserver.ServerBuilder
13 import edu.austral.ingsis.clientserver.netty.server.NettyServerBuilder

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/main/kotlin/edu/austral/dissis/chess/engine/setUps/ClassicChessBoardSetUp.kt:10:1
```
edu.austral.dissis.chess.engine.rules.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
7  import common.piece.moveRules.MoveDiagonally
8  import common.piece.moveRules.MoveLimitation
9  import common.elements.position.Position
10 import edu.austral.dissis.chess.engine.rules.*
!! ^ error
11 import edu.austral.dissis.chess.engine.rules.specialRules.Castling
12 import edu.austral.dissis.chess.engine.rules.specialRules.DoublePawnMove
13 

```

* C:/Users/pablo/projects/DisSist/chess-Pagliaricci/engine/src/test/kotlin/edu/austral/dissis/chess/engine/exam/MyEngineTestGameRunner.kt:18:1
```
edu.austral.dissis.chess.test.game.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
15 import edu.austral.dissis.chess.test.TestPiece
16 import edu.austral.dissis.chess.test.TestPosition
17 import edu.austral.dissis.chess.test.TestSize
18 import edu.austral.dissis.chess.test.game.*
!! ^ error
19 import common.ui.adapters.TestAdapter
20 import edu.austral.dissis.chess.engine.game.turnManagers.ClassicChessTurnManager
21 import edu.austral.dissis.chess.engine.game.types.endConditions.ClassicEndConditions

```

generated with [detekt version 1.23.6](https://detekt.dev/) on 2024-06-17 22:44:03 UTC
