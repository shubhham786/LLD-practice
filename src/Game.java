import java.util.Random;

public class Game {

    private Board board;
    private Player[] players;
    private int currentPlayerIndex;

    public Game(int boardSize, Player player1, Player player2) {
        board = new Board(boardSize);
        players = new Player[] {player1, player2};
        Random random = new Random();
        currentPlayerIndex = random.nextInt(2);
    }

    public boolean makeMove(Index index)
    {
        int x=index.getX();
        int y=index.getY();

        // Validate move
        if (x < 0 || x >= board.dimension || y < 0 || y >= board.dimension) {
            System.out.println("Invalid move: Out of bounds!");
            return false;
        }

        if(board.board[x][y]!=Symbol.EMPTY)
        {
            System.out.println("Invalid move: Cell already occupied!");
            return false;
        }

        Player currentPlayer = players[currentPlayerIndex];
        board.board[x][y] = currentPlayer.symbol;

        // Print the board
        System.out.println(currentPlayer.getName() + " made a move at (" + x + ", " + y + ")");
        board.printBoard();

        // Check for winner
        if (checkWinner(currentPlayer.getSymbol())) {
            System.out.println("Winner is: " + currentPlayer.getName() + "!");
            System.exit(0); // End the game
        }

        // Switch turns
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        return true;
    }


    private boolean checkWinner(Symbol symbol) {
        // Check rows
        for (int i = 0; i < board.dimension; i++) {
            boolean win = true;
            for (int j = 0; j < board.dimension; j++) {
                if (board.board[i][j] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check columns
        for (int j = 0; j < board.dimension; j++) {
            boolean win = true;
            for (int i = 0; i < board.dimension; i++) {
                if (board.board[i][j] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check main diagonal
        boolean win = true;
        for (int i = 0; i < board.dimension; i++) {
            if (board.board[i][i] != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check anti-diagonal
        win = true;
        for (int i = 0; i < board.dimension; i++) {
            if (board.board[i][board.dimension - 1 - i] != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;

        return false;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }
}
