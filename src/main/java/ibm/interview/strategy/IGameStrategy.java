package ibm.interview.strategy;

import ibm.interview.TicTacToe;

// There are few possible win strategies
public interface IGameStrategy {

    boolean matches(TicTacToe game);
}
