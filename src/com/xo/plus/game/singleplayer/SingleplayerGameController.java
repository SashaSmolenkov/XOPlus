package com.xo.plus.game.singleplayer;

import com.xo.plus.data.Constant;
import com.xo.plus.game.main.GameController;
import com.xo.plus.viewer.ConsoleView;
import com.xo.plus.viewer.SwingView;

public class SingleplayerGameController extends GameController {
    public SingleplayerGameController(ConsoleView consoleView, SwingView swingView) {
        super(consoleView,swingView);
    }

    @Override
    protected void update()
    throws Exception
    {
        String stepName;
        String stepLetter = stepController.getNext(field);
        int[] stepPoint = {};
        boolean isStepFromPC = false;

        if (stepLetter.equals("X")) {
            stepName = game.getPlayer1Name();
        } else {
            stepName = Constant.COMPUTER_NAME;
            isStepFromPC = true;
        }

        if (!isStepFromPC) {
            if (consoleView != null) {
                stepPoint = consoleView.update(stepName);
            }
            if (swingView != null) {
                stepPoint = swingView.update(stepName);
            }
        }

        if (isStepFromPC) {
            stepPoint = computerController.makeStep(field,winController);
        }
        field.set(stepPoint[0],stepPoint[1],stepLetter);
        System.out.println(field);
    }
}
