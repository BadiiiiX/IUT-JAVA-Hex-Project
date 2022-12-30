package HexGame;

import java.util.Objects;

public record Player(String name, PlayerColor color) {

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND   = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND  = "\u001B[44m";
    public static final String ANSI_RESET            = "\u001B[0m";

    public String showPlayer() {

        return this.name;

    }

    @Override
    public String toString() {
        return switch (this.color()) {
            case RED -> ANSI_RED_BACKGROUND + "  " + ANSI_RESET;
            case BLUE -> ANSI_BLUE_BACKGROUND + "  " + ANSI_RESET;
            default -> ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return this.color() == player.color();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.color());
    }
}
