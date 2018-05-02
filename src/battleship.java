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

            run.setupBoards(playerBoard, enemyBoard, attackBoard);
            run.displayBoards(playerBoard, attackBoard);
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

        void placePlayerShips() {
         //   Scanner s = new Scanner(System.in);
        }
}
