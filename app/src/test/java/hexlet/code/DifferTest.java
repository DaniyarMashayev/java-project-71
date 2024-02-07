package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DifferTest {
    @Test
    public void testGenerateJsonStylish() throws Exception {
        StringBuilder expected = new StringBuilder();
        expected.append("{\n");
        expected.append("    " + "chars1: [a, b, c]" + "\n");
        expected.append("  - " + "chars2: [d, e, f]" + "\n");
        expected.append("  + " + "chars2: false" + "\n");
        expected.append("  - " + "checked: false" + "\n");
        expected.append("  + " + "checked: true" + "\n");
        expected.append("  - " + "default: null" + "\n");
        expected.append("  + " + "default: [value1, value2]" + "\n");
        expected.append("  - " + "id: 45" + "\n");
        expected.append("  + " + "id: null" + "\n");
        expected.append("  - " + "key1: value1" + "\n");
        expected.append("  + " + "key2: value2" + "\n");
        expected.append("    " + "numbers1: [1, 2, 3, 4]" + "\n");
        expected.append("  - " + "numbers2: [2, 3, 4, 5]" + "\n");
        expected.append("  + " + "numbers2: [22, 33, 44, 55]" + "\n");
        expected.append("  - " + "numbers3: [3, 4, 5]" + "\n");
        expected.append("  + " + "numbers4: [4, 5, 6]" + "\n");
        expected.append("  + " + "obj1: {nestedKey=value, isNested=true}" + "\n");
        expected.append("  - " + "setting1: Some value" + "\n");
        expected.append("  + " + "setting1: Another value" + "\n");
        expected.append("  - " + "setting2: 200" + "\n");
        expected.append("  + " + "setting2: 300" + "\n");
        expected.append("  - " + "setting3: true" + "\n");
        expected.append("  + " + "setting3: none" + "\n");
        expected.append("}");
        String file1 = "src/test/resources/file1-1.json";
        String file2 = "src/test/resources/file2-2.json";
        String actual = Differ.generate(file1, file2, "stylish");
        assertEquals(expected.toString(), actual);
    }
    @Test
    public void testGenerateYamlStylish() throws Exception {
        StringBuilder expected = new StringBuilder();
        expected.append("{\n");
        expected.append("    " + "chars1: [a, b, c]" + "\n");
        expected.append("  - " + "chars2: [d, e, f]" + "\n");
        expected.append("  + " + "chars2: false" + "\n");
        expected.append("  - " + "checked: false" + "\n");
        expected.append("  + " + "checked: true" + "\n");
        expected.append("  - " + "default: null" + "\n");
        expected.append("  + " + "default: [value1, value2]" + "\n");
        expected.append("  - " + "id: 45" + "\n");
        expected.append("  + " + "id: null" + "\n");
        expected.append("  - " + "key1: value1" + "\n");
        expected.append("  + " + "key2: value2" + "\n");
        expected.append("    " + "numbers1: [1, 2, 3, 4]" + "\n");
        expected.append("  - " + "numbers2: [2, 3, 4, 5]" + "\n");
        expected.append("  + " + "numbers2: [22, 33, 44, 55]" + "\n");
        expected.append("  - " + "numbers3: [3, 4, 5]" + "\n");
        expected.append("  + " + "numbers4: [4, 5, 6]" + "\n");
        expected.append("  + " + "obj1: {nestedKey=value, isNested=true}" + "\n");
        expected.append("  - " + "setting1: Some value" + "\n");
        expected.append("  + " + "setting1: Another value" + "\n");
        expected.append("  - " + "setting2: 200" + "\n");
        expected.append("  + " + "setting2: 300" + "\n");
        expected.append("  - " + "setting3: true" + "\n");
        expected.append("  + " + "setting3: none" + "\n");
        expected.append("}");
        String file1 = "src/test/resources/file1-1.yml";
        String file2 = "src/test/resources/file2-2.yml";
        String actual = Differ.generate(file1, file2, "stylish");
        assertEquals(expected.toString(), actual);
    }
    @Test
    public void testGenerateJsonPlain() throws Exception {
        StringBuilder expected = new StringBuilder();
        expected.append("Property 'chars2' was updated. From [complex value] to false" + "\n");
        expected.append("Property 'checked' was updated. From false to true" + "\n");
        expected.append("Property 'default' was updated. From null to [complex value]" + "\n");
        expected.append("Property 'id' was updated. From 45 to null" + "\n");
        expected.append("Property 'key1' was removed" + "\n");
        expected.append("Property 'key2' was added with value: 'value2'" + "\n");
        expected.append("Property 'numbers2' was updated. From [complex value] to [complex value]" + "\n");
        expected.append("Property 'numbers3' was removed" + "\n");
        expected.append("Property 'numbers4' was added with value: [complex value]" + "\n");
        expected.append("Property 'obj1' was added with value: [complex value]" + "\n");
        expected.append("Property 'setting1' was updated. From 'Some value' to 'Another value'" + "\n");
        expected.append("Property 'setting2' was updated. From 200 to 300" + "\n");
        expected.append("Property 'setting3' was updated. From true to 'none'" + "\n");
        String file1 = "src/test/resources/file1-1.json";
        String file2 = "src/test/resources/file2-2.json";
        String actual = Differ.generate(file1, file2, "plain");
        assertEquals(expected.toString(), actual);
    }
}
