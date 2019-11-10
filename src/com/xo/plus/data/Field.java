package com.xo.plus.data;

import com.xo.plus.game.exceptions.IncorrectIndexException;
import com.xo.plus.game.exceptions.IncorrectLetterException;
import com.xo.plus.game.main.GameChecker;

public class Field {
    private String[][] field;

    public Field() {
        int size = Constant.FIELD_SIZE;
        field = new String[size][size];
        fillNulls();
    }

    public String get(int y, int x) {
        try {
            GameChecker.checkIndex(y,x,field);
        } catch (IncorrectIndexException ex) {
            System.out.println(ex.getError());
        }
        return field[y][x];
    }

    public void set(int y, int x, String newVal)
    throws IncorrectLetterException,IncorrectIndexException
    {
       // try{
            GameChecker.checkIndex(y,x,field);
            GameChecker.checkLetter(newVal);
     //   } catch (IncorrectIndexException ex) {
    //        System.out.println(ex.getError());
   //     } catch (IncorrectLetterException ex) {
    //        System.out.println(ex.getError());
    //    }
        field[y][x] = newVal;
    }

    public boolean isFull() {
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field.length; x++) {
                if (field[y][x].equals(Constant.DEFAULT_CHARACTER)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printOnScreen() {
        for (int y = 0; y < field.length; y++) {
            System.out.print("|");
            for (int x = 0; x < field.length; x++) {
                String value = field[y][x];
                if (value.equals(Constant.DEFAULT_CHARACTER)) value = " ";
                System.out.print(value + "|");
            }
            System.out.println();
        }
    }

    public int[] getState() {
        int countX = 0;
        int countO = 0;

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field.length; x++) {
                if (field[y][x].equals("X")) {
                    countX++;
                } else if (field[y][x].equals("O")) {
                    countO++;
                }
            }
        }

        return new int[] {countX, countO};
    }

    private void fillNulls() {
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field.length; x++) {
                field[y][x] = Constant.DEFAULT_CHARACTER;
            }
        }
    }
}
