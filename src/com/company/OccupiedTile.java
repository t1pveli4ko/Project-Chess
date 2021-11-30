package com.company;

public class OccupiedTile extends ChessTile {
    private Piece piece;

    protected OccupiedTile(int coordinate, Piece piece) {
        super(coordinate);
        this.piece = piece;
    }

    @Override
    public boolean isOccupied() {
        return true;
    }

    @Override
    public Piece getPiece() {
        return this.piece;
    }
}
