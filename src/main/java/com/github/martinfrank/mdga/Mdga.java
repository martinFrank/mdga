package com.github.martinfrank.mdga;

import java.util.ArrayList;
import java.util.List;

public class Mdga {

    private final Board board = new Board();
    private final List<Participant> participants = new ArrayList<>();
    private int currentPlayerIndex;

    public void setup(MdgaSetup setup) {
        participants.clear();
        board.clear();
        createPlayers(setup);
    }

    private void createPlayers(MdgaSetup setup) {
        for (ParticipantTemplate template : setup.getParticipants()) {
            Participant player = template.isAiPlayer() ?
                    new AiPlayer(template.getColor(), this, board) :
                    new Player(template.getColor(), this, board);
            board.setupStart(player.getFigurines());
            participants.add(player);
        }
    }

    public void reStart() {
        //FIXME not a start routine!
//        Player player = players.get(0);
//        Figurine figurine = player.getFigurines().get(0);
//        Field start = board.getField(FieldType.A_ENTRANCE);
//        board.moveTo(figurine, start);
    }

    public void changePlayer() {
        //FIXME now its just player 0 and no game logic (just walking)
        currentPlayerIndex = currentPlayerIndex + 1;
        if (currentPlayerIndex == participants.size()) {
            currentPlayerIndex = 0;
        }
        participants.get(currentPlayerIndex).notifyTurnStart();
    }

    public Board getBoard() {
        return board;
    }

}
