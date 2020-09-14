package com.github.martinfrank.mdga;

public enum PlayerColor {

    RED("R"), GREEN("G"), BLUE("B"), YELLOW("Y");

    private final String abbreviation;

    PlayerColor(String abbrevation) {
        this.abbreviation = abbrevation;
    }


    @Override
    public String toString() {
        return abbreviation;
    }
}
