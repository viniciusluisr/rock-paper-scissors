package com.rps.game.player;

import com.rps.game.action.GameOption;

public interface Player {
	
	GameOption play();
	GameOption getGameOption();
	String type();
	
	static Player human() {
        return new HumanPlayer();
    }
	
	static Player computer() {
		return new ComputerPlayer();
	}
    
}