package com.xo.plus.game.multiplayer;

import com.xo.plus.data.Constant;
import com.xo.plus.data.Field;
import com.xo.plus.data.Game;
import com.xo.plus.game.main.GameWinController;
import com.xo.plus.game.main.StepController;
import com.xo.plus.viewer.ConsoleView;
import com.xo.plus.viewer.SwingView;

public class MultiplayerGameController {
    private GameWinController winController;
    private StepController stepController;
    private ConsoleView consoleView;
    private SwingView swingView;
    private Field field;
    private Game game;

    public MultiplayerGameController() {
        winController = new GameWinController();
        stepController = new StepController();
        field = new Field();

        if (Constant.INTERFACE.equals("console")) {
            consoleView = new ConsoleView();
        } else if (Constant.INTERFACE.equals("swing")) {
            swingView = new SwingView();
        }
    }

    public void start() {
        if (consoleView != null) {
            consoleView.startInterface();
            game = consoleView.getGame();
        }
        if (swingView != null) {
            swingView.startInterface();
            game = swingView.getGame();
        }
        while (!winController.getWin(field).isWon() || !field.isFull()) update();
        end();
    }

    public void update() {
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

        field.printOnScreen();
    }

    public void end() {
        if (consoleView != null) {
            consoleView.endInterface(winController.getWin(field),field);
        }
        if (swingView != null) {
            //swingView.endInterface(winController.getWin(field));
        }
    }
}
