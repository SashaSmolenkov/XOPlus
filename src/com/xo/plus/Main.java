package com.xo.plus;

import com.xo.plus.game.multiplayer.MultiplayerGameController;
import com.xo.plus.game.singleplayer.SingleplayerGameController;
import com.xo.plus.viewer.ConsoleView;
import com.xo.plus.viewer.SwingView;

public class Main {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        String gm = consoleView.startInterface();

        if (gm.equals("multiplayer")) {
            new MultiplayerGameController(consoleView, new SwingView()).start();
        } else {
            new SingleplayerGameController(consoleView, new SwingView()).start();
        }
    }
}
