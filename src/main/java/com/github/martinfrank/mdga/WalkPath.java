package com.github.martinfrank.mdga;

import java.util.Arrays;
import java.util.LinkedList;

import static com.github.martinfrank.mdga.FieldIdentifier.*;

public class WalkPath {

    private static final FieldIdentifier[] RED_PATH = {
            RED_ENTRANCE, FIELD_00, FIELD_01, FIELD_02, FIELD_03, FIELD_04, FIELD_05, FIELD_06, FIELD_07,
            GREEN_EXIT, GREEN_ENTRANCE, FIELD_08, FIELD_09, FIELD_10, FIELD_11, FIELD_12, FIELD_13, FIELD_14,
            FIELD_15, BLUE_EXIT, BLUE_ENTRANCE, FIELD_16, FIELD_17, FIELD_18, FIELD_19, FIELD_20, FIELD_21,
            FIELD_22, FIELD_23, YELLOW_EXIT, YELLOW_ENTRANCE, FIELD_24, FIELD_25, FIELD_26, FIELD_27, FIELD_28,
            FIELD_29, FIELD_30, FIELD_31, RED_EXIT, RED_HOUSE_0, RED_HOUSE_1, RED_HOUSE_2, RED_HOUSE_3
    };

    private static final FieldIdentifier[] GREEN_PATH = {
            GREEN_ENTRANCE, FIELD_08, FIELD_09, FIELD_10, FIELD_11, FIELD_12, FIELD_13, FIELD_14, FIELD_15,
            BLUE_EXIT, BLUE_ENTRANCE, FIELD_16, FIELD_17, FIELD_18, FIELD_19, FIELD_20, FIELD_21, FIELD_22,
            FIELD_23, YELLOW_EXIT, YELLOW_ENTRANCE, FIELD_24, FIELD_25, FIELD_26, FIELD_27, FIELD_28, FIELD_29,
            FIELD_30, FIELD_31, RED_EXIT, RED_ENTRANCE, FIELD_00, FIELD_01, FIELD_02, FIELD_03, FIELD_04,
            FIELD_05, FIELD_06, FIELD_07, GREEN_EXIT, GREEN_HOUSE_0, GREEN_HOUSE_1, GREEN_HOUSE_2, GREEN_HOUSE_3
    };

    private static final FieldIdentifier[] BLUE_PATH = {
            BLUE_ENTRANCE, FIELD_16, FIELD_17, FIELD_18, FIELD_19, FIELD_20, FIELD_21, FIELD_22, FIELD_23,
            YELLOW_EXIT, YELLOW_ENTRANCE, FIELD_24, FIELD_25, FIELD_26, FIELD_27, FIELD_28, FIELD_29, FIELD_30,
            FIELD_31, RED_EXIT, RED_ENTRANCE, FIELD_00, FIELD_01, FIELD_02, FIELD_03, FIELD_04, FIELD_05,
            FIELD_06, FIELD_07, GREEN_EXIT, GREEN_ENTRANCE, FIELD_08, FIELD_09, FIELD_10, FIELD_11, FIELD_12,
            FIELD_13, FIELD_14, FIELD_15, BLUE_EXIT, BLUE_HOUSE_0, BLUE_HOUSE_1, BLUE_HOUSE_2, BLUE_HOUSE_3

    };

    private static final FieldIdentifier[] YELLOW_PATH = {
            YELLOW_ENTRANCE, FIELD_24, FIELD_25, FIELD_26, FIELD_27, FIELD_28, FIELD_29, FIELD_30, FIELD_31,
            RED_EXIT, RED_ENTRANCE, FIELD_00, FIELD_01, FIELD_02, FIELD_03, FIELD_04, FIELD_05, FIELD_06,
            FIELD_07, GREEN_EXIT, GREEN_ENTRANCE, FIELD_08, FIELD_09, FIELD_10, FIELD_11, FIELD_12, FIELD_13,
            FIELD_14, FIELD_15, BLUE_EXIT, BLUE_ENTRANCE, FIELD_16, FIELD_17, FIELD_18, FIELD_19, FIELD_20,
            FIELD_21, FIELD_22, FIELD_23, YELLOW_EXIT, YELLOW_HOUSE_0, YELLOW_HOUSE_1, YELLOW_HOUSE_2, YELLOW_HOUSE_3
    };


    public static LinkedList<FieldIdentifier> getWalkPath(PlayerColor color, FieldIdentifier from, int steps) {
        FieldIdentifier[] path = getColoredPath(color);
        int offset = 0;
        for (FieldIdentifier candidate : path) {
            offset++;
            if (candidate == from) {
                break;
            }
        }
        if (offset + steps > path.length) {
            throw new IllegalArgumentException("steps exceeded path length");
        }
        FieldIdentifier[] subPath = new FieldIdentifier[steps];
        System.arraycopy(path, offset, subPath, 0, steps);
        return new LinkedList<>(Arrays.asList(subPath));
    }

    private static FieldIdentifier[] getColoredPath(PlayerColor color) {
        switch (color) {
            case RED:
                return RED_PATH;
            case GREEN:
                return GREEN_PATH;
            case BLUE:
                return BLUE_PATH;
            case YELLOW:
                return YELLOW_PATH;
        }
        throw new IllegalArgumentException("invalid color: " + color);
    }


}
