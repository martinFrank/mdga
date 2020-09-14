package com.github.martinfrank.mdga;

public class Figurine {

    private final PlayerColor color;
    private final int number;

    public Figurine(PlayerColor color, int number) {
        this.color = color;
        this.number = number;
    }

    public PlayerColor getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Figurine{" +
                "color=" + color +
                ", number=" + number +
                '}';
    }
}
