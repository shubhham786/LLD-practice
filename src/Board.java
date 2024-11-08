public class Board {

     int dimension;
     Symbol [][] board;


    public Board(int dimension) {
        this.dimension = dimension;
        board = new Symbol[dimension][dimension];
        // Initialize the board with Symbol.EMPTY
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = Symbol.EMPTY; // Set default value
            }
        }
    }

    public void printBoard() {
        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                System.out.print(board[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
    }


}
