package primus.pawel.DAY_05;

import primus.pawel.InputType;

import static primus.pawel.FileReader.readFileAsString;

//2021-12-20 T:18:54:46
//https://adventofcode.com/2021/day/5
class DAY_05 {

    public static void main(String[] args) throws Exception {
        String[] input = readFileAsString("05", InputType.ORIGINAL).split("[\\r\\n]+");
        String[] points;
        String[] pointArray;
        Grid grid = new Grid();
        Line line;

        for (int i = 0; i < input.length; i++) {
            points = input[i].split("->");
            pointArray = points[0].split(",");
            PointOfLine pointOfLine_1 = new PointOfLine(Integer.parseInt(pointArray[0].trim()), Integer.parseInt(pointArray[1].trim()));
            //System.out.println(pointOfLine_1);

            pointArray = points[1].split(",");
            PointOfLine pointOfLine_2 = new PointOfLine(Integer.parseInt(pointArray[0].trim()), Integer.parseInt(pointArray[1].trim()));
            //System.out.println(pointOfLine_2);

            if (pointOfLine_1.getX() < pointOfLine_2.getX()) {
                line = new Line(pointOfLine_1, pointOfLine_2);
            } else {
                line = new Line(pointOfLine_2, pointOfLine_1);
            }

            System.out.println(i + 1 + "-" + pointOfLine_1 + " -> " + pointOfLine_2);

            if (line.isHorizontal || line.isVertical) {
                grid.selectPointFromList(line.getListOfAllPointsDiagonalOrHorizontal());
            } else if (line.isDiagonal) {
                grid.selectPointFromList(line.getListOfAllDiagonalPoints());
            }
            System.out.println("Coords nr = [" + i + "]");

        }

        //grid.printGridPoints();
        System.out.println("Result = [" + grid.getCountOverlaps() + "]");
    }


}
