package com.company;

public class AttackingMove extends Move {
    Piece attackedPiece;

    AttackingMove(ChessBoard board, Piece movedPiece, int destinationOfThePiece, Piece attackedPiece) {
        super(board, movedPiece, destinationOfThePiece);
        this.attackedPiece=attackedPiece;
    }
}
