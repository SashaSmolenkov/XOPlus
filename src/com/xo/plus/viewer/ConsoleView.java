package com.xo.plus.viewer;

import com.xo.plus.data.Constant;
import com.xo.plus.data.Field;
import com.xo.plus.data.Game;
import com.xo.plus.data.Winner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView implements InterfaceControl {
    private Scanner scanner;
    private Game game;

    public ConsoleView() {
        scanner = new Scanner(System.in);
        game = new Game();
    }

    @Override
    public String startInterface() {
        System.out.println("Добро пожаловать в крестики-нолики плюс!");
        String gm = gameModeDialog();
        String name1;
        String name2;
        if (gm.equals("multiplayer")) {
            name1 = nameDialog("X");
            name2 = nameDialog("O");
            game.load(name1,name2,gm);
        } else {
            name1 = nameDialog("X");
            game.load(name1, Constant.COMPUTER_NAME,gm);
        }

        return gm;
    }


    @Override
    public void endInterface(Winner winner, Field field) {
        if (field.isFull()) {
            System.out.println("Ничья!");
            return;
        }

        System.out.println("Выиграл игрок " + winner.getWinner() + "! Удачи");
    }

    public Game getGame() {
        return game;
    }

    public String gameModeDialog() {
        System.out.print("Перед началом игры нужно выбрать игровой режим :\n" +
                "Одиночная игра против компьютера ( введите 1 ) или\n" +
                "Игра один на один ( введите 0 )    ВВОД - ");

        int num = scanner.nextInt();

        if (num != 0 && num != 1) {
            gameModeDialog();
        }

        if (num == 0) {
            return "multiplayer";
        } else if (num == 1) {
            return "singleplayer";
        }

        return null;
    }

    private String nameDialog(String playerLetter) {
        System.out.print("Введите имя игрока " + playerLetter + " - ");
        return scanner.next();
    }

    private int[] stepDialog(String playerName)
    throws Exception
    {
        System.out.println("Ход игрока " + playerName + " - введите координаты (X Y) : ");
        int x = -1;
        int y = -1;

        try {
            x = scanner.nextInt();
            y = scanner.nextInt();
        } catch (InputMismatchException ex) {
            scanner.reset();
            scanner = new Scanner(System.in);
            throw new Exception("Неправильный ввод - введите два числа через перевод строки (Пример : 2 1)");
        }

        if (x < 1 || x > Constant.FIELD_SIZE || y < 1 || y > Constant.FIELD_SIZE) {
            throw new Exception("Неправильный ввод - введите два числа через перевод строки (Пример : 2 1)");
            //stepDialog(playerName);
        }
        return new int[] {y - 1,x - 1};
    }
    @Override
    public int[] update(String playerName)
    throws Exception
    {
        return stepDialog(playerName);
    }

}
