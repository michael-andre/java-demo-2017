package fr.ecp.sio.model;

public abstract class Shape implements Paintable {

    public int x;
    public int y;

    @Override
    public String toString() {
        return "toString() de Shape/n"
                + super.toString();
    }

    public abstract double getArea();

}
