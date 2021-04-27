package tictactoe;
import java.util.Arrays;

public class Board {
    public char[][] board;
    public final int NO_OF_ROWS = 3;
    public final int NO_OF_COLUMNS = 3;

    public Board() {
        board = new char[NO_OF_ROWS][NO_OF_COLUMNS];
        for(char[] row : board)
            Arrays.fill(row, ' ');
    }

    public Board(char[][] config) {
        this();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (config[i][j] == 'X') {
                    board[i][j] = 'X';
                }
                else if (config[i][j] == 'O')
                    board[i][j] = 'O';
                else board[i][j] = ' ';
            }
        }
    }

    public Board(String initialState) {
        this();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char extract = initialState.charAt(i * 3 +j);
                if (extract == 'X')
                    board[i][j] = 'X';
                else if (extract == 'O')
                    board[i][j] = 'O';
            }
        }
    }

    protected boolean isComplete() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    public void displayBoard() {
        for (int i = 1; i <= 9 ; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        for (int i = 1; i <= 9 ; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public boolean placePiece(int row, int column, char piece) {
        if (board[row - 1][column - 1] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        board[row - 1][column - 1] = piece;
        return true;
    }
}
