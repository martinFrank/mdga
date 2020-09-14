package com.github.martinfrank.mdga;

import java.util.ArrayList;
import java.util.List;

public class MdgaSetup {

    public static MdgaSetup demoSetup() {
        return new MdgaSetup();
    }

    public static MdgaSetup singlePlayerSetup(int amountPlayers) {
        return new MdgaSetup();
    }

    //FIXME PlayerTemplate instead of Player (hence it could define AI etc)
    public List<ParticipantTemplate> getParticipants() {
        List<ParticipantTemplate> templates = new ArrayList<>();
        templates.add(new ParticipantTemplate(PlayerColor.RED, true));
//        players.add(new Player(PlayerName.B));
        templates.add(new ParticipantTemplate(PlayerColor.BLUE, true));
//        players.add(new Player(PlayerName.D));
        return templates;
    }

}
