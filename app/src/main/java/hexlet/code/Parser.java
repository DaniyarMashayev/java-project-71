package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parseData(String content, String fileExtension) throws Exception {
        if (!fileExtension.equals("json") && !fileExtension.equals("yml")) {
            throw new Exception("The file must have json, yaml or yml extension");
        }
        ObjectMapper objectMapper = null;
        if (fileExtension.equals("json")) {
            objectMapper = new JsonMapper();
        }
        if (fileExtension.equals("yml")) {
            objectMapper = new YAMLMapper();
        }
        return objectMapper.readValue(content, new TypeReference<>() { });
    }
}
