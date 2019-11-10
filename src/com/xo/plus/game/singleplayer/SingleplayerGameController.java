package com.xo.plus.game.singleplayer;

import com.xo.plus.data.Constant;
import com.xo.plus.data.Field;
import com.xo.plus.data.Game;
import com.xo.plus.game.exceptions.IncorrectIndexException;
import com.xo.plus.game.exceptions.IncorrectLetterException;
import com.xo.plus.game.main.GameWinController;
import com.xo.plus.game.main.StepController;
import com.xo.plus.viewer.ConsoleView;
import com.xo.plus.viewer.SwingView;

public class SingleplayerGameController {
    private GameWinController winController;
    private StepController stepController;
    private RobotController robotController;
    private ConsoleView consoleView;
    private SwingView swingView;
    private Field field;
    private Game game;

    public SingleplayerGameController() {
        winController = new GameWinController();
        stepController = new StepController();
        robotController = new RobotController();
        field = new Field();

        if (Constant.INTERFACE.equals("console")) {
            consoleView = new ConsoleView();
        } else if (Constant.INTERFACE.equals("swing")) {
            swingView = new SwingView();
        }
    }

    public void start() {
        if (consoleView != null) {
            consoleView.startInterface(Constant.SP_XO);
            game = consoleView.getGame();
        }
        if (swingView != null) {
            swingView.startInterface(Constant.SP_XO);
            game = swingView.getGame();
        }

        while (!field.isFull() && !winController.getWin(field).isWon()) {
            update();
        }
    }

    public void update() {
        String stepLetter = stepController.getNext(field);
        String stepName = Constant.DEFAULT_PLAYER_NAME;
        boolean isStepFromPC = false;
        int[] stepPoint;

        if (stepLetter.equals("X")) {
            stepName = game.getPlayer1Name();
        } else if (stepLetter.equals("O")) {
            stepName = Constant.COMPUTER_NAME;
            isStepFromPC = true;
        }

        if (isStepFromPC) {
            robotController.makeStep(field);
            field.printOnScreen();
            return;
        } else {
            stepPoint = consoleView.update(stepName);
            try {
                field.set(stepPoint[0],stepPoint[1],stepLetter);
            } catch (IncorrectIndexException ex) {
                System.out.println(ex.getError());

            } catch (IncorrectLetterException ex) {
                System.out.println(ex.getError());

            }
            field.printOnScreen();
        }
    }

    public void end() {
        if (consoleView != null) {
            consoleView.endInterface(winController.getWin(field),field);
        }
        if (swingView != null) {
            swingView.endInterface(winController.getWin(field),field);
        }
    }
}
