package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GenerateDifference {
    public static List<Map<String, Object>>
        getDiff(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> diff = new ArrayList<>();
        Set<String> sortedKeys = getSortedKeys(map1, map2);
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

    private static Set<String> getSortedKeys(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keys1 = keysFromMap(map1);
        Set<String> keys2 = keysFromMap(map2);
        keys1.addAll(keys2);
        return keys1.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
