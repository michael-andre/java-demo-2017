package fr.ecp.sio.model;

import java.awt.*;

public class Circle extends Shape {

    private int radius;

    public Circle(int centerX, int centerY, int radius) {
        super(centerX - radius,centerY - radius);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public Point getCenter() {
        //return new Point(getX(), getY());
        return getOrigin();
    }

    public void paint(Graphics g) {
        int size = radius * 2;
        g.drawOval(getX(), getY(), size, size);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
