package primus.pawel.DAY_01;

import java.nio.file.Files;
import java.nio.file.Paths;

import static primus.pawel.FileReader.readFileAsString;
//https://adventofcode.com/2021/day/1


class DAY_01_1 {


    public static void main(String[] args) throws Exception {
        String[] input = readFileAsString("01").split("[\\r\\n]+");
        int counter = 0;
        for (int i = 1; i < input.length; i++) {
            if(Integer.parseInt(input[i]) > Integer.parseInt(input[i-1])){
                counter++;
            }
        }
        System.out.println(counter);
    }

}
