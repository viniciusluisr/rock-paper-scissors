package com.rps.game.action;

import java.util.Arrays;
import java.util.Scanner;

public class UserInput {

    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public MenuAction readAction() {
        final StringBuilder builder = new StringBuilder()
                .append("\n")
                .append("--------------------------------")
                .append("\n")
                .append("1 - Computer vs Human")
                .append("\n")
                .append("2 - Computer vs Computer")
                .append("\n")
                .append("Q - Quit")
                .append("\n")
                .append(": ");

        System.out.print(builder.toString());

        final String value = scanner.nextLine();
        System.out.println();

        if("1".equalsIgnoreCase(value)) {
            return MenuAction.COMPUTER_VS_HUMAN;
        }

        if("2".equalsIgnoreCase(value)) {
            return MenuAction.COMPUTER_VS_COMPUTER;
        }

        if("Q".equalsIgnoreCase(value)) {
            return MenuAction.QUIT;
        }

        return MenuAction.NONE;
    }

    public GameOption readGameOption() {
        final StringBuilder builder = new StringBuilder("\n").append("| ");
    
        Arrays.asList(GameOption.values())
                .forEach(f -> builder.append(f).append(" = ").append(f.getOpt()).append(" | "));
        
        builder.append("\n").append(": ");

        System.out.print(builder.toString());

        final String value = scanner.nextLine();
        System.out.println();

        for(GameOption figure : GameOption.values()) {
            if (figure.getOpt().equalsIgnoreCase(value)) {
                return figure;
            }
        }

        throw new IllegalArgumentException(value);
    }


    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}