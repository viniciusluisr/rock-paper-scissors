package com.rps.game.player;

import com.rps.game.action.GameOption;

public class ComputerPlayer implements Player {

    private GameOption option;
    
    @Override
    public GameOption play() {
	    this.option = GameOption.randomize();
	    return this.option;
    }
	
	@Override
	public GameOption getGameOption() {
		return this.option;
	}
	
	@Override
	public String type() {
	    return "Computer";
	}
}
