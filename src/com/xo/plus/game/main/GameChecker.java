package com.xo.plus.game.main;

import com.xo.plus.data.Constant;
import com.xo.plus.data.Field;
import com.xo.plus.game.exceptions.IncorrectIndexException;
import com.xo.plus.game.exceptions.IncorrectLetterException;

public class GameChecker {
    public static void checkIndex(int y, int x, String[][] field)
    throws IncorrectIndexException
    {
        int size = Constant.FIELD_SIZE;

        if (!field[y][x].equals("N")) {
            throw new IncorrectIndexException();
        }

        if (y >= size || x >= size
                || y < 0 || x < 0) {
            throw new IncorrectIndexException();
        }
    }

    public static void checkLetter(String letter)
    throws IncorrectLetterException
    {
        if (letter.equals("X") || letter.equals("O") || letter.equals(Constant.DEFAULT_CHARACTER) ) {
            return;
        } else {
            throw new IncorrectLetterException();
        }
    }
}
