package HexGame.Managers;

import Structure.Tuple;

import java.util.ArrayList;

public class CellManager {

    private static final ArrayList<Tuple<Integer>> cells = new ArrayList<>();

    public static ArrayList<Tuple<Integer>> generate(int size) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                CellManager.cells.add(new Tuple<>(x, y));
            }
        }

        return cells;
    }

}
