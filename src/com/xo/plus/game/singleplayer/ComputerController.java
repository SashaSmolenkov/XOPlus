package com.xo.plus.game.singleplayer;

import com.xo.plus.data.Constant;
import com.xo.plus.data.Field;
import com.xo.plus.data.Winner;
import com.xo.plus.game.main.GameWinController;

public class ComputerController {
    public int[] makeStep(Field field, GameWinController winController)
    throws Exception
    {
        int[] ourWin = findWinPosition(field, winController, "O");
        int[] enemyWin = findWinPosition(field, winController, "X");

        //System.out.println(ourWins[0] + " " + ourWins[1] + " " + enemyWins[0] + " " + enemyWins[1]);

        if (ourWin[0] >= 0) {
            return ourWin;
        } else if (enemyWin[0] >= 0) {
            return enemyWin;
        } else {
            return getFirstFreeIndex(field);
        }
    }

    private int[] findWinPosition(Field field, GameWinController winController, String who)
    throws Exception
    {
        int[] result = {-1,-1};

        Field fieldClone;

        for (int y = 0; y < Constant.FIELD_SIZE; y++) {
            for (int x = 0; x < Constant.FIELD_SIZE; x++) {
                if (field.get(y,x).equals(Constant.DEFAULT_CHARACTER)) {
                    fieldClone = field.cloneField();
                    fieldClone.set(y,x,who);

                    Winner win = winController.getWin(fieldClone);

                    if (win.getWinner() != null) {
                        if (win.getWinner().equals(who)) {
                            return new int[]{y, x};
                        }
                    }
                }
            }
        }

        return result;
    }

    private int[] getFirstFreeIndex(Field field)
    throws Exception
    {
        int[] index = {-1,-1};

        for (int y = 0; y < Constant.FIELD_SIZE; y++) {
            for (int x = 0; x < Constant.FIELD_SIZE; x++) {
                if (field.get(y,x).equals(Constant.DEFAULT_CHARACTER)) {
                    index = new int[] {y,x};
                    return index;
                }
            }
        }

        return index;
    }
}
