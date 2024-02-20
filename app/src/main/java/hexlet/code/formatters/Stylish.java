package hexlet.code.formatters;


import java.util.Map;
import java.util.List;

public class Stylish {
    public static String formatStylish(List<Map<String, Object>> diff) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (Map<String, Object> map : diff) {
            if (map.get("status").equals("removed")) {
                result.append("  - " + map.get("key") + ": " + map.get("oldValue") + "\n");
            }
            if (map.get("status").equals("added")) {
                result.append("  + " + map.get("key") + ": " + map.get("newValue") + "\n");
            }
            if (map.get("status").equals("changed")) {
                result.append("  - " + map.get("key") + ": " + map.get("oldValue") + "\n");
                result.append("  + " + map.get("key") + ": " + map.get("newValue") + "\n");
            }
            if (map.get("status").equals("unchanged")) {
                result.append("    " + map.get("key") + ": " + map.get("oldValue") + "\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
