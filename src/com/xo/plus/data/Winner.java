package com.xo.plus.data;

public class Winner {
    private boolean isWon;
    private String who;

    public Winner(boolean isWon, String who) {
        this.isWon = isWon;
        this.who = who;
    }

    public boolean isWon() {
        return isWon;
    }

    public String getWinner() {
        return who;
    }

    public void setWinner(String winner) {
        this.who = winner;
    }

    public void setWon(boolean won) {
        this.isWon = won;
    }
}
