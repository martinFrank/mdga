package com.github.martinfrank.mdga;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class BoardTest {

    private final BoardPrinter boardPrinter;

    public BoardTest() throws IOException {
        boardPrinter = new BoardPrinter();
    }


    @Test
    public void testHasFiguresInGame_afterSetup() {
        //given
        Board board = new Board();
        Player player = new Player(PlayerColor.RED, null, board);

        //when
        board.setupStart(player.getFigurines());

        //then
        Assert.assertFalse(board.hasFiguresInGame(player.getFigurines()));

        //addition, when (one figure leaves start)
        board.enter(player.getFigurines().get(0));
        int i = 0;
        boardPrinter.print(board);

        //then
        Assert.assertTrue(board.hasFiguresInGame(player.getFigurines()));
    }

    @Test
    public void testHasFiguresInGame_withOneInHouse() throws IOException {
        //given
        Board board = new Board();
        Player player = new Player(PlayerColor.RED, null, board);

        //when (figure is one from final position)
        board.setupStart(player.getFigurines());
        board.enter(player.getFigurines().get(0));
        board.move(player.getFigurines().get(0), 42);

        //then
        Assert.assertTrue(board.hasFiguresInGame(player.getFigurines()));

        //additional when (it is in final position)
        board.move(player.getFigurines().get(0), 1);

        //then
        Assert.assertFalse(board.hasFiguresInGame(player.getFigurines()));
        boardPrinter.print(board);
    }

    @Test
    public void testHasFiguresInGame_withTwoInHouse() throws IOException {
        //given
        Board board = new Board();
        Player player = new Player(PlayerColor.RED, null, board);

        //when (figure is one from final position)
        board.setupStart(player.getFigurines());
        board.enter(player.getFigurines().get(0));
        board.move(player.getFigurines().get(0), 43);

        board.enter(player.getFigurines().get(1));
        board.move(player.getFigurines().get(1), 41);

        boardPrinter.print(board);


        //then
        Assert.assertTrue(board.hasFiguresInGame(player.getFigurines()));

        //additional when (it is in final position)
        board.move(player.getFigurines().get(1), 1);

        //then
        Assert.assertFalse(board.hasFiguresInGame(player.getFigurines()));
        boardPrinter.print(board);
    }

}
