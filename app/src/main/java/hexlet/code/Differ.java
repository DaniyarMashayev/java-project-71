package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

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
        ObjectMapper fileType1 = getFileType(file1);
        ObjectMapper fileType2 = getFileType(file2);
        Map<String, Object> map1 = parseData(dataForParsing1, fileType1);
        Map<String, Object> map2 = parseData(dataForParsing2, fileType2);
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
    private static ObjectMapper getFileType(String file) {
        ObjectMapper objectMapper = null;
        if (file.endsWith("json")) {
            objectMapper = new JsonMapper();
        }
        if (file.endsWith("yml")) {
            objectMapper = new YAMLMapper();
        }
        return objectMapper;
    }
}
