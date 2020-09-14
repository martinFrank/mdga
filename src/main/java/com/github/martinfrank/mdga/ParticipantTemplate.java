package com.github.martinfrank.mdga;

public class ParticipantTemplate {

    private final PlayerColor color;
    private final boolean isAiPlayer;

    public ParticipantTemplate(PlayerColor color, boolean isAiPlayer) {
        this.color = color;
        this.isAiPlayer = isAiPlayer;
    }

    public PlayerColor getColor() {
        return color;
    }

    public boolean isAiPlayer() {
        return isAiPlayer;
    }
}
