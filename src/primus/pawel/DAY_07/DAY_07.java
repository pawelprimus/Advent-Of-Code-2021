package primus.pawel.DAY_07;

import primus.pawel.InputType;

import static primus.pawel.FileReader.readFileAsString;

//https://adventofcode.com/2021/day/7
class DAY_07 {

    public static void main(String[] args) throws Exception {

        String[] input = readFileAsString("07", InputType.ORIGINAL).split(",");
        int[] initialState = new int[input.length];
        int maximalHorizontalPosition = 0;
        int minimalHorizontalPosition = 0;
        int minimalFuel = Integer.MAX_VALUE;
        int currentFuel = 0;

        System.out.println(countFuel(11));

        for (int i = 0; i < input.length; i++) {
            initialState[i] = Integer.parseInt(input[i].trim());
            System.out.println(initialState[i]);
            if (maximalHorizontalPosition < initialState[i]) {
                maximalHorizontalPosition = initialState[i];
            }
        }

        for (int i = minimalHorizontalPosition; i <= maximalHorizontalPosition; i++) {

            for (int j = 0; j < initialState.length; j++) {

                currentFuel += countFuel(Math.abs(initialState[j] - i));
            }

            if (minimalFuel > currentFuel) {
                minimalFuel = currentFuel;
            }

            System.out.println("Horizontal POS:" + i + " FUEL: " + currentFuel);
            currentFuel = 0;
        }
        System.out.println("RESULT: " + minimalFuel);
    }

    public static int countFuel(int moves) {
        int result = 0;
        while (moves >= 0) {
            result += moves--;
        }
        return result;
    }

}
