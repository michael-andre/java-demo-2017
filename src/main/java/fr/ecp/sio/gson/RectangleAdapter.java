package fr.ecp.sio.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import fr.ecp.sio.model.Rectangle;

import java.lang.reflect.Type;

public class RectangleAdapter implements JsonDeserializer<Rectangle> {
    @Override
    public Rectangle deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
