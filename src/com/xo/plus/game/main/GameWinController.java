package com.xo.plus.game.main;

import com.xo.plus.data.Constant;
import com.xo.plus.data.Field;
import com.xo.plus.data.Winner;

public class GameWinController {
    public Winner getWin(Field field)
    throws Exception
    {
        Winner winner;

        if ((winner = checkDiagonal1(field)).isWon()) {
            return winner;
        }

        if ((winner = checkDiagonal2(field)).isWon()) {
            return winner;
        }

        if ((winner = checkHorizontal(field)).isWon()) {
            return winner;
        }

        if ((winner = checkVertical(field)).isWon()) {
            return winner;
        }

        return new Winner(false,null);
    }

    private Winner checkDiagonal1(Field field)
    throws Exception
    {
        String startLetter = field.get(0,0);
        Winner winner = new Winner(false,null);

        for (int x = 0, y = 0;
            x < Constant.FIELD_SIZE;
            x++, y++) {

            if (field.get(y,x).equals(Constant.DEFAULT_CHARACTER)) {
                winner.setWon(false);
                break;
            }

            if (field.get(y,x).equals(startLetter)) {
                winner.setWon(true);
            } else {
                winner.setWon(false);
                break;
            }
        }

        if (winner.isWon()) winner.setWinner(startLetter);

        return winner;
    }

    private Winner checkDiagonal2(Field field)
    throws Exception
    {
        String startLetter = field.get(0,Constant.FIELD_SIZE - 1);
        Winner winner = new Winner(false,null);

        for (int x = Constant.FIELD_SIZE - 1, y = 0;
             y < Constant.FIELD_SIZE;
             x--, y++) {

            if (field.get(y,x).equals(Constant.DEFAULT_CHARACTER)) {
                winner.setWon(false);
                break;
            }

            if (field.get(y,x).equals(startLetter)) {
                winner.setWon(true);
            } else {
                winner.setWon(false);
                break;
            }
        }

        if (winner.isWon()) winner.setWinner(startLetter);

        return winner;
    }

    private Winner checkHorizontal(Field field)
    throws Exception
    {
        String startLetter = "";
        boolean findWin = false;
        Winner winner = new Winner(false,null);

        for (int y = 0; y < Constant.FIELD_SIZE; y++) {
            startLetter = field.get(y,0);

            for (int x = 0; x < Constant.FIELD_SIZE; x++) {
                if (field.get(y,x).equals(Constant.DEFAULT_CHARACTER)) {
                    findWin = false;
                    break;
                }

                if (field.get(y,x).equals(startLetter)) {
                    findWin = true;
                } else {
                    findWin = false;
                    break;
                }
            }

            if (findWin) break;
        }

        if (findWin) {
            winner.setWon(true);
            winner.setWinner(startLetter);
        }

        return winner;
    }

    private Winner checkVertical(Field field)
    throws Exception
    {
        String startLetter = "";
        boolean findWin = false;
        Winner winner = new Winner(false,null);

        for (int x = 0; x < Constant.FIELD_SIZE; x++) {
            startLetter = field.get(0,x);

            for (int y = 0; y < Constant.FIELD_SIZE; y++) {
                if (field.get(y,x).equals(Constant.DEFAULT_CHARACTER)) {
                    findWin = false;
                    break;
                }

                if (field.get(y,x).equals(startLetter)) {
                    findWin = true;
                } else {
                    findWin = false;
                    break;
                }
            }

            if (findWin) break;
        }

        if (findWin) {
            winner.setWon(true);
            winner.setWinner(startLetter);
        }

        return winner;
    }
}
