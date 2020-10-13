package utilities;

public class Coord {
    private int x;
    private int y;
    private int floor;

    public Coord(int x, int y, int floor) {
        this.x = x;
        this.y = y;
        this.floor = floor;
        sanityCheck();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        sanityCheck();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        sanityCheck();
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
        sanityCheck();
    }

    public void moveX(int dx) {
        x += dx;
    }

    public void moveY(int dy) {
        y += dy;
    }

    public void move(int dx, int dy) {
        moveX(dx);
        moveY(dy);
        sanityCheck();
    }

    public void add(Coord coord) {
        floor += coord.getFloor();
        y += coord.getY();
        x += coord.getX();
        sanityCheck();

    }

    private void sanityCheck() {
        /* doesnt work right now, dont know why
        floor = Math.min(floor, 2);
        floor = Math.max(floor, 0);
        x = Math.min(x, 5);
        x = Math.max(x, 0);
        y = Math.min(y, 5);
        y = Math.max(y, 0);
        */

    }
}
