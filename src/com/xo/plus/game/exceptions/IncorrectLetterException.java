package com.xo.plus.game.exceptions;

public class IncorrectLetterException extends Exception{
    private String error = "XO Error 02 : incorrect letter typed (not X, O or N).";
    public IncorrectLetterException() {

    }

    public String getError() {
        return this.error;
    }
}
