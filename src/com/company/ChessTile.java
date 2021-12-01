package com.company;

import com.company.EmptyTile;
import com.company.OccupiedTile;
import com.company.Piece;

import java.util.HashMap;
import java.util.Map;

public abstract class ChessTile {
    public int coordinates;

    //Показва свободните полета от кеша
    private static Map<Integer, EmptyTile> EMPTY_CACHE = allEmptyTiles();

    private static Map<Integer, EmptyTile> allEmptyTiles() {
        Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
        for (int i = 0; i < 64; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return emptyTileMap;
    }

    //Задава позицията на дадената фигура и освобождава старата позиция
    public ChessTile createTile(int coordinates, Piece piece) {
        if (piece != null) {
            return new OccupiedTile(coordinates, piece);
        } else {
            return EMPTY_CACHE.get(coordinates);
        }
    }

    protected ChessTile(int coordinates) {
        this.coordinates = coordinates;
    }

    public abstract boolean isOccupied();

    public abstract Piece getPiece();
}
