package com.rps.game.manager;

import com.rps.game.action.GameOption;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static com.rps.game.action.GameOption.PAPER;
import static com.rps.game.action.GameOption.ROCK;
import static com.rps.game.action.GameOption.SCISSORS;

public class Judge implements Comparator<GameOption> {

    private static Map<GameOption, Map<GameOption, Integer>> config;

    static {

        Map<GameOption, Integer> rock = new HashMap<>();
        rock.put(ROCK, 0);
        rock.put(PAPER, -1);
        rock.put(SCISSORS, 1);

        Map<GameOption, Integer> paper = new HashMap<>();
        paper.put(ROCK, 1);
        paper.put(PAPER, 0);
        paper.put(SCISSORS, -1);

        Map<GameOption, Integer> scissors = new HashMap<>();
        scissors.put(ROCK, -1);
        scissors.put(PAPER, 1);
        scissors.put(SCISSORS, 0);

        Map<GameOption, Map<GameOption, Integer>> tmp = new HashMap<>();
        tmp.put(ROCK, rock);
        tmp.put(PAPER, paper);
        tmp.put(SCISSORS, scissors);

        config = Collections.unmodifiableMap(tmp);
    }

    @Override
    public int compare(GameOption o1, GameOption o2) {
        return config.get(o1).get(o2);
    }
}
