package com.company;

import java.util.List;

public abstract class Piece {
    protected int position;
    protected PieceColor pieceColor;

    public Piece(int position, PieceColor pieceColor){
        this.position=position;
        this.pieceColor=pieceColor;
    }

    public abstract List<Move> calculateMoves(ChessBoard board);
}
