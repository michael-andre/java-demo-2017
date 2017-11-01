package fr.ecp.sio.model;

import java.awt.*;

/**
 * A circular {@link Shape}.
 */
public class Circle extends Shape {

    // Specific to a Circle.
    private int radius;

    public Circle(int centerX, int centerY, int radius) {
        // We can choose the consider that the origin is the center.
        super(centerX - radius,centerY - radius);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    // Implement getArea() abstract method from Shape.
    public double getArea() {
        // The java.lang.Math exposes static methods and constants for maths.
        // Math is a 'helper class': all methods are static and it cannot be instantiated.
        // Classes in java.lang.* package doesn't need an import declaration.
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public Point getCenter() {
        return getOrigin();
    }

    public void paint(Graphics g) {
        // Simply use the drawOval() method from g to display the circle.
        int size = radius * 2;
        g.drawOval(getX(), getY(), size, size);
    }

}
