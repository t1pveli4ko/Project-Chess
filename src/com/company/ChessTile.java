package com.company;

public abstract class ChessTile {
    int coordinates;

    public ChessTile(int coordinates){
        this.coordinates=coordinates;
    }

    public abstract boolean isOccupied();

    public abstract Piece getPiece();
}
