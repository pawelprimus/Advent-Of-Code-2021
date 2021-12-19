package primus.pawel.DAY_05;

class PointOfLine {

    private final int x;
    private final int y;

    PointOfLine(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
