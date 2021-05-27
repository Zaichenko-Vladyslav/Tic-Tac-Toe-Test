package ibm.interview.strategy;

import ibm.interview.TicTacToe;

public class RowStrategy implements IGameStrategy {

    @Override
    public boolean matches(TicTacToe game) {

        int numOfMatches;

        for (int row = 0; row < game.getBoard().getSize(); row++) {
            numOfMatches = 0;

            for (int column = 0; column < game.getBoard().getSize(); column++) {
                if (game.getBoard().getGrid()[row][column] == game.getLastPlayer()) {
                    numOfMatches++;
                }
            }

            if (numOfMatches == game.getBoard().getSize()) {
                return true;
            }
        }

        return false;
    }
}
