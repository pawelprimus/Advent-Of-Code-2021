package primus.pawel.DAY_05;

import static primus.pawel.FileReader.readFileAsString;

class DAY_05 {

    public static void main(String[] args) throws Exception {
        String[] input = readFileAsString("05").split("[\\r\\n]+");
        String[] points;

        for (int i = 0; i < input.length; i++) {
            points = input[i].split("->");
            for (int j = 0; j < points.length; j++) {
                System.out.println(points[j]);
            }


        }

    }
    

}
