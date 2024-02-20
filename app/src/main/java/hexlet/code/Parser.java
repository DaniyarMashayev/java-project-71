package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parseData(String content, ObjectMapper fileType) throws Exception {
        return fileType.readValue(content, new TypeReference<>() { });
    }
}
