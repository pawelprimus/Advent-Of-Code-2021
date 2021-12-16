package primus.pawel.DAY_04;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static primus.pawel.FileReader.readFileAsString;

class DAY_04 {

    public static void main(String[] args) throws Exception {

        String[] input = readFileAsString("04").split("[\\r\\n]+");

        String[] chosenNumsString = input[0].split(",");
        int[] chosenNums = parseStringTabToIntTab(chosenNumsString);

        List<List<Integer>> rows = new ArrayList<>();
        ArrayList<BingoGrid> bingoGrids = new ArrayList<>();

        Pattern p = Pattern.compile("\\d+");

        for (int i = 1; i < input.length; i++) {
            List<Integer> row = new ArrayList<>();
            Matcher m = p.matcher(input[i]);
            while (m.find()) {
                row.add(Integer.parseInt(m.group()));
            }
            rows.add(row);
            if (i % 5 == 0) {
                BingoGrid bingoGrid = new BingoGrid();
                bingoGrid.setNumbers(rows);
                bingoGrids.add(bingoGrid);
                rows.clear();
            }
        }

        int numberIterator = 0;
        int sumOfAllGrids = bingoGrids.size();

        outerLoop:
        for (Integer numberToMark : chosenNums) {
            numberIterator++;
            for (BingoGrid bingoGrid : bingoGrids) {

                if (!bingoGrid.isBingo()) {

                    bingoGrid.markNumberIfIsInGrid(numberToMark);

                    if (bingoGrid.checkIfIsBingo()) {
                        int sumOfNotMarked = bingoGrid.getSumOfNotMarkedNumbers();
                        System.out.println("ITERATOR: " + numberIterator);
                        System.out.println("BINGO GIRD ID :" + bingoGrid.getGridID());
                        System.out.println("SUM OF NOT MARKED NUMS " + sumOfNotMarked);
                        System.out.println("LAST NUMBER TO MARK :" + numberToMark);
                        System.out.println("RESULT = [" + sumOfNotMarked * numberToMark + "]");
                        sumOfAllGrids--;

                        if (sumOfAllGrids == 0) {
                            break outerLoop;
                        }
                    }
                }
            }
        }

    }


    public static int[] parseStringTabToIntTab(String[] strings) {
        int[] chosenNums = new int[strings.length];

        for (int i = 0; i < chosenNums.length; i++) {
            chosenNums[i] = Integer.parseInt(strings[i]);
        }
        return chosenNums;
    }

}
