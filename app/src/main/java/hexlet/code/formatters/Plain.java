package hexlet.code.formatters;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Plain {
    public static String getFormatPlain(List<Map<String, Object>> diff) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> map : diff) {
            if (map.get("status").equals("changed")) {
                result.append("Property " + "'" + map.get("key") + "'" + " was updated. "
                        + "From " + getComplexValue(map.get("oldValue"))
                        + " to " + getComplexValue(map.get("newValue")) + "\n");
            } else if (map.get("status").equals("added")) {
                result.append("Property " + "'" + map.get("key") + "'"
                        + " was added with value: " + getComplexValue(map.get("newValue")) + "\n");
            } else if (map.get("status").equals("removed")) {
                result.append(("Property " + "'" + map.get("key") + "'" + " was removed" + "\n"));
            }
        }
        return result.toString().strip();
    }

    private static String getComplexValue(Object value) {
        if (value instanceof Map || value instanceof ArrayList<?>) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else if (value == null) {
            return null;
        }
        return value.toString();
    }
}
