package com.github.martinfrank.mdga;

import java.util.List;

public interface Participant {

    void notifyTurnStart();

    List<Figurine> getFigurines();

}
