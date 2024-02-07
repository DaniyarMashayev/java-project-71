package hexlet.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import static hexlet.code.Parser.parseData;
import static hexlet.code.Formatter.getFormatStyle;

public class Differ {
    public static String generate(String file1, String file2, String format) throws Exception {
        List<Map<String, Object>> diff = getDiff(file1, file2);
        return getFormatStyle(diff, format);
    }
    public static String generate(String file1, String file2) throws Exception {
        return generate(file1, file2, "stylish");
    }
    public static List<Map<String, Object>> getDiff(String file1, String file2) throws Exception {
        List<Map<String, Object>> diff = new ArrayList<>();
        Map<String, Object> map1 = parseData(file1);
        Map<String, Object> map2 = parseData(file2);
        Set<String> keys1 = keysFromMap(map1);
        Set<String> keys2 = keysFromMap(map2);
        Set<String> sortedKeys = getSortedKeys(keys1, keys2);
        for (String key : sortedKeys) {
            Map<String, Object> map = new LinkedHashMap<>();
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("status", "removed");
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                map.put("key", key);
                map.put("newValue", map2.get(key));
                map.put("status", "added");
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("newValue", map2.get(key));
                map.put("status", "changed");
            } else {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("status", "unchanged");
            }
            diff.add(map);
        }
        return diff;
    }

    private static Set<String> keysFromMap(Map<String, Object> map) {
        Set<String> keys = new HashSet<>();
        for (Map.Entry<String, Object> key : map.entrySet()) {
            keys.add(key.getKey());
        }
        return keys;
    }

    private static Set<String> getSortedKeys(Set<String> keys1, Set<String> keys2) {
        keys1.addAll(keys2);
        return keys1.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
