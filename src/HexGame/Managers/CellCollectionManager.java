package HexGame.Managers;

import Structure.DisjointSet;
import Structure.Tuple;

import java.util.ArrayList;
import java.util.Collections;

public class CellCollectionManager {

    private static final DisjointSet<Tuple<Integer>> dsRedSide  = new DisjointSet<>();
    private static final DisjointSet<Tuple<Integer>> dsBlueSide = new DisjointSet<>();

    private static Tuple<Integer> topVirtualNode;
    private static Tuple<Integer> bottomVirtualNode;
    private static Tuple<Integer> leftVirtualNode;
    private static Tuple<Integer> rightVirtualNode;

    public static void init(int size, ArrayList<Tuple<Integer>> cells) {
        fillVirtualNodes(size);
        createCells(cells);
        linkVirtualNodeToSideBoard(size);
    }

    private static void fillVirtualNodes(int size) {
        topVirtualNode = new Tuple<>(-1, 0);
        bottomVirtualNode = new Tuple<>(size, 0);
        leftVirtualNode = new Tuple<>(0, -1);
        rightVirtualNode = new Tuple<>(0, size);
    }

    private static void createCells(ArrayList<Tuple<Integer>> cells) {
        ArrayList<Tuple<Integer>> redSideSet  = new ArrayList<>(cells);
        ArrayList<Tuple<Integer>> blueSideSet = new ArrayList<>(cells);

        Collections.addAll(redSideSet, topVirtualNode, bottomVirtualNode);
        Collections.addAll(blueSideSet, leftVirtualNode, rightVirtualNode);

        dsRedSide.makeSet(redSideSet);
        dsBlueSide.makeSet(blueSideSet);
    }

    private static void linkVirtualNodeToSideBoard(int size) {
        for (int i = 0; i < size; i++) {
            dsRedSide.union(new Tuple<>(0, i), topVirtualNode);
            dsRedSide.union(new Tuple<>(size - 1, i), bottomVirtualNode);
            dsBlueSide.union(new Tuple<>(i, 0), leftVirtualNode);
            dsBlueSide.union(new Tuple<>(i, size - 1), rightVirtualNode);
        }
    }

    public static void linkToRed(Tuple<Integer> neighbor, Tuple<Integer> actualCell) {
        dsRedSide.union(neighbor, actualCell);
    }

    public static void linkToBlue(Tuple<Integer> neighbor, Tuple<Integer> actualCell) {
        dsBlueSide.union(neighbor, actualCell);
    }

    public static boolean isRedLinked() {
        return dsRedSide.find(topVirtualNode).equals(dsRedSide.find(bottomVirtualNode));
    }

    public static boolean isBlueLinked() {
        return dsBlueSide.find(leftVirtualNode).equals(dsBlueSide.find(rightVirtualNode));
    }
}
