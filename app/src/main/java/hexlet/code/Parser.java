package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parseData(String file) throws Exception {
        Path filePath = Paths.get(file).toAbsolutePath().normalize();
        if (!Files.exists(filePath)) {
            throw new Exception("File '" + filePath + "' does not exist");
        }
        String content = Files.readString(filePath);
        ObjectMapper objectMapper = null;
        if (file.endsWith("json")) {
            objectMapper = new JsonMapper();
        }
        if (file.endsWith("yml")) {
            objectMapper = new YAMLMapper();
        }
        return objectMapper.readValue(content, new TypeReference<>() { });
    }
}
