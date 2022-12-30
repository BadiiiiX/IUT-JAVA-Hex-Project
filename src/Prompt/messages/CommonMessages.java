package Prompt.messages;

public class CommonMessages {

    public static final String ASK_SIZE_HEX = "Quelle taille de plateau souhaitez-vous ? (LIMITE: %SIZE_LIMIT%)";
    public static final String ASK_CELL_TO_SELECT = "Quelle case voulez-vous jouer ? (EX: D3)";
    public static final String INVALID_VALUE = "Valeur invalide, réessayez s'il vous plait.";
    public static final String ASK_PLAYER_NAME = "Quel pseudonyme voulez-vous donner au joueur %COLOR% ? ";
    public static final String CALL_NEXT_PLAYER = "C'est le tour de %PLAYER_NAME%";

    public static String format(String text, String var, String content) {
        return text.replace("%"+var+"%", content);
    }

}
