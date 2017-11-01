package fr.ecp.sio.gson;

import com.google.gson.*;
import fr.ecp.sio.model.Point;
import fr.ecp.sio.model.Shape;

import java.lang.reflect.Type;

/**
 * A class to help the Gson library to handle the {@link Shape} class.
 * It has to be registered in the GsonBuilder.
 * It will receive the JSON a instantiate the correct subclass according to the {@code type} key.
 */
public class ShapeAdapter implements JsonDeserializer<Shape> {

    // This method if from JsonDeserializer.
    // Gson will call it with a JsonElement that corresponds to the JSON tree for a single shape.
    @Override
    public Shape deserialize(JsonElement e, Type shapeClass, JsonDeserializationContext context) throws JsonParseException {

        // The JSON tree must be an object for a shape, this method will do the cast.
        JsonObject obj = e.getAsJsonObject();

        // Extract the "type" key from the JSON tree.
        String type = obj.get("type").getAsString();
        Shape shape;
        try {
            // Try to get the Class that has the name of the type, in the model package.
            Type subClass = Class.forName(Shape.class.getPackage().getName() + "." + type);
            // Now that we have the concrete type, we can delegate to the Gson library with it.
            shape = context.deserialize(e, subClass);
        } catch (ClassNotFoundException e1) {
            // If the class is not found, wrap an rethrow the error.
            throw new JsonParseException(e1);
        }

        // The Shape has no "x" and "y" properties, so the origin won't be set automatically.
        // Put we can ask Gson to generate the origin directly from the JSON tree.
        if (shape.getOrigin() == null) {
            Point origin = context.deserialize(e, Point.class);
            shape.setOrigin(origin);
        }

        return shape;
    }

}
