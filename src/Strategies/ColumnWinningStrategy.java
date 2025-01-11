package Strategies;

import Classes.Board;
import Classes.Cell;
import Classes.Move;
import Classes.Player;
import enums.CellStatus;

public class ColumnWinningStrategy implements GameWinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCol();
        String symbol = move.getPlayer().getSymbol();

        for (int row = 0; row < board.getDimension(); row++) {
            Cell cell = board.getBoard().get(row).get(col);
            if (cell.getCellStatus() != CellStatus.FILEED ||
                    !cell.getPlayer().getSymbol().equals(symbol)) {
                return false; // Early return on mismatch
            }
        }

        return true; // All cells in the column match
    }
}

