package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static hexlet.code.Formatter.getFormatStyle;
import static hexlet.code.GenerateDifference.getDiff;
import static hexlet.code.Parser.parseData;

public class Differ {
    public static String generate(String file1, String file2, String format) throws Exception {
        String dataForParsing1 = getDataForParsing(file1);
        String dataForParsing2 = getDataForParsing(file2);
        String fileExtension1 = getFileExtension(file1);
        String fileExtension2 = getFileExtension(file2);
        Map<String, Object> map1 = parseData(dataForParsing1, fileExtension1);
        Map<String, Object> map2 = parseData(dataForParsing2, fileExtension2);
        List<Map<String, Object>> diff = getDiff(map1, map2);
        return getFormatStyle(diff, format);
    }
    public static String generate(String file1, String file2) throws Exception {
        return generate(file1, file2, "stylish");
    }

    private static String getDataForParsing(String file) throws Exception {
        Path filePath = Paths.get(file).toAbsolutePath().normalize();
        if (!Files.exists(filePath)) {
            throw new Exception("File '" + filePath + "' does not exist");
        }
        return Files.readString(filePath);
    }
    private static String getFileExtension(String file) {
        String fileExtension = "";
        if (file.endsWith("json")) {
            fileExtension = "json";
        }
        if (file.endsWith("yml") || file.endsWith("yaml")) {
            fileExtension = "yml";
        }
        return fileExtension;
    }
}
