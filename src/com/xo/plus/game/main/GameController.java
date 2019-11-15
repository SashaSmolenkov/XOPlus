package com.xo.plus.game.main;

import com.xo.plus.data.Constant;
import com.xo.plus.data.Field;
import com.xo.plus.data.Game;
import com.xo.plus.game.singleplayer.ComputerController;
import com.xo.plus.viewer.ConsoleView;
import com.xo.plus.viewer.SwingView;

public abstract class GameController {
    protected GameWinController winController;
    protected StepController stepController;
    protected ConsoleView consoleView;
    protected ComputerController computerController;
    protected SwingView swingView;
    protected Field field;
    protected Game game;

    public GameController(ConsoleView consoleView, SwingView swingView) {
        winController = new GameWinController();
        stepController = new StepController();
        computerController = new ComputerController();
        field = new Field();

        if (Constant.INTERFACE.equals("console")) {
            this.consoleView = consoleView;
        } else if (Constant.INTERFACE.equals("swing")) {
            this.swingView = swingView;
        }
    }

    public void start() {
        if (consoleView != null) {
            game = consoleView.getGame();
        }
        if (swingView != null) {
            game = swingView.getGame();
        }
        while (true) {
            try {
                if ((!winController.getWin(field).isWon()) &&
                        (!field.isFull())) {
                    update();
                } else {
                    break;
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.out.println(field);
            }

        }
        end();
    }

    protected abstract void update() throws Exception;

    protected void end() {
        try {
            if (consoleView != null) {
                consoleView.endInterface(winController.getWin(field), field);
            }
            if (swingView != null) {
                swingView.endInterface(winController.getWin(field), field);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
