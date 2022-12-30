import HexGame.Board;
import HexGame.Player;
import HexGame.PlayerColor;
import Prompt.PromptManager;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        Player player;

        while((player = board.checkWinner()) == null) {

            board.play();
            board.show();
            System.out.println("------------------------------");

        }

        System.out.println("Le gagnant est : " + player.showPlayer());
    }
}