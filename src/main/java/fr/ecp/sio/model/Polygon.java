package fr.ecp.sio.model;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Polygon extends Shape {

    private List<Point> points;

    public Polygon(List<Point> points) {
        super(null);
        this.points = points;
    }

    public Polygon(Point... points) {
        this(Arrays.asList(points));
    }

    public double getArea() {
        return 0;
    }

    public Point getCenter() {
        return null;
    }

    public void paint(Graphics g) {
        int[] x = new int[points.size()];
        int[] y = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            x[i] = p.getX();
            y[i] = p.getY();
        }
        g.drawPolygon(x, y, points.size());
    }
}
