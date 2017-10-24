package fr.ecp.sio.ui;

import fr.ecp.sio.model.Paintable;
import fr.ecp.sio.model.Shape;
import java.awt.*;
import java.util.List;

public class DrawingCanvas extends Canvas {

    public List<Paintable> shapes;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Paintable item : shapes) {
            item.paint(g);
        }
    }

}
