package com.xo.plus;

import com.xo.plus.data.Constant;
import com.xo.plus.game.multiplayer.MultiplayerGameController;
import com.xo.plus.game.singleplayer.SingleplayerGameController;
import com.xo.plus.viewer.ConsoleView;

public class Main {
    public static void main(String[] args) {
        String gm = new ConsoleView().gameModeDialog();
        if (gm.equals(Constant.SP_XO)) {
            new SingleplayerGameController().start();
        } else if (gm.equals(Constant.MP_XO)) {
            new MultiplayerGameController().start();
        }
    }
}
