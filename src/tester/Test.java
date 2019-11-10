package tester;

import com.xo.plus.data.Field;
import com.xo.plus.data.Winner;
import com.xo.plus.game.main.GameWinController;

public class Test {

    public static void main(String[] args) {
        Field field = new Field();
        GameWinController gameWinController = new GameWinController();

    /*    field.set(0,0,"X");
        field.set(0,1,"X");
        field.set(0,2,"O");
        field.set(1,1,"O");
        field.set(2,0,"X"); */

        Winner winner = gameWinController.getWin(field);
        System.out.println(winner.isWon());
        System.out.println(winner.getWinner());
    }
}
