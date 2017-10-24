package fr.ecp.sio.model;

import java.awt.*;

public class Circle extends Shape {

    public int radius;

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public void paint(Graphics g) {
        g.drawOval(x, y, radius * 2, radius * 2);
    }
}
