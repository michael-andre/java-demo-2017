package fr.ecp.sio.gson;

import com.google.gson.*;
import fr.ecp.sio.model.Circle;
import fr.ecp.sio.model.Point;
import fr.ecp.sio.model.Rectangle;
import fr.ecp.sio.model.Shape;

import java.lang.reflect.Type;

public class ShapeAdapter implements JsonDeserializer<Shape> {

    @Override
    public Shape deserialize(JsonElement e, Type shapeClass, JsonDeserializationContext context) throws JsonParseException {

        JsonObject obj = e.getAsJsonObject();
        String type = obj.get("type").getAsString();
        Shape shape = null;
        try {
            Type subClass = Class.forName(Shape.class.getPackage().getName() + "." + type);
            shape = context.deserialize(e, subClass);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        Point origin = context.deserialize(e, Point.class);
        shape.setOrigin(origin);

        return shape;
    }

}
