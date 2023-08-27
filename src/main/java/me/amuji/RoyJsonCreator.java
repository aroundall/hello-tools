package me.amuji;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RoyJsonCreator implements JsonCreator {

    @Override
    public JsonCreator put(String path, Object value) {
        return null;
    }

    @Override
    public JSONObject create() {
        return null;
    }

    public Object from(String path, Object value) {
        assert path != null;
        JSONObject result = new JSONObject();

        List<Element> elements = Path.of(path).elements();
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(0);
            if (element.isArray()) {

            }
        }

        return result;
    }

    public static class Path {
        private String path;
        private List<Element> elements = new ArrayList<>();

        public List<Element> elements() {
            return elements;
        }

        private Path(String path) {
            this.path = path;
            for (String name : path.split("\\.")) {
                elements.add(Element.of(name));
            }
        }

        public static Path of(String path) {
            return new Path(path);
        }
    }

    public static class Element {
        private String orgiName;
        private String name;
        private boolean array;
        private Integer arrayIndex = null;

        public String name() {
            return this.name;
        }

        public boolean isArray() {
            return orgiName.contains("[");
        }

        public Integer arrayIndex() {
            return arrayIndex;
        }

        private Element(String name) {
            assert name != null;

            orgiName = name;

            if (name.contains("[")) {
                array = true;
                arrayIndex = Integer.valueOf(name.substring(name.indexOf('[') + 1, name.indexOf(']')));
                this.name = name.substring(0, name.indexOf('['));
            } else {
                this.name = name;
            }
        }

        public static Element of(String name) {
            return new Element(name);
        }
    }
}
