package primus.pawel.DAY_05;

import java.util.ArrayList;
import java.util.List;

class Grid {

    List<PointOfGrid> pointOfGridList = new ArrayList<>();

    Grid() {
        initalizeGrid();
    }

    private void initalizeGrid() {
        for (int i = 1; i <= 999; i++) {
            for (int j = 1; j <= 999; j++) {
                PointOfGrid pointOfGrid = new PointOfGrid(i, j);
                this.pointOfGridList.add(pointOfGrid);
            }
        }
    }

    public void printGridPoints() {
        for (PointOfGrid pointOfGrid : pointOfGridList) {
            System.out.println(pointOfGrid.toString());
        }
    }

    public int getCountOverlaps() {
        int overlaps = 0;
        for (PointOfGrid pointOfGrid : pointOfGridList) {
            if(pointOfGrid.getCountOfSelected() >= 2){
                overlaps++;
            }
        }
        return overlaps;
    }

    void selectPointFromList(List<PointOfLine> pointOfLines) {
        for (PointOfLine pointOfLine : pointOfLines) {

            for (PointOfGrid pointOfGrid : pointOfGridList) {
                if(pointOfGrid.getX() == pointOfLine.getX() && pointOfGrid.getY() == pointOfLine.getY()){
                    pointOfGrid.addCountOfSelected();
                }
            }
        }


    }


}
