package utilities;

public class Coord {
    private int x;
    private int y;
    private int floor;

    public Coord(int x, int y, int floor) {
        this.x = x;
        this.y = y;
        this.floor = floor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
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
    }
}
