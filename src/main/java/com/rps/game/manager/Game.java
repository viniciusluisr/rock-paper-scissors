package com.rps.game.manager;

import com.rps.game.action.MenuAction;
import com.rps.game.action.UserInput;
import com.rps.game.player.Player;

public class Game {

    private RoundManager roundManager;
    private UserInput userInput;

    public Game() {
        this.roundManager = new RoundManager();
        this.userInput = new UserInput();
    }

    public void play() {
        while(true) {

            final MenuAction action = userInput.readAction();

            switch(action) {
                
                case COMPUTER_VS_COMPUTER:
                    roundManager.play(Player.computer(), Player.computer());
                    break;

                case COMPUTER_VS_HUMAN:
                    roundManager.play(Player.computer(), Player.human());
                    break;
    
                case QUIT:
                    return;

                default:
                    printInvalidActionSelected();
                    break;
            }
        }
    }

    private void printInvalidActionSelected() {
        System.out.println("Invalid selected option.");
    }

    public void setRoundManager(RoundManager roundManager) {
        this.roundManager = roundManager;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }
}
