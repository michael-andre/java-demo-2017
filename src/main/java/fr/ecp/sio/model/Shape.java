package fr.ecp.sio.model;

import fr.ecp.sio.ui.Paintable;

/**
 * A base class for all shapes.
 */
// This class has to be declared abstract because it has at least one abstract method.
// As a consequence, this class cannot be instantiated (new Shape()), it can only be subclassed.
// This class also implements Paintable but does not provide an implementation for paint(): subclasses will have to do it.
public abstract class Shape implements Paintable {

    // Here we declare properties common to all shapes.
    // Properties are strongly typed (declared with a type) and can optionally be given a default value.
    // Properties could be public to be accessible/visible from outside of the package (in Demos.main() for instance)...
    // ...but we choose to encapsulate them as private fields with public getters and setters.
    private Point origin;

    // A constructor for Shape that will initialize the origin field with the provided value.
    // Since we have at least one constructor explicitly defined in Shape, the default implicit public no-arg one is not available.
    public Shape(Point origin) {
        // When a local variable has the same name as an attribute, when use this.* to disambiguate.
        this.origin = origin;
    }

    // A convenience constructor that forwards to the other.
    public Shape(int x, int y) {
        this(new Point(x, y));
    }

    /**
     * Compute the area of the shape.
     * @return The area.
     */
    // This method is abstract: is has only a declaration and no implementation (body).
    // The implementation must be provided by each subclass, they will have to @Override this method.
    public abstract double getArea();

    /**
     * Compute the center of the shape.
     * @return The {@link Point} at the center of the shape.
     */
    public abstract Point getCenter();

    // A getter hides the implementation & storage from the outside (encapsulation).
    public int getX() {
        return origin.getX();
    }

    // A setter hides the implementation & storage from the outside (encapsulation).
    public void setX(int x) {
        this.origin.setX(x);
    }

    public int getY() {
        return origin.getY();
    }

    public void setY(int y) {
        this.origin.setY(y);
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    // This class already have a toString() method, inherited for the implicit parent class Object.
    // But we can redeclare it here to customize the output.
    @Override
    public String toString() {
        return "toString() de Shape/n"
                + super.toString();
    }


}
