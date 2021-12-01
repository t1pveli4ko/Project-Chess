package com.company;

import java.util.Collection;

public abstract class Piece {
    protected int position;
    protected PieceColor pieceColor;

    public Piece(int position, PieceColor pieceColor){
        this.position=position;
        this.pieceColor=pieceColor;
    }

    public PieceColor getPieceColor(){
        return this.pieceColor;
    }

    public abstract Collection<Move> calculateMoves(ChessBoard board);
}
