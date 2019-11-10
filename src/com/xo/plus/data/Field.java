package com.xo.plus.data;

public class Field {
    private String[][] field;

    public Field() {
        int size = Constant.FIELD_SIZE;
        field = new String[size][size];
        fillNulls();
    }

    public static void checkIndex(int y, int x)
    throws Exception
    {
        int size = Constant.FIELD_SIZE;

        if (y >= size || x >= size
                || y < 0 || x < 0) {
            throw new Exception("XO Error 01 : incorrect index typed.");
        }
    }

    public String get(int y, int x)
    throws Exception
    {
        checkIndex(y,x);
        return field[y][x];
    }

    public void set(int y, int x, String newVal)
    throws Exception
    {
        checkIndex(y,x);
        if (newVal.equals("X") || newVal.equals("O") || newVal.equals(Constant.DEFAULT_CHARACTER) ) {
            field[y][x] = newVal;
        } else {
            throw new Exception("XO Error 02 : incorrect letter typed (not X, O or N).");
        }
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

    public String toString() {
        String out = "";
        for (int y = 0; y < field.length; y++) {
            out += "|";
            for (int x = 0; x < field.length; x++) {
                String value = field[y][x];
                if (value.equals(Constant.DEFAULT_CHARACTER)) value = " ";
                out += value + "|";
            }
            out += "\n";
        }
        return out;
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
