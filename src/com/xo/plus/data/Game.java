package com.xo.plus.data;

public class Game {
    private String gameType;
    private String player1Name;
    private String player2Name;

    public void load(String player1Name,
                     String player2Name,
                     String gameType) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.gameType = gameType;
    }

    public boolean isMultiplayer() {
        return gameType.equals(Constant.MP_XO);
    }

    public boolean isSingleplayer() {
        return gameType.equals(Constant.SP_XO);
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }
}
