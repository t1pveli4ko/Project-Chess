package com.company;

public abstract class Move {
    ChessBoard board;
    Piece movedPiece;
    int destinationOfThePiece;

    protected Move(ChessBoard board, Piece movedPiece, int destinationOfThePiece){
        this.board=board;
        this.movedPiece=movedPiece;
        this.destinationOfThePiece=destinationOfThePiece;
    }

}
