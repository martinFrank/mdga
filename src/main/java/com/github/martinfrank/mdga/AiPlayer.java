package com.github.martinfrank.mdga;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AiPlayer extends Player {

    private static final Logger LOGGER = LoggerFactory.getLogger(AiPlayer.class);

    public AiPlayer(PlayerColor color, Mdga game, Board board) {
        super(color, game, board);
    }


    @Override
    public void notifyTurnStart() {
        LOGGER.debug("starting my turn ({})", getColor());
        boolean hasFiguresInGame = getBoard().hasFiguresInGame(this.getFigurines());
        if (!hasFiguresInGame) {
            boolean hasSuccessFullyLeftStart = tryToLeaveStart();
            if (!hasSuccessFullyLeftStart) {
                //turn is now over
                return;
            }
        }

        int result;
        do {
            result = getDie().roll();
            playBestFigure(result);
        } while (result == Die.SIX || !getBoard().isInHouse(getColor()));

        if (getBoard().isInHouse(getColor())) {
            LOGGER.debug("i did it, i finished the game!!!");
        }
    }

    private void playBestFigure(int result) {
        Figurine figurine = getFigurines().get(0); //FIXME getBestResultForTatDice
        boolean canMove = getBoard().canMove(figurine, result);
        if (canMove) {
            getBoard().move(figurine, result);
        } else {
            LOGGER.debug("oooh i still cannot move");
        }
    }

    private boolean tryToLeaveStart() {
        boolean canLeaveStart = rollForStart();
        if (canLeaveStart) {
            Figurine figurine = getOneFromStart();
            LOGGER.debug("this figure will enter! {}", figurine);
            getBoard().enter(figurine);
        }
        return canLeaveStart;
    }


    private Figurine getOneFromStart() {
        for (Figurine figurine : getFigurines()) {
            if (getBoard().isInStart(figurine)) {
                return figurine;
            }
        }
        throw new IllegalStateException("no figure in start");
    }

    private boolean rollForStart() {
        for (int i = 0; i < 3; i++) {
            getDie().roll();
            int number = i + 1;
            LOGGER.debug("roll #{}: result:{}", number, getDie().getResult());
            if (getDie().isSix()) {
                LOGGER.debug("yes, i can leave!!!");
                return true;
            }
        }
        return false;
    }


}
