package com.github.martinfrank.mdga;

import java.util.*;
import java.util.stream.Collectors;


public class Board {

    private final List<Field> fields;
    private final Map<PlayerColor, List<Field>> startFields = new HashMap<>();
    private final Map<PlayerColor, List<Field>> houseFields = new HashMap<>();

    private final Map<PlayerColor, Field> entranceFields = new HashMap<>();

    public Board() {
        fields = Arrays.stream(FieldIdentifier.values()).map(Field::new).collect(Collectors.toList());

        startFields.put(PlayerColor.RED, getFields(Arrays.asList(FieldIdentifier.RED_START)));
        startFields.put(PlayerColor.GREEN, getFields(Arrays.asList(FieldIdentifier.GREEN_START)));
        startFields.put(PlayerColor.BLUE, getFields(Arrays.asList(FieldIdentifier.BLUE_START)));
        startFields.put(PlayerColor.YELLOW, getFields(Arrays.asList(FieldIdentifier.YELLOW_START)));

        houseFields.put(PlayerColor.RED, getFields(Arrays.asList(FieldIdentifier.RED_HOUSE)));
        houseFields.put(PlayerColor.GREEN, getFields(Arrays.asList(FieldIdentifier.GREEN_HOUSE)));
        houseFields.put(PlayerColor.BLUE, getFields(Arrays.asList(FieldIdentifier.BLUE_HOUSE)));
        houseFields.put(PlayerColor.YELLOW, getFields(Arrays.asList(FieldIdentifier.YELLOW_HOUSE)));

        entranceFields.put(PlayerColor.RED, getField(FieldIdentifier.RED_ENTRANCE));
        entranceFields.put(PlayerColor.GREEN, getField(FieldIdentifier.GREEN_ENTRANCE));
        entranceFields.put(PlayerColor.BLUE, getField(FieldIdentifier.BLUE_ENTRANCE));
        entranceFields.put(PlayerColor.YELLOW, getField(FieldIdentifier.YELLOW_ENTRANCE));
    }

    private List<Field> getFields(List<FieldIdentifier> types) {
        return fields.stream().filter(f -> types.contains(f.getIdentifier())).collect(Collectors.toList());
    }

    private Field getField(FieldIdentifier identifier) {
        return fields.stream().filter(f -> f.getIdentifier() == identifier).findAny()
                .orElseThrow(() -> new IllegalArgumentException("cannot find field " + identifier));
    }

    public List<Field> getFields() {
        return fields;
    }

    public void clear() {
        fields.forEach(Field::removeFigurine);
    }

    public void setupStart(List<Figurine> playersFigures) {
        playersFigures.forEach(this::sendToStart);
    }

    public void enter(Figurine figurine) {
        Field entrance = entranceFields.get(figurine.getColor());
        moveTo(figurine, entrance);
    }

    public boolean canEnter(Figurine figurine) {
        Field entrance = entranceFields.get(figurine.getColor());
        Figurine target = entrance.getFigurine();
        return target == null || target.getColor() != figurine.getColor();
    }

    public Figurine getFigureAtMove(Figurine figurine, int steps) {
        Field to = getField(getWalkPath(figurine, steps).getLast());
        return to.getFigurine();
    }

    public void move(Figurine figurine, int steps) {
        Field to = getField(getWalkPath(figurine, steps).getLast());
        moveTo(figurine, to);
    }

    public boolean canMove(Figurine figurine, int steps) {
        try {
            LinkedList<FieldIdentifier> path = getWalkPath(figurine, steps);
            Figurine target = getField(path.getLast()).getFigurine();
            return target == null || target.getColor() != figurine.getColor();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean hasFiguresInGame(List<Figurine> figures) {
        PlayerColor color = figures.get(0).getColor();
        int inStart = countFiguresInStart(color, figures);
        if (inStart == figures.size()) {
            return false;
        }
        int remainders = figures.size() - inStart;
        return !isHouseFilledUp(color, figures, remainders);
    }

    private boolean isHouseFilledUp(PlayerColor color, List<Figurine> figures, int remainders) {
        List<Field> houses = new ArrayList<>(houseFields.get(color));
        Collections.reverse(houses);
        for (int i = 0; i < remainders; i++) {
            if (houses.get(i).getFigurine() == null) {
                return false;
            }
        }
        return true;
    }

    private int countFiguresInStart(PlayerColor color, List<Figurine> figures) {
        List<Field> starts = startFields.get(color);
        int inStart = 0;
        for (Figurine figurine : figures) {
            Field figurineField = getField(figurine);
            if (starts.contains(figurineField)) {
                inStart = inStart + 1;
            }
        }
        return inStart;
    }


    public boolean isInStart(Figurine candidate) {
        return startFields.get(candidate.getColor()).contains(getField(candidate));
    }

    private Field getField(Figurine figurine) {
        return fields.stream().filter(f -> figurine.equals(f.getFigurine())).findAny()
                .orElseThrow(() -> new IllegalArgumentException("cannot find field for figurine" + figurine));
    }

    private void moveTo(Figurine figurine, Field target) {
        Field from = getField(figurine);
        from.removeFigurine();
        Figurine candidate = target.getFigurine();
        target.setFigurine(figurine);
        if (candidate != null) {
            sendToStart(candidate);
        }
    }

    private void sendToStart(Figurine candidate) {
        for (Field field : startFields.get(candidate.getColor())) {
            if (field.isEmpty()) {
                field.setFigurine(candidate);
                break;
            }
        }
    }

    private LinkedList<FieldIdentifier> getWalkPath(Figurine figurine, int steps) {
        FieldIdentifier field = getField(figurine).getIdentifier();
        PlayerColor color = figurine.getColor();
        return WalkPath.getWalkPath(color, field, steps);
    }


    public boolean isInHouse(PlayerColor color) {
        for (Field field : houseFields.get(color)) {
            if (field.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
