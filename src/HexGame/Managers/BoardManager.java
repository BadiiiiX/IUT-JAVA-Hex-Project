package HexGame.Managers;

import HexGame.Player;
import HexGame.PlayerColor;
import Structure.Tuple;

import java.util.ArrayList;
import java.util.Collections;

public class BoardManager {

    private static final ArrayList<ArrayList<Player>> board = new ArrayList<>();
    private static       int                          size  = -1;

    public static void generate(int s) {
        BoardManager.size = s;
        for (int x = 0; x < size; x++) {
            board.add(x, new ArrayList<>());

            for (int y = 0; y < size; y++) {
                board.get(x).add(new Player("", PlayerColor.UNCOLORED));
            }
        }
    }

    public static Player get(int idxX, int idxY) {
        return board.get(idxX).get(idxY);
    }

    public static Player get(Tuple<Integer> tuple) {
        return get(tuple.firstItem(), tuple.secondItem());
    }

    public static void set(int idxX, int idxY, Player player) {
        board.get(idxX).set(idxY, player);
    }

    public static boolean isCellEmpty(int idxX, int idxY) {
        return get(idxX, idxY).color() == PlayerColor.UNCOLORED;
    }

    public static boolean hasErrorInIndexes(int... indexes) {
        for (int idx : indexes) {
            if (idx < 0 || idx >= size) {
                return true;
            }
        }

        return false;
    }

    public static ArrayList<Tuple<Integer>> getNeighbors(int idxX, int idxY) {
        ArrayList<Tuple<Integer>> cellList = new ArrayList<>();
        Collections.addAll(cellList, new Tuple<>(idxX + 1, idxY), new Tuple<>(idxX + 1, idxY - 1), new Tuple<>(idxX, idxY + 1), new Tuple<>(idxX, idxY - 1), new Tuple<>(idxX - 1, idxY), new Tuple<>(idxX - 1, idxY + 1));

        return cellList;
    }

    public static void show() {

        System.out.print(" |  ");
        for (int letters = 0; letters < size; letters++) {
            char letter = 'A';
            System.out.print("  " + (char) (letter + letters) + "  ");
        }
        System.out.println();

        for (int line = 0; line < size; line++) {
            System.out.print("------");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {

            System.out.print(i + 1 + "| ");

            for (int l = 0; l < i; l++) {
                System.out.print("  ");
            }

            for (int j = 0; j < size; j++) {
                System.out.print("  " + get(i, j) + " ");
            }

            System.out.println();
        }
    }

}
