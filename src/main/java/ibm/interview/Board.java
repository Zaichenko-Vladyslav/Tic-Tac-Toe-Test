package ibm.interview;

import ibm.interview.exception.InvalidBoardSizeException;

public class Board {

    private final int size;
    private char[][] grid;
    private static final char EMPTY = ' ';

    public Board(int size) {
        this.size = size;

        // If board has size less than 3x3 it goes thrown InvalidBoardException
        if (size > 2) {
            setUpGame();
        } else {
            throw new InvalidBoardSizeException("The board has not allowed size");
        }
    }

    // Method for creating source game board with empty cells
    private void setUpGame() {
        grid = new char[size][size];

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                grid[row][column] = EMPTY;
            }
        }
    }

    // Method for showing current game situation
    public String gameInProcess() {
        StringBuilder board = new StringBuilder();

        for (int row = 0; row < size; row++) {
            StringBuilder columnSeparator = new StringBuilder();
            addRow(board, grid[row], columnSeparator);
            addRowSeparator(board, columnSeparator);
        }

        removeLastRowSeparator(board);

        return board.toString();
    }


    private void addRow(StringBuilder board, char[] chars, StringBuilder columnSeparator) {
        for (int column = 0; column < size; column++) {
            board.append(" ");
            board.append(chars[column]);
            board.append(" |");
            columnSeparator.append("---|");
        }
    }

    private void addRowSeparator(StringBuilder board, StringBuilder columnSeparator) {
        board.deleteCharAt(board.length() - 1);
        board.append("\n");
        columnSeparator.deleteCharAt(columnSeparator.length() - 1);
        board.append(columnSeparator);
        board.append("\n");
    }

    private void removeLastRowSeparator(StringBuilder board) {
        board.delete((board.deleteCharAt(board.length() - 1).lastIndexOf("\n")), board.length());
    }

    public int getSize() {
        return size;
    }

    public char[][] getGrid() {
        return grid;
    }
}
