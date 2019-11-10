package com.xo.plus.game.exceptions;

public class IncorrectIndexException extends Exception {
    private String error = "XO Error 01 : incorrect index typed.";
    public IncorrectIndexException() {

    }

    public String getError() {
        return this.error;
    }
}
