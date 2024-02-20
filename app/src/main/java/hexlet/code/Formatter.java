package hexlet.code;

import static hexlet.code.formatters.Stylish.formatStylish;
import static hexlet.code.formatters.Plain.formatPlain;
import static hexlet.code.formatters.Json.formatJson;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String getFormatStyle(List<Map<String, Object>> diff, String format) throws Exception {
        return switch (format) {
            case "stylish" -> formatStylish(diff);
            case "plain" -> formatPlain(diff);
            case "json" -> formatJson(diff);
            default -> throw new RuntimeException("Format " + format + " is not correct");
        };
    }
}
