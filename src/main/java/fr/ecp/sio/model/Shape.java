package fr.ecp.sio.model;

public abstract class Shape implements Paintable {

    private Point origin;

    public Shape(int x, int y) {
        this(new Point(x, y));
    }

    public Shape(Point origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "toString() de Shape/n"
                + super.toString();
    }

    public abstract double getArea();

    public abstract Point getCenter();

    public int getX() {
        return origin.getX();
    }

    public void setX(int x) {
        this.origin.setX(x);
    }

    public int getY() {
        return origin.getY();
    }

    public void setY(int y) {
        this.origin.setY(y);
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

}
