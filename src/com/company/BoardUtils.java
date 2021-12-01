package com.company;

public class BoardUtils {

    public static final boolean[] FIRST_COLUMN = null;
    public static final boolean[] SECOND_COLUMN = null;
    public static final boolean[] SEVENTH_COLUMN = null;
    public static final boolean[] EIGHT_COLUMN = null;

    private BoardUtils(){
        throw new RuntimeException("You cannot instantiate me!");
    }

    static boolean isValidTileCoordinate(int coordinates){
        return coordinates >= 0 && coordinates < 64;
    }
}
