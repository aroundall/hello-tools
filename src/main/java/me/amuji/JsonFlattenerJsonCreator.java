package me.amuji;

import com.github.wnameless.json.unflattener.JsonUnflattener;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonFlattenerJsonCreator implements JsonCreator {
    private Map<String, Object> map = new HashMap<>();

    @Override
    public JsonCreator put(String path, Object value) {
        map.put(path, value);
        return this;
    }

    @Override
    public JSONObject create() {
        return new JSONObject(JsonUnflattener.unflatten(map));
    }

}
