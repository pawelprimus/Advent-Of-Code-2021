package primus.pawel.DAY_05;

import java.util.ArrayList;
import java.util.List;

class Line {

    final PointOfLine pointOfLine_1;
    final PointOfLine pointOfLine_2;
    boolean isHorizontal;
    boolean isVertical;
    boolean isDiagonal;

    Line(final PointOfLine pointOfLine_1, final PointOfLine pointOfLine_2) {
        this.pointOfLine_1 = pointOfLine_1;
        this.pointOfLine_2 = pointOfLine_2;
        isHorizontal = isLineHorizontal();
        isVertical = isLineVertical();
        isDiagonal = isLineDiagonal();
    }

    private boolean isLineVertical() {
        return (pointOfLine_1.getX() == pointOfLine_2.getX());
    }

    private boolean isLineHorizontal() {
        return (pointOfLine_1.getY() == pointOfLine_2.getY());
    }

    private boolean isLineDiagonal() {

        return (Math.abs(pointOfLine_1.getX() - pointOfLine_1.getY()) == Math.abs(pointOfLine_2.getX() - pointOfLine_2.getY())) ||
                (Math.abs(pointOfLine_1.getX() + pointOfLine_1.getY()) == Math.abs(pointOfLine_2.getX() + pointOfLine_2.getY()));
    }


    boolean isHorizontal() {
        return isHorizontal;
    }

    boolean isVertical() {
        return isVertical;
    }

    List<PointOfLine> getListOfAllPointsDiagonalOrHorizontal() {
        List<PointOfLine> pointOfLines = new ArrayList<>();
        int pointCordinateIterator = 0;
        if (isHorizontal) {

            if (pointOfLine_1.getX() < pointOfLine_2.getX()) {
                pointCordinateIterator = pointOfLine_1.getX();
                while (pointCordinateIterator <= pointOfLine_2.getX()) {
                    PointOfLine pointOfLine = new PointOfLine(pointCordinateIterator, pointOfLine_1.getY());
                    pointOfLines.add(pointOfLine);
                    pointCordinateIterator++;
                }

            } else {
                pointCordinateIterator = pointOfLine_2.getX();
                while (pointCordinateIterator <= pointOfLine_1.getX()) {

                    PointOfLine pointOfLine = new PointOfLine(pointCordinateIterator, pointOfLine_1.getY());
                    pointOfLines.add(pointOfLine);
                    pointCordinateIterator++;
                }
            }

        } else {

            if (pointOfLine_1.getY() < pointOfLine_2.getY()) {
                pointCordinateIterator = pointOfLine_1.getY();
                while (pointCordinateIterator <= pointOfLine_2.getY()) {
                    PointOfLine pointOfLine = new PointOfLine(pointOfLine_1.getX(), pointCordinateIterator);
                    pointOfLines.add(pointOfLine);
                    pointCordinateIterator++;
                }

            } else {
                pointCordinateIterator = pointOfLine_2.getY();
                while (pointCordinateIterator <= pointOfLine_1.getY()) {
                    PointOfLine pointOfLine = new PointOfLine(pointOfLine_1.getX(), pointCordinateIterator);
                    pointOfLines.add(pointOfLine);
                    pointCordinateIterator++;
                }
            }


        }
        return pointOfLines;
    }


    public List<PointOfLine> getListOfAllDiagonalPoints() {
        List<PointOfLine> diagonalPointsOfLines = new ArrayList<>();
        int pointCordinateIterator_X = pointOfLine_1.getX();
        int pointCordinateIterator_Y = pointOfLine_1.getY();

        boolean isDiagonalAscending = pointOfLine_1.getY() < pointOfLine_2.getY();

        if (isDiagonal) {

            if (isDiagonalAscending) {

                while (pointCordinateIterator_X <= pointOfLine_2.getX()) {
                    PointOfLine pointOfLine = new PointOfLine(pointCordinateIterator_X, pointCordinateIterator_Y);
                    pointCordinateIterator_X++;
                    pointCordinateIterator_Y++;
                    diagonalPointsOfLines.add(pointOfLine);
                }
            } else {
                while (pointCordinateIterator_X <= pointOfLine_2.getX()) {
                    PointOfLine pointOfLine = new PointOfLine(pointCordinateIterator_X, pointCordinateIterator_Y);
                    pointCordinateIterator_X++;
                    pointCordinateIterator_Y--;
                    diagonalPointsOfLines.add(pointOfLine);
                }
            }
        }
        return diagonalPointsOfLines;
    }


}
