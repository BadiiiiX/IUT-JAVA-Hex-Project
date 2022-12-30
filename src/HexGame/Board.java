package HexGame;

import HexGame.Managers.*;
import Structure.Tuple;

import java.util.ArrayList;

public class Board {

    public static final int MAX_SIZE_LIMIT = 11;
    public static final int MIN_SIZE_LIMIT = 3;

    public Board() {
        int size = GameManager.getHexSize();

        this.initBoard(size);
    }

    private void initBoard(int size) {
        ArrayList<Tuple<Integer>> cells;

        cells = CellManager.generate(size);
        CellCollectionManager.init(size, cells);

        PlayerManager.init();
        BoardManager.generate(size);
    }

    public void play() {
        GameManager.play();
        PlayerManager.changeRound();
    }

    public Player checkWinner() {
        return GameManager.checkWinner();
    }

    public void show() {
        BoardManager.show();
    }

}
