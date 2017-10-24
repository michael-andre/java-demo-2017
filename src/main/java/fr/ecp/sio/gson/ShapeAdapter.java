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
        Type subClass = null;
        switch (type) {
            case "Rectangle":
                subClass = Rectangle.class;
                break;
            case "Circle":
                subClass = Circle.class;
                break;
        }
        Shape shape = context.deserialize(e, subClass);

        shape.setOrigin(
                new Point(
                        obj.get("x").getAsInt(),
                        obj.get("y").getAsInt()
                )
        );

        return shape;
    }

}
