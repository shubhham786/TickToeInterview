package Classes;

import enums.CellStatus;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Board {

    int dimension;

    List<List<Cell>>board;

    public Board(int dimension) {
        this.dimension = dimension;
        board = new ArrayList<>();
         intializeBoard();
    }

     public void intializeBoard() {
         for(int i = 0; i < dimension; i++) {
             List<Cell> temp = new ArrayList<>();
             for(int j = 0; j < dimension; j++) {
                 Cell cell=new Cell(i,j, CellStatus.AVAILABLE);
                 temp.add(cell);
             }
             board.add(temp);
         }

     }

     public void displayBoard() {
        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {

                Cell cell = board.get(i).get(j);
                if(CellStatus.AVAILABLE.equals(cell.getCellStatus()))
                 System.out.print(" | "+ " "+ " |");
                else
                {
                    System.out.print(" | "+cell.getPlayer().getSymbol()+" |");
                }
            }
            System.out.println();
        }
     }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
