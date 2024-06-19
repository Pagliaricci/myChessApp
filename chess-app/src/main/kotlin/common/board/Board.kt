package common.board


import common.elements.color.Color
import common.piece.Piece
import common.piece.PieceType
import common.elements.moveTypes.ClassicMove

import common.elements.position.Position

class Board(val maxRow: Int, val maxCol: Int,
            val currentBoard: Map<Position, Piece> = emptyMap<Position, Piece>(),
            val pieces : Set<Piece> = emptySet(),
            val moves: List<ClassicMove>){

    fun getPieceAt(position: Position): Piece? {
        if(!currentBoard.containsKey(position)){
            return null
        }
        return currentBoard[position]
    }
    fun putPieceAt(position: Position, piece: Piece): Board {
        if(currentBoard.containsKey(position)){
            return this
        }
        return Board(maxRow, maxCol, currentBoard.plus(position to piece), pieces.plus(piece), moves)
    }
    fun removePieceAt(position: Position): Board {
        val piece = getPieceAt(position)
      if (piece != null){
          return Board(maxRow,maxCol,currentBoard.minus(position),pieces.minus(piece),moves)
      }
        return Board(maxRow,maxCol,currentBoard,pieces,moves)
    }


    fun movePiece(move: ClassicMove): Board {

        val newBoard = removePieceAt(move.to).removePieceAt(move.from).putPieceAt(move.to, move.piece)
        return Board(maxRow, maxCol, newBoard.currentBoard, newBoard.pieces, moves.plus(move))
    }
    fun containsPiece(position: Position): Boolean {
        return currentBoard.containsKey(position)
    }

    fun getPositionOf(piece: Piece): Position {
        if(pieces.contains(piece)){
            return currentBoard.filterValues { it == piece }.keys.first()
        }
        return Position(0,0)
    }

    fun getPieces(): List<Piece> {
        return pieces.toList()
    }

    fun getKingPosition(color: Color): Position {
        for (piece in pieces){
            if(piece.pieceType == PieceType.KING && piece.playersColor == color){
                return getPositionOf(piece)
            }
        }
        return Position(-1,-1)
    }

    fun printBoard() {
        for (i in 1..maxCol) {
            for (j in 1..maxRow) {
                val piece = getPieceAt(Position(j, i))
                if (piece != null) {
                    print(" | ${piece.pieceType} | ")
                } else {
                    print("|   0   |")
                }
            }
            println()
        }
    }

}