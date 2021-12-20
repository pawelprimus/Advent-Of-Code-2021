package primus.pawel.DAY_02;

import primus.pawel.InputType;

import java.util.HashMap;

import static primus.pawel.FileReader.readFileAsString;

class DAY_02 {

    private static final String FORWARD = "forward";
    private static final String UP = "up";
    private static final String DOWN = "down";

    public static void main(String[] args) throws Exception {
        String[] input = readFileAsString("02", InputType.ORIGINAL).split("[\\r\\n]+");

        int horizonal = 0;
        int depth = 0;
        int aim = 0;

        for(String word : input){
            String[] order = word.split(" ");
            switch(order[0]) {
                case FORWARD:
                    horizonal += Integer.parseInt(order[1]) ;
                    depth += Integer.parseInt(order[1])*aim;
                    break;
                case UP:
                   //depth -= Integer.parseInt(order[1]);
                    aim -= Integer.parseInt(order[1]);
                    break;
                case DOWN:
                   // depth += Integer.parseInt(order[1]);
                    aim += Integer.parseInt(order[1]);
                    break;
                default:
            }
        }
        int result = horizonal*depth;
        System.out.println("RESULT = [" + result + "]");
    }
}
