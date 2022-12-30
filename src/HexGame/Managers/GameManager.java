package HexGame.Managers;

import HexGame.Player;
import HexGame.PlayerColor;
import Prompt.PromptManager;
import Structure.Tuple;

import java.util.ArrayList;

public class GameManager {

    private static Tuple<Integer> getSelectedCell() {
        return PromptManager.getSelectedCell();
    }

    public static Player checkWinner() {
        if (CellCollectionManager.isRedLinked()) return PlayerManager.getRedPlayer();
        if (CellCollectionManager.isBlueLinked()) return PlayerManager.getBluePlayer();
        return null;
    }

    public static int getHexSize() {
        return PromptManager.getHexSize();
    }

    public static void play() {
        Player player = PlayerManager.getActual();

        PromptManager.callActualPlayer(player);

        Tuple<Integer> cell = GameManager.getSelectedCell();


        System.out.println(cell);

        while(BoardManager.hasErrorInIndexes(cell.firstItem(), cell.secondItem()) || !BoardManager.isCellEmpty(cell.firstItem(), cell.secondItem())) {
            cell = GameManager.getSelectedCell();
        }

        BoardManager.set(cell.firstItem(), cell.secondItem(), player);

        GameManager.linkToNeighbor(cell, player);
    }

    private static void linkToNeighbor(Tuple<Integer> item, Player player) {
        ArrayList<Tuple<Integer>> neighborCellList = BoardManager.getNeighbors(item.firstItem(), item.secondItem());

        for (Tuple<Integer> neighbor : neighborCellList) {

            if (BoardManager.hasErrorInIndexes(neighbor.firstItem(), neighbor.secondItem())) continue;

            Player neighborCell = BoardManager.get(neighbor);
            if (neighborCell == null || !(neighborCell.equals(player))) continue;

            if (PlayerManager.isActualRed()) {
                CellCollectionManager.linkToRed(neighbor, item);
            } else {
                CellCollectionManager.linkToBlue(neighbor, item);
            }
        }
    }

}
