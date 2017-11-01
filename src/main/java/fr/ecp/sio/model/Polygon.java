package fr.ecp.sio.model;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * A polygon defined by a list of {@link Point}s.
 */
public class Polygon extends Shape {

    // A polygon if defined by a list of points.
    // We declare the field as a List (interface) because we are ony interested in using its capabilities.
    // Be we have to initialize it with a concrete class which implements List (ArrayList).
    // The value of the list won't change after instantiation, it can be declared af 'final'.
    private final List<Point> points;

    public Polygon(List<Point> points) {
        // We don't use the origin is the case of a polygon.
        super(null);
        this.points = points;
    }

    // Convenience constructor to directly pass Points as parameters.
    public Polygon(Point... points) {
        this(Arrays.asList(points));
    }

    public double getArea() {
        // TODO?
        return 0;
    }

    public Point getCenter() {
        // TODO?
        return null;
    }

    public void paint(Graphics g) {
        // The drawing of the polygon requires a bit of manipulations.
        // The drawPolygon() method on g needs arrays of coordinates, so we need to build them.
        int size = points.size();
        int[] x = new int[size];
        int[] y = new int[size];
        for (int i = 0; i < size; i++) {
            Point p = points.get(i);
            x[i] = p.getX();
            y[i] = p.getY();
        }
        g.drawPolygon(x, y, size);
    }
}
