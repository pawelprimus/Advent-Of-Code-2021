package primus.pawel.DAY_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static primus.pawel.FileReader.readFileAsString;

class DAY_03 {

    public static void main(String[] args) throws Exception {
        String[] input = readFileAsString("03").split("[\\r\\n]+");
        exercise_1(input);
        exercise_2(input);
    }

    public static void exercise_1(String[] input) {
        String gamma = "";
        String epsilon = "";


        int[] counter = new int[12];
        for (String word : input) {
            counter[0] += Integer.parseInt(String.valueOf(word.charAt(0)));
            counter[1] += Integer.parseInt(String.valueOf(word.charAt(1)));
            counter[2] += Integer.parseInt(String.valueOf(word.charAt(2)));
            counter[3] += Integer.parseInt(String.valueOf(word.charAt(3)));
            counter[4] += Integer.parseInt(String.valueOf(word.charAt(4)));
            counter[5] += Integer.parseInt(String.valueOf(word.charAt(5)));
            counter[6] += Integer.parseInt(String.valueOf(word.charAt(6)));
            counter[7] += Integer.parseInt(String.valueOf(word.charAt(7)));
            counter[8] += Integer.parseInt(String.valueOf(word.charAt(8)));
            counter[9] += Integer.parseInt(String.valueOf(word.charAt(9)));
            counter[10] += Integer.parseInt(String.valueOf(word.charAt(10)));
            counter[11] += Integer.parseInt(String.valueOf(word.charAt(11)));
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > 500) {
                gamma += "1";
                epsilon += "0";
            } else {
                gamma += "0";
                epsilon += "1";
            }
        }


        int result = Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2);
        System.out.println("EXERCISE 1 RESULT = [" + result + "]");
    }

    public static void exercise_2(String[] input) {

        List<String> bitsListOxygen = new ArrayList<>();
        List<String> bitsListCO2 = new ArrayList<>();
        List<String> zeros = new ArrayList<>();
        List<String> ones = new ArrayList<>();
        Collections.addAll(bitsListOxygen, input);
        Collections.addAll(bitsListCO2, input);
        int currentBit = 0;

        while (bitsListOxygen.size() != 1) {

            for (String word : bitsListOxygen) {
                if (Integer.parseInt(String.valueOf(word.charAt(currentBit))) == 1) {
                    ones.add(word);
                } else {
                    zeros.add(word);
                }
            }

            bitsListOxygen.clear();

            if (ones.size() >= zeros.size()) {
                bitsListOxygen.addAll(ones);
            } else {
                bitsListOxygen.addAll(zeros);
            }
            ones.clear();
            zeros.clear();

            currentBit++;
            if(currentBit > 11) {
                currentBit = 0;
            }
        }

        currentBit = 0;

        while (bitsListCO2.size() != 1) {

            for (String word : bitsListCO2) {
                if (Integer.parseInt(String.valueOf(word.charAt(currentBit))) == 1) {
                    ones.add(word);
                } else {
                    zeros.add(word);
                }
            }

            bitsListCO2.clear();

            if (zeros.size() <= ones.size() ) {
                bitsListCO2.addAll(zeros);
            } else {
                bitsListCO2.addAll(ones);
            }

            ones.clear();
            zeros.clear();


            currentBit++;
            if(currentBit > 11) {
                currentBit = 0;
            }
            System.out.println(bitsListCO2.size());
        }

        int result = Integer.parseInt(bitsListOxygen.get(0), 2) * Integer.parseInt(bitsListCO2.get(0), 2);
        System.out.println("EXERCISE 2 RESULT = [" + result + "]");
    }


}
