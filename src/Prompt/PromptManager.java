package Prompt;

import Exceptions.InvalidScannedValueException;
import HexGame.Board;
import HexGame.Player;
import HexGame.PlayerColor;
import Prompt.messages.CommonMessages;
import Structure.Tuple;

import java.util.Scanner;

public class PromptManager {

    private static final String  NOT_DEFINED_STRING = "";
    private static final int     NOT_DEFINED_INT    = Integer.MIN_VALUE;
    private static final Scanner scanner            = new Scanner(System.in);

    /**
     * Pour régler les bugs de mauvais input sur les méthodes getXXXx
     * Throw une custom error et la catch en faisant un syso, puis continuer le while.
     */


    public static void callActualPlayer(Player player) {
        System.out.println(CommonMessages.format(CommonMessages.CALL_NEXT_PLAYER, "PLAYER_NAME", String.valueOf(player.name())));
    }

    public static int getHexSize() {
        System.out.println(CommonMessages.format(CommonMessages.ASK_SIZE_HEX, "SIZE_LIMIT", String.valueOf(Board.MAX_SIZE_LIMIT)));

        int hexSize = askInt();

        while (hexSize <= Board.MIN_SIZE_LIMIT || hexSize > Board.MAX_SIZE_LIMIT) {
            System.out.println(CommonMessages.INVALID_VALUE);
            scanner.nextLine();
            hexSize = askInt();
        }

        return hexSize;
    }

    public static String getPlayerName(PlayerColor color) {
        System.out.println(CommonMessages.format(CommonMessages.ASK_PLAYER_NAME, "COLOR", String.valueOf(color)));

        String playerName = askLine();

        while (playerName.equals(NOT_DEFINED_STRING)) {
            System.out.println(CommonMessages.INVALID_VALUE);
            scanner.nextLine();
            playerName = askLine();
        }

        return playerName;
    }

    public static Tuple<Integer> getSelectedCell() {
        System.out.println(CommonMessages.ASK_CELL_TO_SELECT);

        String cell = askCell();
        while (cell.equals(NOT_DEFINED_STRING)) {
            System.out.println(CommonMessages.INVALID_VALUE);
            scanner.nextLine();
            cell = askCell();
        }

        final int GAP_BETWEEN_ZERO_AND_A   = 65;
        final int GAP_BETWEEN_ZERO_AND_ONE = 49;

        int letter = (int) cell.charAt(0) - GAP_BETWEEN_ZERO_AND_A;
        int number = (int) cell.charAt(1) - GAP_BETWEEN_ZERO_AND_ONE;

        if (cell.length() == 3) {
            int firstNumber  = ((int) cell.charAt(1) - GAP_BETWEEN_ZERO_AND_ONE + 1) * 10;
            int secondNumber = (int) cell.charAt(2) - GAP_BETWEEN_ZERO_AND_ONE;

            number = firstNumber + secondNumber;
        }

        return new Tuple<>(number, letter);
    }

    private static int askInt() {
        if (scanner.hasNextInt()) {
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            return scanner.nextInt();
        }

        return NOT_DEFINED_INT;
    }

    private static String askCell() {
        if (scanner.hasNextLine()) {
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String line = scanner.nextLine().toUpperCase();
            if (line.length() == 2 || line.length() == 3) {
                if (line.charAt(0) >= 'A' && line.charAt(0) <= 'Z') {
                    if (line.charAt(1) >= '0' && line.charAt(1) <= '9') {

                        if (line.length() == 3 && !(line.charAt(2) >= '0' && line.charAt(2) <= '9'))
                            return NOT_DEFINED_STRING;

                        return line;
                    }

                }
            }
        }

        return NOT_DEFINED_STRING;
    }

    private static String askLine() {
        if (scanner.hasNextLine()) {
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            return scanner.nextLine();
        }

        return NOT_DEFINED_STRING;
    }

}
