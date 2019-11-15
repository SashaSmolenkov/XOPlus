package com.xo.plus.game.multiplayer;

import com.xo.plus.data.Constant;
import com.xo.plus.game.main.GameController;
import com.xo.plus.viewer.ConsoleView;
import com.xo.plus.viewer.SwingView;

public class MultiplayerGameController extends GameController {
    public MultiplayerGameController(ConsoleView consoleView, SwingView swingView) {
        super(consoleView,swingView);
    }

    @Override
    protected void update()
    throws Exception
    {
        String stepLetter = stepController.getNext(field);
        String stepName = Constant.DEFAULT_PLAYER_NAME;
        int[] stepPoint = new int[2];
        if (stepLetter.equals("X")) stepName = game.getPlayer1Name();
        if (stepLetter.equals("O")) stepName = game.getPlayer2Name();

        if (consoleView != null) {
            stepPoint = consoleView.update(stepName);
    }
        if (swingView != null) {
            stepPoint = swingView.update(stepName);
        }

        if (field.get(stepPoint[0],stepPoint[1]).equals(Constant.DEFAULT_CHARACTER)) {
            field.set(stepPoint[0],stepPoint[1],stepLetter);
        } else {
            System.out.println("Нельзя поставить ход на одно и то же место дважды !");
        }

        System.out.println(field);
    }
}
