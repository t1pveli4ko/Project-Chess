package com.company;

public abstract class EmptyTile extends ChessTile {
    public EmptyTile(int coordinate){
        super(coordinate);
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public Piece getPiece(){
        return null;
    }
}
