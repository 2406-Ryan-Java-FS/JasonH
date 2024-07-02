package Models;

public enum ClubType {
    DRIVER("Driver"),
    TWO_WOOD("2-Wood"),
    THREE_WOOD("3-Wood"),
    FOUR_WOOD("4-Wood"),
    FIVE_WOOD("5-Wood"),
    SIX_WOOD("6-Wood"),
    SEVEN_WOOD("7-Wood"),
    TWO_IRON("2-Iron"),
    THREE_IRON("3-Iron"),
    FOUR_IRON("4-Iron"),
    FIVE_IRON("5-Iron"),
    SIX_IRON("6-Iron"),
    SEVEN_IRON("7-Iron"),
    EIGHT_IRON("8-Iron"),
    NINE_IRON("9-Iron"),
    P_WEDGE("P-Wedge"),
    S_WEDGE("S-Wedge"),
    PUTTER("Putter");

    private final String name;

    ClubType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
