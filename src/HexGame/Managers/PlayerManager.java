package HexGame.Managers;

import HexGame.Player;
import HexGame.PlayerColor;
import Prompt.PromptManager;

import java.util.Arrays;
import java.util.Random;

public class PlayerManager {

    private static final Player redPlayer  = new Player(PromptManager.getPlayerName(PlayerColor.RED), PlayerColor.RED);
    private static final Player bluePlayer = new Player(PromptManager.getPlayerName(PlayerColor.BLUE), PlayerColor.BLUE);
    private static       Player actualPlayer;

    public static void init() {
        actualPlayer = getRandomPlayer();
    }

    public static Player getActual() {
        return actualPlayer;
    }

    public static void changeRound() {
        actualPlayer = (isActualRed()) ? bluePlayer : redPlayer;
    }

    public static boolean isActualRed() {
        return actualPlayer == redPlayer;
    }

    public static boolean isActualBlue() {
        return actualPlayer == bluePlayer;
    }

    public static Player getRedPlayer() {
        return redPlayer;
    }

    public static Player getBluePlayer() {
        return bluePlayer;
    }

    private static Player getRandomPlayer() {
        int randomIndex = new Random().nextInt(2);
        return (randomIndex == 0 ? redPlayer : bluePlayer);
    }

}
