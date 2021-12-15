package primus.pawel.DAY_04;

import java.util.List;

class BingoGrid {

    int[][] numbers = new int[5][5];

    BingoGrid() {
    }


    void setNumbers(List<List<Integer>> rows) {
        int rowIndex = 0;
        int columnIndex = 0;
        for (List<Integer> row : rows) {
            for (Integer num : row) {
                this.numbers[rowIndex][columnIndex] = num;
                columnIndex++;
            }
            columnIndex = 0;
            rowIndex++;
        }
    }

    public void printGrid(){

        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                System.out.print(this.numbers[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }


}
