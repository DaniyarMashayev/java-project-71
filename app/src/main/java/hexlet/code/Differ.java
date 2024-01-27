package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Map;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.StringJoiner;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Differ {
    public static String generate(String file1, String file2) throws Exception {
        Map<String, Object> mapFromJson1 = convertJsonToMap(file1);
        Map<String, Object> mapFromJson2 = convertJsonToMap(file2);
        Set<String> keys1 = keysFromMap(mapFromJson1);
        Set<String> keys2 = keysFromMap(mapFromJson2);
        keys1.addAll(keys2);
        Set<String> sortedKeys = keys1.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        StringJoiner result = new StringJoiner(" ", "{\n ", "}");
        for (String key : sortedKeys) {
            if ((mapFromJson1.containsKey(key) && mapFromJson2.containsKey(key))
                    && mapFromJson2.get(key).equals(mapFromJson1.get(key))) {
                result.add(" " + " " + key + ": " + mapFromJson1.get(key) + "\n");
            }
            if ((mapFromJson1.containsKey(key) && mapFromJson2.containsKey(key))
                    && !mapFromJson2.containsValue(mapFromJson1.get(key))) {
                result.add("-" + " " + key + ": " + mapFromJson1.get(key) + "\n");
            }
            if (!mapFromJson2.containsKey((key))) {
                result.add("-" + " " + key + ": "+ mapFromJson1.get(key) + "\n");
            }
            if (mapFromJson2.containsKey(key) && !mapFromJson1.containsKey(key)) {
                result.add("+" + " " + key + ": " + mapFromJson2.get(key) + "\n");
            }
            if (mapFromJson2.containsKey(key) && mapFromJson1.containsKey(key)
                    && !mapFromJson2.get(key).equals(mapFromJson1.get(key))) {
                result.add("+" + " " + key + ": " + mapFromJson2.get(key) + "\n");
            }
        }
        return result.toString();
    }

    private static Set<String> keysFromMap (Map<String, Object> map) {
        Set<String> keys = new HashSet<>();
        for (Map.Entry<String, Object> key : map.entrySet()) {
            keys.add(key.getKey());
        }
        return keys;
    }

    private static Map<String, Object> convertJsonToMap (String jsonFile) throws Exception {
        Path jsonFilePath = Paths.get(jsonFile).toAbsolutePath().normalize();
        if (!Files.exists(jsonFilePath)) {
            throw new Exception("File '" + jsonFilePath + "' does not exist");
        }
        String content = Files.readString(jsonFilePath);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<>(){});
    }
}
