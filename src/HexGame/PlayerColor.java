package HexGame;

public enum PlayerColor {
    RED("ROUGE"),
    BLUE("BLEU"),
    UNCOLORED("NON COLORÉ");

    private final String color;

    PlayerColor(String s) {
        color = s;
    }

    @Override
    public String toString() {
        return color;
    }
}
