package com.rps.game.player;

import com.rps.game.action.GameOption;
import com.rps.game.action.UserInput;

public class HumanPlayer implements Player {

    private UserInput userInput;
    private GameOption option;

	public HumanPlayer() {
		this.userInput = new UserInput();
	}

	@Override
    public GameOption play() {
		while(true) {
			try {
				this.option = userInput.readGameOption();
				return option;
			} catch (Exception e) {
				System.out.println("Invalid ption, please try again...");
			}
		}
    }
	
	@Override
	public GameOption getGameOption() {
		return option;
	}

	@Override
	public String type() {
		return "Human";
	}
	
	public void setUserInput(UserInput userInput) {
		this.userInput = userInput;
	}
}
