package primus.pawel.DAY_05;

import static primus.pawel.FileReader.readFileAsString;

class DAY_05 {

    public static void main(String[] args) throws Exception {
        String[] input = readFileAsString("05").split("[\\r\\n]+");
        String[] points;
        String[] pointArray;
        Grid grid = new Grid();

        for (int i = 0; i < input.length; i++) {
            points = input[i].split("->");
            pointArray = points[0].split(",");
            PointOfLine pointOfLine_1 = new PointOfLine(Integer.parseInt(pointArray[0].trim()), Integer.parseInt(pointArray[1].trim()));
            //System.out.println(pointOfLine_1);

            pointArray = points[1].split(",");
            PointOfLine pointOfLine_2 = new PointOfLine(Integer.parseInt(pointArray[0].trim()), Integer.parseInt(pointArray[1].trim()));
            //System.out.println(pointOfLine_2);

            Line line = new Line(pointOfLine_1, pointOfLine_2);

            System.out.println(i + 1 + "-" + pointOfLine_1 + " -> " + pointOfLine_2);

            if (line.isHorizontal || line.isVertical) {

                grid.selectPointFromList(line.getListOfAllPoints());

                for (PointOfLine pointOfLine : line.getListOfAllPoints()) {
                    System.out.print(" | " + pointOfLine);
                }

            }


        }

        grid.printGridPoints();
        System.out.println("Result = [" + grid.getCountOverlaps() + "]");
    }


}
