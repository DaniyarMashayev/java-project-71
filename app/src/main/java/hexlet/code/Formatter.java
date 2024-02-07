package hexlet.code;

import static hexlet.code.formatters.Stylish.getFormatStylish;
import static hexlet.code.formatters.Plain.getFormatPlain;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String getFormatStyle(List<Map<String, Object>> diff, String format) {
        return switch (format) {
            case "stylish" -> getFormatStylish(diff);
            case "plain" -> getFormatPlain(diff);
            default -> throw new RuntimeException("Format " + format + " is not correct");
        };
    }
}