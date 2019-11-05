package com.xo.plus.viewer;

import com.xo.plus.data.Field;
import com.xo.plus.data.Game;
import com.xo.plus.data.Winner;

public class SwingView implements InterfaceControl {
    private Game game;

    public SwingView() {
        game = new Game();
    }

    @Override
    public void startInterface() {

    }

    @Override
    public int[] update(String playerName) {
        return null;
    }

    @Override
    public void endInterface(Winner winner, Field field) {

    }

    public Game getGame() {
        return game;
    }
}
