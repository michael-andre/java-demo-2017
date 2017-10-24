package fr.ecp.sio.model;

import java.awt.*;

public class Rectangle extends Shape {

    public static final int BIG_WIDTH = 300;

    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point origin, int width, int height) {
        super(origin);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle { x= " + getX() + ", y= " + getY() + ", height= " + height + ", width= " + width + " }";
    }

    public double getArea() {
        return width * height;
    }

    @Override
    public Point getCenter() {
        return new Point(getX() + getWidth() / 2, getY() + getHeight() / 2);
    }

    public void paint(Graphics g) {
        g.drawRect(getX(), getY(), width, height);
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

}
