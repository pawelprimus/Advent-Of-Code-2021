package primus.pawel.DAY_05;

class PointOfGrid {

    private final int x;
    private final int y;
    private int countOfSelected;

    PointOfGrid(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.countOfSelected = 0;
    }

    void addCountOfSelected() {
        this.countOfSelected++;
    }

    int getCountOfSelected() {
        return countOfSelected;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + " - " + countOfSelected + "]";
    }

}
