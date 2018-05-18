import java.util.Scanner;
import java.awt.event.KeyEvent;

public class battleship {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String args[]) {
        battleship run = new battleship();
        String[][] playerBoard;
        playerBoard = new String[10][10];
        String[][] enemyBoard;
        enemyBoard = new String[10][10];
        String[][] attackBoard;
        attackBoard = new String[10][10];
        String[][] compareBoard = playerBoard;

        run.setupBoards(playerBoard, enemyBoard, attackBoard);
        run.displayBoards(playerBoard, attackBoard);
        run.placePlayerShips(playerBoard, compareBoard);
    }

    void setupBoards(String[][] playerBoard, String[][] enemyBoard, String[][] attackBoard) {
        for(int i = 0; i < 10; i++) {
            for(int x = 0; x < 10; x++) {
                playerBoard[i][x] = BLUE + "#" + RESET;
                enemyBoard[i][x] = BLUE + "#" + RESET;
                attackBoard[i][x] = BLUE + "#" + RESET;
            }
        }
    }

    void displayBoards(String[][] playerBoard, String[][] attackBoard) {
        System.out.println("            Attack Board");
        System.out.println("    A  B  C  D  E  F  G  H  I  J");
        for(int y = 0; y < 10; y++) {
            if(y != 9) {
                System.out.print(" " + (y + 1) + " ");
            } else {
                System.out.print((y + 1) + " ");
            }
            for(int x = 0; x < 10; x++) {
                System.out.print("[" + attackBoard[x][y] + "]");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("            Your Board");
        System.out.println("    A  B  C  D  E  F  G  H  I  J");
        for(int y = 0; y < 10; y++) {
            if(y != 9) {
                System.out.print(" " + (y + 1) + " ");
            } else {
                System.out.print((y + 1) + " ");
            }
            for(int x = 0; x < 10; x++) {
                System.out.print("[" + playerBoard[x][y] + "]");
            }
            System.out.println();
        }
    }

    void displayBoard(String[][] board) {
        System.out.println("    A  B  C  D  E  F  G  H  I  J");
        for(int y = 0; y < 10; y++) {
            if(y != 9) {
                System.out.print(" " + (y + 1) + " ");
            } else {
                System.out.print((y + 1) + " ");
            }
            for(int x = 0; x < 10; x++) {
                System.out.print("[" + board[x][y] + "]");
            }
            System.out.println();
        }
    }

    void placePlayerShips(String[][] playerBoard, String[][] compareBoard) {
        Scanner s = new Scanner(System.in);
        boolean done = false;
        int currentShip = 0;
        int curX = 0;
        int curY = 0;
        int curDir = 0;
        int[] shipLengths = {5, 4, 3, 3, 2};
        String[] shipChars = {"A", "B", "S", "C", "D"};
        String[] shipNames = {"Aircraft Carrier", "Battleship", "Submarine", "Cruiser", "Destroyer"};
        while (!done) {
            clear();
            updateShipPlacement(compareBoard, curX, curY, curDir, shipLengths[currentShip], shipChars[currentShip]);
            displayBoard(compareBoard);
            System.out.println("You are placing the " + shipNames[currentShip] + ".");
            System.out.println("Use the arrows to move the position, press D to change direction,");
            System.out.print("and press enter to confirm");

        }
    }

    void updateShipPlacement(String[][] board, int x, int y, int dir, int shipLength, String shipChar) {
        for(int i = 0; i < shipLength; i++) {
            board[x][y] = WHITE + shipChar + RESET;
            if(dir == 0) {
                x++;
            } else {
                y++;
            }
        }
    }

    boolean isSpaceClear(String[][] board, int x, int y, int dir, int shipLength) {
        boolean isGood = true;
        for(int i = 0; i < shipLength; i++) {
            if(board[x][y] != (BLUE + "%" + RESET)) isGood = false;
            if(x >= 10 || y >= 10) isGood = false;
            if(dir == 0) x++;
            else y++;
        }
        return isGood;
    }

    int getKeyInput(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            return 0;
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            return 1;
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            return 2;
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            return 3;
        }
        return -1;
    }

    void clear() {
        for(int i = 0; i < 100; i++) System.out.println();
    }
}
