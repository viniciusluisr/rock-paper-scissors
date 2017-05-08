package com.rps.game.manager;

import static java.lang.String.format;

import com.rps.game.player.Player;

public class RoundManager {

    private Judge judge;

    public RoundManager() {
        this.judge = new Judge();
    }

    public Player play(final Player player1, final Player player2) {
        while(true) {
    
            player1.play();
            player2.play();
            
            printOptions(player1, player2);

            switch (judge.compare(player1.getGameOption(), player2.getGameOption())) {

                case 1:
                    printWinner(player1);
                    return player1;

                case -1:
                    printWinner(player2);
                    return player2;

                default:
                    printDraw(player1, player2);
            }
        }
    }

    public void printWinner(final Player player) {
        System.out.println(String.format("%s having %s wins!", player.type(), player.getGameOption()));
    }

    public void printDraw(final Player player1, final Player player2) {
        System.out.println(String.format("Draw! %s - %s. Let's try one more time!", player1.getGameOption(), player2.getGameOption()));
    }

    public void printOptions(final Player player1, final Player player2) {
        System.out.println(String.format("%s %s vs %s %s", player1.type(), player1.getGameOption(), player2.type(), player2.getGameOption()));
    }

}
