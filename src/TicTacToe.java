import java.util.Scanner;

public class TicTacToe {
    //defines class
    private static final String[][] BOARD = new String[3][3];

    public static void main(String[] args) {
        System.out.println("     |     |     ");
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.println("     |     |     ");

        System.out.println();
        System.out.println();
        initializeBoard();
        getUserInput();


    }

    private static void getUserInput() {
        boolean playerX = true;
        while (true) {

            Scanner scanner = new Scanner(System.in);


            System.out.print("row: ");
            int row = scanner.nextInt();

            System.out.print("column: ");
            int column = scanner.nextInt();

            System.out.println();
            String playerCharacter = WinningBoard.O;
            if (playerX) {
                playerCharacter = WinningBoard.X;
            }
            move(row, column, playerCharacter);
            playerX = !playerX;

            WinningBoard winningBoard = new WinningBoard(BOARD);
            if (winningBoard.isBoardWon(WinningBoard.X)) {
                System.out.println("X wins. GGWP");
                return;
            } else if (winningBoard.isBoardWon(WinningBoard.O)) {
                System.out.println("O wins. GGWP");
                return;
            }
        }


    }


    private static void initializeBoard() {
        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD[0].length; j++) {
                BOARD[i][j] = " ";
            }
        }

    }

    public static void move(int row, int column, String playerCharacter) {
        row = row - 1;
        column = column - 1;

        BOARD[row][column] = playerCharacter;

        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD[0].length; j++) {

                System.out.printf("  %s  ", BOARD[i][j]);
                if (j < BOARD.length - 1) {
                    System.out.print("|");
                }

            }
            System.out.println();
            for (int j = 0; j < BOARD[0].length; j++) {


                if (i == BOARD.length - 1) {
                    System.out.print("     ");
                } else {
                    System.out.print("_____");
                }


                if (j < BOARD.length - 1) {
                    System.out.print("|");
                }

            }
            System.out.println();

        }
        System.out.println();


        System.out.println();
    }


}