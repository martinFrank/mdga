package com.github.martinfrank.mdga;

import java.util.Random;

public class Die {

    public static final int SIX = 6;
    private final Random random = new Random();
    private int result;

    public int roll() {
        result = random.nextInt(6) + 1;
        return result;
    }

    public int getResult() {
        return result;
    }

    public boolean isSix() {
        return result == 6;
    }
}
