package primus.pawel.DAY_02;

import static primus.pawel.FileReader.readFileAsString;

class DAY_02 {

    public static void main(String[] args) throws Exception {
        String[] input = readFileAsString("02").split("[\\r\\n]+");
        for(String word : input){
            System.out.println(word);
        }

    }
}
