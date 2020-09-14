package com.github.martinfrank.mdga;

public class Field {

    private final FieldIdentifier identifier;
    private Figurine figurine;

    public Field(FieldIdentifier identifier) {
        this.identifier = identifier;
    }

    public FieldIdentifier getIdentifier() {
        return identifier;
    }

    public void setFigurine(Figurine figurine) {
        this.figurine = figurine;
    }

    public Figurine getFigurine() {
        return figurine;
    }

    public void removeFigurine() {
        figurine = null;
    }

    public boolean isEmpty() {
        return figurine == null;
    }
}
