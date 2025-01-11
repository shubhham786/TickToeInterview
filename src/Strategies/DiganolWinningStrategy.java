package Strategies;



import Classes.Board;
import Classes.Cell;
import Classes.Move;
import enums.CellStatus;

public class DiganolWinningStrategy implements GameWinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getRow();
        int col = move.getCol();
        String symbol = move.getPlayer().getSymbol();

        // Check main diagonal (row == col)
        if (row == col) {
            boolean mainDiagonalWin = true;
            for (int i = 0; i < board.getDimension(); i++) {
                Cell cell = board.getBoard().get(i).get(i);
                if (cell.getCellStatus() != CellStatus.FILEED ||
                        !cell.getPlayer().getSymbol().equals(symbol)) {
                    mainDiagonalWin = false;
                    break;
                }
            }
            if (mainDiagonalWin) {
                return true;
            }
        }

        // Check anti-diagonal (row + col == dimension - 1)
        if (row + col == board.getDimension() - 1) {
            boolean antiDiagonalWin = true;
            for (int i = 0, j = board.getDimension() - 1; i < board.getDimension(); i++, j--) {
                Cell cell = board.getBoard().get(i).get(j);
                if (cell.getCellStatus() != CellStatus.FILEED||
                        !cell.getPlayer().getSymbol().equals(symbol)) {
                    antiDiagonalWin = false;
                    break;
                }
            }
            if (antiDiagonalWin) {
                return true;
            }
        }

        return false;
    }
}

