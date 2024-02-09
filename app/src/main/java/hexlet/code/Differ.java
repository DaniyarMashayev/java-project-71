package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.Formatter.getFormatStyle;
import static hexlet.code.GenerateDifference.getDiff;

public class Differ {
    public static String generate(String file1, String file2, String format) throws Exception {
        List<Map<String, Object>> diff = getDiff(file1, file2);
        return getFormatStyle(diff, format);
    }
    public static String generate(String file1, String file2) throws Exception {
        return generate(file1, file2, "stylish");
    }
}
