package com.github.martinfrank.mdga;

public enum FieldIdentifier {

    RED_START_0("A0000"), RED_START_1("A0001"),
    RED_START_2("A0002"), RED_START_3("A0003"),
    RED_ENTRANCE("A0004"), RED_EXIT("A0005"),
    RED_HOUSE_0("A0006"), RED_HOUSE_1("A0007"),
    RED_HOUSE_2("A0008"), RED_HOUSE_3("A0009"),

    GREEN_START_0("B0000"), GREEN_START_1("B0001"),
    GREEN_START_2("B0002"), GREEN_START_3("B0003"),
    GREEN_ENTRANCE("B0004"), GREEN_EXIT("B0005"),
    GREEN_HOUSE_0("B0006"), GREEN_HOUSE_1("B0007"),
    GREEN_HOUSE_2("B0008"), GREEN_HOUSE_3("B0009"),

    BLUE_START_0("C0000"), BLUE_START_1("C0001"),
    BLUE_START_2("C0002"), BLUE_START_3("C0003"),
    BLUE_ENTRANCE("C0004"), BLUE_EXIT("C0005"),
    BLUE_HOUSE_0("C0006"), BLUE_HOUSE_1("C0007"),
    BLUE_HOUSE_2("C0008"), BLUE_HOUSE_3("C0009"),

    YELLOW_START_0("D0000"), YELLOW_START_1("D0001"),
    YELLOW_START_2("D0002"), YELLOW_START_3("D0003"),
    YELLOW_ENTRANCE("D0004"), YELLOW_EXIT("D0005"),
    YELLOW_HOUSE_0("D0006"), YELLOW_HOUSE_1("D0007"),
    YELLOW_HOUSE_2("D0008"), YELLOW_HOUSE_3("D0009"),

    FIELD_00("F0000"), FIELD_01("F0001"), FIELD_02("F0002"),
    FIELD_03("F0003"), FIELD_04("F0004"), FIELD_05("F0005"),
    FIELD_06("F0006"), FIELD_07("F0007"), FIELD_08("F0008"),
    FIELD_09("F0009"), FIELD_10("F0010"), FIELD_11("F0011"),
    FIELD_12("F0012"), FIELD_13("F0013"), FIELD_14("F0014"),
    FIELD_15("F0015"), FIELD_16("F0016"), FIELD_17("F0017"),
    FIELD_18("F0018"), FIELD_19("F0019"), FIELD_20("F0020"),
    FIELD_21("F0021"), FIELD_22("F0022"), FIELD_23("F0023"),
    FIELD_24("F0024"), FIELD_25("F0025"), FIELD_26("F0026"),
    FIELD_27("F0027"), FIELD_28("F0028"), FIELD_29("F0029"),
    FIELD_30("F0030"), FIELD_31("F0031");

    static final FieldIdentifier[] RED_START = {FieldIdentifier.RED_START_0, FieldIdentifier.RED_START_1, FieldIdentifier.RED_START_2, FieldIdentifier.RED_START_3};
    static final FieldIdentifier[] GREEN_START = {FieldIdentifier.GREEN_START_0, FieldIdentifier.GREEN_START_1, FieldIdentifier.GREEN_START_2, FieldIdentifier.GREEN_START_3};
    static final FieldIdentifier[] BLUE_START = {FieldIdentifier.BLUE_START_0, FieldIdentifier.BLUE_START_1, FieldIdentifier.BLUE_START_2, FieldIdentifier.BLUE_START_3};
    static final FieldIdentifier[] YELLOW_START = {FieldIdentifier.YELLOW_START_0, FieldIdentifier.YELLOW_START_1, FieldIdentifier.YELLOW_START_2, FieldIdentifier.YELLOW_START_3};

    static final FieldIdentifier[] RED_HOUSE = {FieldIdentifier.RED_HOUSE_0, FieldIdentifier.RED_HOUSE_1, FieldIdentifier.RED_HOUSE_2, FieldIdentifier.RED_HOUSE_3};
    static final FieldIdentifier[] GREEN_HOUSE = {FieldIdentifier.GREEN_HOUSE_0, FieldIdentifier.GREEN_HOUSE_1, FieldIdentifier.GREEN_HOUSE_2, FieldIdentifier.GREEN_HOUSE_3};
    static final FieldIdentifier[] BLUE_HOUSE = {FieldIdentifier.BLUE_HOUSE_0, FieldIdentifier.BLUE_HOUSE_1, FieldIdentifier.BLUE_HOUSE_2, FieldIdentifier.BLUE_HOUSE_3};
    static final FieldIdentifier[] YELLOW_HOUSE = {FieldIdentifier.YELLOW_HOUSE_0, FieldIdentifier.YELLOW_HOUSE_1, FieldIdentifier.YELLOW_HOUSE_2, FieldIdentifier.YELLOW_HOUSE_3};


    private final String token;

    FieldIdentifier(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
