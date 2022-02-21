/**
 * Handles determining if a player has won.
 */
public class WinningBoard {
    public static final String X = "X";
    public static final String O = "O";
    private String[][] board;

    public WinningBoard(String[][] board) {
        this.board = board;

    }

    /**
     * Determines if a player won the game.
     *
     * @param playerCharacter The player's character (X or O)
     * @return True if a player won, false if otherwise.
     */
    public boolean isBoardWon(String playerCharacter) {
        boolean areRowsOrColumnsWon = areRowsOrColumnsWon(playerCharacter);
        boolean isDiagonalLeftToRightWon = isDiagonalLeftToRightWon(playerCharacter);
        boolean isDiagonalRightToLeftWon = isDiagonalRightToLeftWon(playerCharacter);
        return areRowsOrColumnsWon || isDiagonalLeftToRightWon || isDiagonalRightToLeftWon;

    }

    private boolean areRowsOrColumnsWon(String playerCharacter) {
        for (int i = 0; i < board.length; i++) {
            boolean isRowOrColumnWon = isRowOrColumnWon(i, playerCharacter);
            if (isRowOrColumnWon) {
                return true;
            }

        }
        return false;
    }

    private boolean isRowOrColumnWon(int rowOrColumn, String playerCharacter) {
        boolean isRowWon = true;
        boolean isColumnWon = true;
        for (int i = 0; i < board.length; i++) {
            boolean isCellNotTaken2 = isCellNotTaken(rowOrColumn, i, playerCharacter);
            if (isCellNotTaken2) {
                isRowWon = false;
            }
            boolean isCellNotTaken = isCellNotTaken(i, rowOrColumn, playerCharacter);
            if (isCellNotTaken) {
                isColumnWon = false;
            }
        }
        return isColumnWon || isRowWon;
    }

    private boolean isDiagonalLeftToRightWon(String playerCharacter) {
        for (int i = 0; i < board.length; i++) {
            boolean isCellNotTaken = isCellNotTaken(i, i, playerCharacter);
            if (isCellNotTaken) {
                return false;

            }
        }
        return true;
    }

    private boolean isDiagonalRightToLeftWon(String playerCharacter) {

        for (int i = 0; i < board.length; i++) {
            if (isCellNotTaken(i, board.length - 1 - i, playerCharacter)) {
                return false;
            }

        }
        return true;
    }

    //
    private boolean isCellNotTaken(int row, int column, String playerCharacter) {
        return !board[row][column].equalsIgnoreCase(playerCharacter);
    }

}
