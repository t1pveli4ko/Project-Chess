package com.company;

public class BoardUtils {

    private static boolean[] initColumn(int columnNum) {
        boolean[] column = new boolean[64];
        do {
            column[columnNum] = true;
            columnNum += 8;
        } while (columnNum < 64);
        return column;
    }

    public static final boolean[] FIRST_COLUMN = initColumn(0);
    public static final boolean[] SECOND_COLUMN = initColumn(1);
    public static final boolean[] SEVENTH_COLUMN = initColumn(6);
    public static final boolean[] EIGHT_COLUMN = initColumn(7);

    private BoardUtils() {
        throw new RuntimeException("You cannot instantiate me!");
    }

    static boolean isValidTileCoordinate(int coordinates) {
        return coordinates >= 0 && coordinates < 64;
    }
}
