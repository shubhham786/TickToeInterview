package Strategies;

import Classes.Board;
import Classes.Cell;
import Classes.Move;
import Classes.Player;
import enums.CellStatus;

public class RowWinningStrategy implements GameWinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getRow();
        String symbol = move.getPlayer().getSymbol();

        for (int col = 0; col < board.getDimension(); col++) {
            Cell cell = board.getBoard().get(row).get(col);

            if (cell.getCellStatus() != CellStatus.FILEED ||
                    !cell.getPlayer().getSymbol().equals(symbol)) {
                return false; // Early return on mismatch
            }
        }

        return true; // All cells in the row match
    }
}
