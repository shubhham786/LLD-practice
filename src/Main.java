import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Player player1 = new Player(1, "Alice", Symbol.CROSS);
        Player player2 = new Player(2, "Bob", Symbol.OVAL);

        Game game = new Game(3, player1, player2); // Create a 3x3 board

        Scanner scanner = new Scanner(System.in);

        // Start the game
        while (true) {
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol().getSymbol() + ").");
            System.out.print("Enter row and column (e.g., 0 1): ");

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (game.makeMove(new Index(x, y))) {

            }
        }
    }
}