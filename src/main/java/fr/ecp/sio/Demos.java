package fr.ecp.sio;

import fr.ecp.sio.model.Circle;
import fr.ecp.sio.model.Paintable;
import fr.ecp.sio.model.Point;
import fr.ecp.sio.model.Rectangle;
import fr.ecp.sio.model.Shape;
import fr.ecp.sio.ui.DrawingCanvas;
import org.w3c.dom.css.Rect;
import sun.security.provider.SHA;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demos {

    public static void main(String[] args) {

        // Define some shapes
        Rectangle rect1 = new Rectangle(50, 60, 400, 300);
        Circle circle1 = new Circle(100, 100, 100);
        //circle1.setY(100);
        //circle1.getOrigin().setY(200);
        circle1.getCenter().setY(300);

        DrawingCanvas panel = new DrawingCanvas();
        panel.shapes = new ArrayList<Paintable>();
        panel.shapes.add(rect1);
        panel.shapes.add(circle1);

        // UI classes are provided in the javax.swing.* package.
        // We create a window, give it a size, add the panel (the default is fullscreen) and display it.
        JFrame window = new JFrame("Photoshop");
        window.setSize(640, 480);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(panel);
        window.setVisible(true);









        /*int a = 2;
        long b;
        b = 3;
        float c = 2.37f;
        char d = 'e';
        double e = b / 3.;
        b = (long) c;
        b = Math.round(c);

        String helloWorld = "Hello " + "world!";
        System.out.println(helloWorld);

        if (a == 2) {
            System.out.println("a is 2");
        } else if (a == 3) {

        }
        if (helloWorld.contains("r")) {
            System.out.println("helloWorld contains r");
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("loop: " + i);
            if (i == 2) break;
        }

        switch (a) {
            case 1:
            case 2:
                System.out.println("a is 2 or 1");
                break;
            case 3:
                System.out.println("a is 3");
                break;
        }

        Shape r1 = new Rectangle();
        r1.x = 40;
        r1.y = 20;
        r1.width = 20;
        r1.height = 40;

        int area = r1.getArea();

        Rectangle r2 = new Rectangle();
        r2.x = 30;
        r2.y = 60;
        r2.width = 20;
        r2.height = 80;

        Rectangle[] rects = new Rectangle[2];
        rects[0] = r1;
        rects[1] = r2;
        boolean[] bools = new boolean[] { true, false };
        int[] ints = { 12, 56 };

        r2.height = 400;
        Rectangle r = rects[1];
        System.out.println("Height is " + r.height);
        r2.height = 500;
        System.out.println("Height is " + r.height);

        boolean eq = r1.equals(r2);

        int t = 3;
        int[] test = { t };
        t = 2;
        System.out.println("Test is " + test[0]);

        List<Shape> list = new ArrayList<Shape>();
        list.add(r2);
        Rectangle r4 = (Rectangle) list.get(0);


        System.out.println(r.toString());

        r1.getArea();

        Drawable d = new Rectangle();
        d.draw();
        */

    }

}
