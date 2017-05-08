package com.rps.game.action;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum GameOption {
	
	ROCK("R"),
	PAPER("P"),
	SCISSORS("S");

	private final String opt;
	
	private static final List<GameOption> VALUES = Arrays.asList(values());
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	GameOption(final String opt) {
		this.opt = opt;
	}
	
	public static GameOption randomize() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

	public String getOpt() {
		return opt;
	}
}