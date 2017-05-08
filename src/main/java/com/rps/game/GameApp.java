package com.rps.game;

import com.rps.game.manager.Game;

/**
 * The Rock Paper Scissors game entrypoint
 */
public class GameApp
{
    public static void main( String[] args ) {
        new Game().play();
    }
}
