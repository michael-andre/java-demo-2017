package fr.ecp.sio.ui;

import java.awt.*;
import java.util.List;

/**
 * A custom swing {@link Component} to display {@link Paintable} objects.
 */
public class DrawingCanvas extends Canvas {

    // Hold a list of objects to display;
    // The variable is final, its reference cannot be changed after the constructor is called.
    // But the CONTENT of the list itself can be changed (add, remove...).
    private final List<Paintable> paintables;

    public DrawingCanvas(List<Paintable> paintables) {
        // final attributes need to be given a value in the constructor.
        this.paintables = paintables;
    }

    // The Canvas documentation indicates that we must override this method to perform the drawing.
    // We will not call it ourselves, it will be called by the Swing framework when needed (window resize, etc.).
    @Override
    public void paint(Graphics g) {
        // Call super implementation (draws the background).
        super.paint(g);
        // Then delegate the drawing to each Paintable.
        for (Paintable item : paintables) {
            item.paint(g);
        }
    }

}
