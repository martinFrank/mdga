package com.github.martinfrank.mdga;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player implements Participant {

    private static final Logger LOGGER = LoggerFactory.getLogger(Player.class);

    private final List<Figurine> figurines;
    private final PlayerColor color;
    private final Mdga game;
    private final Board board;
    private final Die die;

    public Player(PlayerColor color, Mdga game, Board board) {
        this.color = color;
        figurines = IntStream.rangeClosed(1, 4).mapToObj(i -> new Figurine(color, i))
                .collect(Collectors.toList());
        this.game = game;
        this.board = board;
        die = new Die(); //FIXME inject Random
    }

    @Override
    public List<Figurine> getFigurines() {
        return figurines;
    }

    public PlayerColor getColor() {
        return color;
    }

    @Override
    public void notifyTurnStart() {
        //intentially left empty!
    }

    Die getDie() {
        return die;
    }

    Board getBoard() {
        return board;
    }

    Mdga getGame() {
        return game;
    }
}
