package me.amuji;

import org.json.JSONObject;

public interface JsonCreator {
    JsonCreator put(String path, Object value);

    JSONObject create();

}
