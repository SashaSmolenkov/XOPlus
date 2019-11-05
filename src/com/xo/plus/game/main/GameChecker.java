package com.xo.plus.game.main;

import com.xo.plus.data.Constant;

public class GameChecker {
    public static void checkIndex(int y, int x) {
        int size = Constant.FIELD_SIZE;

        if (y >= size || x >= size
                || y < 0 || x < 0) {
            System.err.println("XO Error 01 : incorrect index typed.");
        }
    }

    public static void checkLetter(String letter) {
        if (letter.equals("X") || letter.equals("O") || letter.equals(Constant.DEFAULT_CHARACTER) ) {
            return;
        } else {
            System.err.println("XO Error 02 : incorrect letter typed (not X, O or N).");
        }
    }
}
