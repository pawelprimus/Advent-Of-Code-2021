package primus.pawel.DAY_01;

import java.nio.file.Files;
import java.nio.file.Paths;

import static primus.pawel.FileReader.readFileAsString;

class DAY_01_2 {


    public static void main(String[] args) throws Exception {
        String[] input = readFileAsString("01").split("[\\r\\n]+");
        int counter = 0;
        int sum = Integer.parseInt(input[0]) + Integer.parseInt(input[1]) + Integer.parseInt(input[2]);
        int oldSum = sum;
        for (int i = 3; i < input.length; i++) {
            sum = sum +  Integer.parseInt(input[i]) -  Integer.parseInt(input[i-3]);
            System.out.println(sum);
            System.out.println(oldSum);
            if(sum > oldSum){
                counter++;
            }
            oldSum = sum;

        }
        System.out.println(counter);
    }


}
