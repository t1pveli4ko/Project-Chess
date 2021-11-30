package com.company;

public class EmptyTile extends ChessTile {
    protected EmptyTile(int coordinate) {
        super(coordinate);
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return null;
    }
}
