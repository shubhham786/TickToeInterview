package Classes;

import enums.CellStatus;

public class Player {

    String name;
    String symbol;

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void makeMove(Move move,Board board) {
        int row=move.getRow();
        int col=move.getCol();

        Cell cell=board.getBoard().get(row).get(col);
        cell.setPlayer(this);
        cell.setCellStatus(CellStatus.FILEED);

    }
}
