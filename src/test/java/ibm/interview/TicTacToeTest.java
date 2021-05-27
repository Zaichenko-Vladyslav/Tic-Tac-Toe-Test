package ibm.interview;

import ibm.interview.exception.InvalidBoardSizeException;
import ibm.interview.exception.InvalidPositionException;
import ibm.interview.exception.UnavailableCellException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicTacToeTest {

    private TicTacToe ticTacToe;

    @Before
    public void setUp() {
        ticTacToe = new TicTacToe(3);
    }

    @Test
    public void giveInvalidGridSize_whenNewTicTacToeGame_thenInvalidGridSizeException() {
        assertThatThrownBy(
                () -> new TicTacToe(2)
        ).isInstanceOf(InvalidBoardSizeException.class);
    }

    @Test
    public void giveCellOutsideOfTheGrid_whenPlay_thenRuntimeException() {
        assertThatThrownBy(
                () -> ticTacToe.play(2, 5)
        ).isInstanceOf(InvalidPositionException.class);
    }

    @Test
    public void givePlay_whenCellIsOccupied_thenRuntimeException() {
        ticTacToe.play(2, 2);
        assertThatThrownBy(
                () -> ticTacToe.play(2, 2)
        ).isInstanceOf(UnavailableCellException.class);
    }

    @Test
    public void giveFirstTurn_whenNextPlayer_thenItNeedToBePlayerX() {
        assertThat(ticTacToe.nextPlayer()).isEqualTo('X');
    }

    @Test
    public void giveSecondTurn_whenNextPlayer_thenItNeedToBePlayerY() {
        ticTacToe.play(2, 2); // X
        assertThat(ticTacToe.nextPlayer()).isEqualTo('O');
    }

    @Test
    public void giveSecondRound_whenNextPlayer_thenItNeedToBePlayerX() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(2, 2); // O

        assertThat(ticTacToe.nextPlayer()).isEqualTo('X');
    }

    @Test
    public void giveMoves_whenPlay_thenNoWinners() {
        assertThat(ticTacToe.play(1, 1)).isEqualTo(PlayResult.NO_WINNER); // X is NOT the WINNER
        assertThat(ticTacToe.play(1, 2)).isEqualTo(PlayResult.NO_WINNER); // O is NOT the WINNER
        assertThat(ticTacToe.play(2, 1)).isEqualTo(PlayResult.NO_WINNER); // X is NOT the WINNER
        assertThat(ticTacToe.play(2, 2)).isEqualTo(PlayResult.NO_WINNER); // O is NOT the WINNER
        assertThat(ticTacToe.play(3, 3)).isEqualTo(PlayResult.NO_WINNER); // X is NOT the WINNER
        assertThat(ticTacToe.play(3, 1)).isEqualTo(PlayResult.NO_WINNER); // O is NOT the WINNER
    }

    @Test
    public void givePlayerXAllHorizontalLines_whenPlay_thenPlayerXIsWinner() {
        ticTacToe.play(3, 1); // X
        ticTacToe.play(2, 1); // O
        ticTacToe.play(3, 2); // X
        ticTacToe.play(2, 2); // O
        assertThat(ticTacToe.play(3, 3)).isEqualTo(PlayResult.WINNER); // X is the WINNER
    }

    @Test
    public void givePlayerOAllHorizontalLines_whenPlay_thenPlayerOIsWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 3); // X
        ticTacToe.play(2, 2); // O
        ticTacToe.play(3, 3); // X
        assertThat(ticTacToe.play(3, 2)).isEqualTo(PlayResult.WINNER); // O is the WINNER
    }

    @Test
    public void givePlayerXAllVerticalLines_whenPlay_thenPlayerXIsWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 3); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 3); // O
        assertThat(ticTacToe.play(3, 1)).isEqualTo(PlayResult.WINNER); // X is the WINNER
    }

    @Test
    public void givePlayerOAllVerticalLines_whenPlay_thenPlayerOIsWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 2); // O
        ticTacToe.play(1, 3); // X
        assertThat(ticTacToe.play(3, 2)).isEqualTo(PlayResult.WINNER); // O is the WINNER
    }

    @Test
    public void givePlayerXAllFirstDiagonalCells_whenPlay_thenPlayerXIsWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(2, 3); // O

        assertThat(ticTacToe.play(3, 3)).isEqualTo(PlayResult.WINNER); // X is the WINNER
    }

    @Test
    public void givePlayerOAllFirstDiagonalCells_whenPlay_thenPlayerOIsWinner() {
        ticTacToe.play(1, 2); // X
        ticTacToe.play(1, 1); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 2); // O
        ticTacToe.play(3, 2); // X

        assertThat(ticTacToe.play(3, 3)).isEqualTo(PlayResult.WINNER); // O is the WINNER
    }

    @Test
    public void givePlayerXAllSecondDiagonalCells_whenPlay_thenPlayerXIsWinner() {
        ticTacToe.play(1, 3); // X
        ticTacToe.play(1, 1); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(2, 1); // O

        assertThat(ticTacToe.play(3, 1)).isEqualTo(PlayResult.WINNER); // X is the WINNER
    }

    @Test
    public void givePlayerOAllSecondDiagonalCells_whenPlay_thenPlayerOIsWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 3); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 2); // O
        ticTacToe.play(3, 2); // X

        assertThat(ticTacToe.play(3, 1)).isEqualTo(PlayResult.WINNER); // O is the WINNER
    }

    @Test
    public void giveAllCellsIsNotEmpty_whenPlay_thenResultIsDraw() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(2, 1); // O
        ticTacToe.play(1, 2); // X
        ticTacToe.play(2, 2); // O
        ticTacToe.play(2, 3); // X
        ticTacToe.play(1, 3); // O
        ticTacToe.play(3, 1); // X
        ticTacToe.play(3, 2); // O

        assertThat(ticTacToe.play(3, 3)).isEqualTo(PlayResult.DRAW); // All spots have been field, so we have a DRAW
    }

    @Test
    public void giveEmptyBoard_whenShow_thenIsEquals() {
        String actualEmptyBoard = ticTacToe.getBoard().gameInProcess();
        String expectedEmptyBoard =
                "   |   |   \n" +
                "---|---|---\n" +
                "   |   |   \n" +
                "---|---|---\n" +
                "   |   |   ";

        assertThat(actualEmptyBoard).isEqualTo(expectedEmptyBoard);
    }

    @Test
    public void giveBoard_whenShow_thenIsEquals() {
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 2);
        ticTacToe.play(1, 3);
        ticTacToe.play(3, 3);

        String actualBoard = ticTacToe.getBoard().gameInProcess();
        String expectedBoard =
                " X | O | O \n" +
                "---|---|---\n" +
                "   | X |   \n" +
                "---|---|---\n" +
                "   |   | X ";

        assertThat(actualBoard).isEqualTo(expectedBoard);
    }
}
