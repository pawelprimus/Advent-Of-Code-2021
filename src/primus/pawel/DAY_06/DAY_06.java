package primus.pawel.DAY_06;

import primus.pawel.InputType;

import static primus.pawel.FileReader.readFileAsString;
////https://adventofcode.com/2021/day/6
class DAY_06 {

    public static void main(String[] args) throws Exception {

        String[] input = readFileAsString("06", InputType.TEST).split(",");
        int[] initialState = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            initialState[i] = Integer.parseInt(input[i].trim());
        }

    }



}
