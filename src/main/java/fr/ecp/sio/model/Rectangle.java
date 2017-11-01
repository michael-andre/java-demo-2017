package fr.ecp.sio.model;

import java.awt.*;

/**
 * A rectangular {@link Shape}.
 */
// This class inherits from Shape (all properties and methods from Shape and its parent are available).
// It is NOT abstract, as a consequence it has to implement all abstract methods from Shape (and Paintable).
public class Rectangle extends Shape {

    // A constant is always static and final.
    public static final int BIG_WIDTH = 300;

    private int width;
    private int height;

    public Rectangle(Point origin, int width, int height) {
        // We explicitly call the constructor of Shape that takes a Point.
        // super() must be the first statement in a constructor
        super(origin);
        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // The getArea() method is an declared in Shape as an abstract method.
    // We re-declare is here with the @Override annotation to provide the implementation for a Rectangle.
    public double getArea() {
        return width * height;
    }

    @Override
    public Point getCenter() {
        return new Point(getX() + getWidth() / 2, getY() + getHeight() / 2);
    }

    @Override
    public void paint(Graphics g) {
        // Luckily Graphics has a drawRect() method whose parameters match our fields.
        g.drawRect(getX(), getY(), width, height);
    }

    @Override
    public String toString() {
        return "Rectangle { x= " + getX() + ", y= " + getY() + ", height= " + height + ", width= " + width + " }";
    }

}
