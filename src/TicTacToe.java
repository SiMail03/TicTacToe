import java.util.Scanner;

public class TicTacToe {
    private static char[] board = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
    private static char currentPlayer = 'X';
    private static int numberOfMoves = 9;

    public TicTacToe() {
        playGame();
    }

    // Display the current state of the tic-tac-toe board
    private void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.print("\n");
            }
            if (i % 3 != 0 && i != 0) {
                System.out.print("|");
            }
            System.out.print(board[i]);
        }
    }

    // Play the tic-tac-toe game
    private void playGame() {
        displayBoard();
        while (numberOfMoves != 0 && !checkWinner()) {
            handleTurn();
            if (numberOfMoves == 0 && !checkWinner()) {
                System.out.println("\nIt's a draw");
                break;
            }
        }
    }

    // Handle a player's turn
    private void handleTurn() {
        if (currentPlayer == 'X') {
            System.out.println("\nX's turn");
        } else {
            System.out.println("\nO's turn");
        }

        Scanner scanner = new Scanner(System.in);
        int userInput;

        while (true) {
            System.out.println("\nSelect a field from 1-9");
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                break; // Exit the loop if userInput is a valid integer
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); // Clear the invalid input
                displayBoard();
            }
        }

        if (userInput < 1 || userInput > 9 || board[userInput - 1] != '-') {
            System.out.println("Invalid input! Please enter a valid field");
            displayBoard();
        } else {
            board[userInput - 1] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            numberOfMoves--;
            displayBoard();
        }
    }

    // Check if a player has won the game
    private boolean checkWinner() {
        char winner = '-';
        if ((board[0] == board[1] && board[1] == board[2] && board[0] != '-') ||
                (board[3] == board[4] && board[4] == board[5] && board[3] != '-') ||
                (board[6] == board[7] && board[7] == board[8] && board[6] != '-') ||
                (board[0] == board[3] && board[3] == board[6] && board[0] != '-') ||
                (board[1] == board[4] && board[4] == board[7] && board[1] != '-') ||
                (board[2] == board[5] && board[5] == board[8] && board[2] != '-') ||
                (board[0] == board[4] && board[4] == board[8] && board[0] != '-') ||
                (board[2] == board[4] && board[4] == board[6] && board[2] != '-')) {
            winner = (currentPlayer == 'X') ? 'O' : 'X';
        }

        if (winner != '-') {
            System.out.println("\n" + winner + " won");
            return true;
        }

        return false;
    }
}
