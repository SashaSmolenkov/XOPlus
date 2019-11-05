package com.xo.plus.game.main;

import com.xo.plus.data.Field;

public class StepController {
    public String getNext(Field field) {
        int[] state = field.getState();
        int countX = state[0];
        int countO = state[1];

        if (countX == 0 && countO == 0) {
            return "X";
        } else if (countX > countO) {
            return "O";
        } else if (countO > countX) {
            return "X";
        }

        return "X";
    }
}
