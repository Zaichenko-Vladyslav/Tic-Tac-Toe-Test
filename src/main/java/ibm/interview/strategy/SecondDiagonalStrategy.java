package ibm.interview.strategy;

import ibm.interview.TicTacToe;

public class SecondDiagonalStrategy implements IGameStrategy {

    @Override
    public boolean matches(TicTacToe game) {

        int numOfMatches = 0;

        for (int i = 0; i < game.getBoard().getSize(); i++) {
            if (game.getBoard().getGrid()[i][i] == game.getLastPlayer()) {
                numOfMatches++;
            }
        }

        return numOfMatches == game.getBoard().getSize();
    }
}
