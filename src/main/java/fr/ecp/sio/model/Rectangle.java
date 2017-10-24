package fr.ecp.sio.model;

import java.awt.*;

public class Rectangle extends Shape {

    public static final int BIG_WIDTH = 300;

    public int width;
    public int height;

    @Override
    public String toString() {
        return "Rectangle { x= " + x + ", y= " + y + ", height= " + height + ", width= " + width + " }";
    }

    public double getArea() {
        return width * height;
    }

    public void paint(Graphics g) {
        g.drawRect(x, y, width, height);
    }
}
