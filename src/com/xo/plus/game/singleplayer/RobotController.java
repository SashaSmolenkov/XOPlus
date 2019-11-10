package com.xo.plus.game.singleplayer;

import com.xo.plus.data.Field;
import com.xo.plus.game.exceptions.IncorrectIndexException;
import com.xo.plus.game.exceptions.IncorrectLetterException;

public class RobotController {
    public void makeStep(Field field) {
        try {
            field.set(2, 2, "O");
        } catch (IncorrectIndexException ex) {

        } catch (IncorrectLetterException ex) {

        }
    }
}
