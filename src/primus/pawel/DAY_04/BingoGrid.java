package primus.pawel.DAY_04;

import java.util.ArrayList;
import java.util.List;

class BingoGrid {

    List<BingoNumber> bingoNumbers = new ArrayList<>();
    int[] markedColumns = new int[5];
    int[] markedRows = new int[5];
    private static int  idIterator = 1;
    private final int  gridID;

    BingoGrid() {
        this.gridID = idIterator++;

    }

    int getGridID() {
        return gridID;
    }

    void setNumbers(List<List<Integer>> rows) {
        int rowIndex = 0;
        int columnIndex = 0;
        for (List<Integer> row : rows) {
            for (Integer num : row) {
                BingoNumber bingoNumber = new BingoNumber(num, columnIndex + 1, rowIndex + 1);
                bingoNumbers.add(bingoNumber);
                columnIndex++;
            }
            columnIndex = 0;
            rowIndex++;
        }
    }

    public void printBingoNumbers(){
       for(BingoNumber bingoNumber : bingoNumbers){
           System.out.println(bingoNumber.toString());
       }
    }

    public void markNumberfIfIsInGrid(int number) {
        for(BingoNumber bingoNumber : bingoNumbers){

            if(number == bingoNumber.getNumber()){
                bingoNumber.setMarked(true);

                markedColumns[bingoNumber.getColumn() - 1]++;
                markedRows[bingoNumber.getRow() - 1]++;

            }
            //System.out.println(bingoNumber.toString());
        }
    }

    public boolean checkIfIsBingo(){

        for (int i = 0; i < markedColumns.length; i++) {
            if(markedColumns[i] >= 5){
                return true;
            }

        }

        for (int i = 0; i < markedRows.length; i++) {
            if(markedRows[i] >= 5){
                return true;
            }
        }

        return false;
    }

}


class BingoNumber {

    int number;
    int row;
    int column;
    boolean isMarked;

    BingoNumber(final int number,  final int column, final int row) {
        this.row = row;
        this.number = number;
        this.column = column;
    }

    int getNumber() {
        return number;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }


    boolean isMarked() {
        return isMarked;
    }

    void setMarked(final boolean marked) {
        isMarked = marked;
    }

    @Override
    public String toString() {
        return "BingoNumber{" +
                "number=" + number +
                ", row=" + row +
                ", column=" + column +
                ", isMarked=" + isMarked +
                '}';
    }
}