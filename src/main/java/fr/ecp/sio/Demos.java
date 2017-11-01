// Any java class file begins with a package declaration.
// The actual location of the Demos.java file must match the package declaration.
package fr.ecp.sio;

// All classes referenced in the file that doesn't belong to the same package (strictly) require an import.
// Imported classes can then be referred with their 'short' name.
// All classes in java.lang.* package don't need an import, they are directly available.

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import fr.ecp.sio.gson.ShapeAdapter;
import fr.ecp.sio.ui.Paintable;
import fr.ecp.sio.model.Point;
import fr.ecp.sio.model.Rectangle;
import fr.ecp.sio.model.Shape;
import fr.ecp.sio.ui.DrawingCanvas;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class of our demo program.
 */
// Everything is object in Java, so the entry point of this console application must be in a class.
// There is always one class per file, and the filename must match the name of the class.
public class Demos {

    // The main() method is the entry point of our application.
    // It receives an array of strings as a parameters with optional arguments specified on execution.
    public static void main(String[] args) {

        List<Paintable> paintables;

        try {

            // This method may throw IOException (see signature), which is a checked Exception.
            // We must deal with the error case by wrapping the call in a tr-catch statement.
            String content = getUrlContent("https://pastebin.com/raw/HVJYaLPP");
            //content = getUrlContent("https://pastebin.com/raw/BWWS9Xkm");

            System.out.println(content);
            paintables = parsePaintables(content);

        } catch (IOException e) {
            // We get here if an IOException or a InvalidGeometryException is thrown by the above code.
            // Here we simply log the error and terminate the program.
            e.printStackTrace();
            return;
        }

        // Define some paintables.
        /*Rectangle rect1 = new Rectangle(50, 60, 400, 300);
        Circle circle1 = new Circle(100, 100, 100);
        Polygon poly1 = new Polygon(
                new Point(300, 400),
                new Point(500, 300),
                new Point(200, 700)
        );*/

        // Instantiate our custom panel to display the paintables.
        DrawingCanvas panel = new DrawingCanvas(paintables);
        panel.setBackground(java.awt.Color.WHITE);

        // UI classes are provided in the javax.swing.* package.
        // We create a window, give it a size, add the panel (the default is fullscreen) and display it.
        JFrame window = new JFrame("Photoshop");
        window.setSize(640, 480);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(panel);
        window.setVisible(true);

    }

