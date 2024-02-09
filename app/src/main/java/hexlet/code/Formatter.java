package hexlet.code;

import static hexlet.code.formatters.Stylish.getFormatStylish;
import static hexlet.code.formatters.Plain.getFormatPlain;
import static hexlet.code.formatters.Json.getFormatJson;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String getFormatStyle(List<Map<String, Object>> diff, String format) throws Exception {
        return switch (format) {
            case "stylish" -> getFormatStylish(diff);
            case "plain" -> getFormatPlain(diff);
            case "json" -> getFormatJson(diff);
            default -> throw new RuntimeException("Format " + format + " is not correct");
        };
    }
}
