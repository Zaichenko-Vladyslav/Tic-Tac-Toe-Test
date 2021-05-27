package ibm.interview;

import ibm.interview.strategy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Cell {

    int x;
    int y;

    public Cell(int x, int y)
    {
        this.x = x;
        this.y=y;
    }

}

public class Application {

    public static void main(String[] args) throws InterruptedException {

        // List with all allowed cells
        List<Cell> cells = new ArrayList<>();

        // Size of board
        int boardSize = 3;

        List<IGameStrategy> strategies = new ArrayList<>();
        strategies.add(new RowStrategy());
        strategies.add(new ColumnStrategy());
        strategies.add(new SecondDiagonalStrategy());
        strategies.add(new FirstDiagonalStrategy());

        TicTacToe game = new TicTacToe(boardSize);
        for (int i =0; i<boardSize; i++) {
            for (int j=0; j<boardSize;j++) {
                cells.add(new Cell(i+1,j+1));
            }
        }

        // Set result of thw game to NO_WINNER
        PlayResult turnResult = PlayResult.NO_WINNER;

        while (turnResult == PlayResult.NO_WINNER) {

            // Wait 2 seconds, than continue
            Thread.sleep(2000);

            // For simulation bot moves random function used
            Random random = new Random();
            int upperbound = cells.size();
            int index = random.nextInt(upperbound);

            if (game.getBoard().getGrid()[cells.get(index).x - 1][cells.get(index).y - 1] == ' ') {
                turnResult = game.play(cells.get(index).x, cells.get(index).y);
                System.out.println(game.getBoard().gameInProcess());
                cells.remove(index);
            }

            System.out.println("");

        }

        if (turnResult == PlayResult.DRAW) {
            System.out.println("Game ends with a DRAW");
        } else {
            System.out.println("Player " + game.getLastPlayer() + " - " + turnResult);
        }

    }
}