    /***
     * Download the content of a URL and return it as a string.
     * This version only makes use of builtin stream-manipulation classes.
     * @throws IOException if anything goes wrong with the download process.
     ***/
    private static String getUrlContent(String spec) throws IOException {

        // This constructor may throw MalformedUrlException if the "url" parameter is not a valid URL.
        // We don't catch the error here, instead it propagates to the calling method since our signature declares it.
        URL url = new URL(spec);

        // 1. Open a connection to the URL.
        // 2. Get an InputStream from which we can read incoming data (low level function, byte per byte).
        // 3. Create an InputStreamReader that is able to consume the InputStream data an process it.
        // 4. Wrap it into a BufferedReader that adds the ability to read the content line by line thanks to a buffer.
        // ...and put it inside the "()" part of a try-with-resource block to avoid leaking the connection.
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        url.openConnection()/* 1 */
                                .getInputStream()/* 2 */
                )/* 3 */
        )/* 4 */) {

            // It is more efficient to use a StringBuilder rather than String concatenation (+) in a loop.
            StringBuilder sb = new StringBuilder();

            // At this point, no data has been transferred yet!

            // Declare a variable that will hold the content of a line.
            String line;
            // In the same statement, get the next line from the reader, assign it to "line" and check if it is not null.
            // The readLine() call is the one that actually makes the data transfer to happen.
            // This "while" loop will break when the readLine() method will return null (content is all read).
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            // The transfer is done!
            return sb.toString();

            // The Closable.close() method of the reader will be called at the end of the block, even in case of error.
        }
    }

    /***
     * Create a list of Paintable objects from a JSON string, using the Gson library.
     ***/
    private static List<Paintable> parsePaintables(String json) {

        // By default, Gson is able to create objects and assign attributes if their names match the JSON exactly.
        //Gson gson = new Gson();

        // In our case we have to customize it to help it to deserialize concrete Shape subclasses.
        Gson gson = new GsonBuilder()
                // Register an adapter that will be associated to the Shape.class type.
                .registerTypeAdapter(Shape.class, new ShapeAdapter())
                // The library uses the "builder" pattern (each method returns "this", so that we can chain calls).
                .create();

        // To use Gson we have to specify the type of the root object that we want to deserialize.
        // Here we want a list of Shapes, but unfortunately we can't express it as "List<Shape>.class".
        // Instead we use a the TypeToken class, which is the Gson-provided indirection for this case (out of scope!).
        Type returnType = new TypeToken<List<Shape>>() {}.getType();

        // Call the gson library with the JSON string and the wanted type.
        return gson.fromJson(json, returnType);
    }

    // Unused function, just kept here for demo purpose.
    private static void demos() {

        // Manipulation of primitive types.
        int a = 2;
        long b;
        b = 3;
        float c = 2.37f;
        char d = 'e';
        double e = b / 3.;
        b = (long) c;
        // Call a static method of java.lang.Math.
        b = Math.round(c);
        boolean f = true;

        // Implicit casting if no precision loss
        c = a + b;
        // Explicit casting if precision loss
        c = (float) ((a + b) / d);

        // String is a transparent type.
        String helloWorld = "Hello " + "world!";
        // Log to the console.
        System.out.println(helloWorld);

        // Check for conditions.
        if (a == 2) {
            System.out.println("a is 2");
        } else {
            System.out.println("a is not 2");
        }
        if (helloWorld.contains("r")) {
            System.out.println("helloWorld contains r");
        }

        // Basic loop (initialization; break condition; iteration statement).
        for (int i = 0; i < 10; i++) {
            System.out.println("loop: " + i);
            if (i == 2) break;
        }

        // Test multiple cases on a variable (ints and strings).
        switch (a) {
            case 1:
            case 2:
                System.out.println("a is 2 or 1");
                // Don't forget to exit the switch!
                break;
            case 3:
                System.out.println("a is 3");
                break;
        }

        // Instantiate objects with "new", and call a constructor.
        Rectangle r1 = new fr.ecp.sio.model.Rectangle(40, 20, 20, 40);
        // Call methods to change attributes
        r1.setWidth(200);
        r1.setHeight(100);
        r1.setOrigin(new Point(20, 50));

        // Thanks to polymorphism, an instance of Rectangle can be the value of a variable declared as Shape.
        // But only properties & methods declared in Shape are available on s, even if the actual value is a Rectangle.
        Shape s2 = new Rectangle(30, 60, 20, 80);
        // getArea() is available because it is declared in Shape (abstractly), even is the concrete implementation is in Rectangle.
        double area = s2.getArea();

        // It is possible to check a variable for a more precise subclass.
        if (s2 instanceof Rectangle) {
            // Since we checked, we can safely "cast" the variable to a Rectangle an access the specific properties.
            // But this style of coding can lead to runtime errors (vs compile-time errors), so use with caution!
            ((Rectangle) s2).setWidth(200);
        }

        // Declare and create an empty array (fixed size).
        Rectangle[] rects = new Rectangle[2];
        // Assign a value to an array.
        rects[0] = r1;
        // An explicit cast is required here because r2 is only declared as a Shape.
        rects[1] = (Rectangle) s2;
        // Short array initializers.
        boolean[] bools = new boolean[] { true, false };
        int[] ints = { 12, 56 };

        // Objects are stored in an array by reference.
        r1.setHeight(400);
        Rectangle rectFromArray = rects[1];
        System.out.println("Height of r1 is " + r1.getHeight());
        rectFromArray.setHeight(500);
        System.out.println("Height of r1 is " + r1.getHeight());

        // Primitives are stored in an array by value.
        int t = 3;
        int[] test = { t };
        t = 2;
        System.out.println("Array value is " + test[0]);

        // Check equality of objects (only check memory address, except overrided).
        boolean eq = r1.equals(s2);

        // The List interface exposes a generic type parameter.
        // The type parameter defines the signature of methods such as add().
        List<Shape> list = new ArrayList<>();
        list.add(s2);
        list.add(r1);
        list.remove(s2);
        Shape found = list.get(0);

    }

}
