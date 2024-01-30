package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

public class DifferTest {
    @Test
    public void testGenerate() throws Exception {
        StringJoiner expected = new StringJoiner(" ", "{\n ", "}");
        expected.add("- follow: false" + "\n");
        expected.add("  host: hexlet.io" + "\n");
        expected.add("- proxy: 123.234.53.22" + "\n");
        expected.add("- timeout: 50" + "\n");
        expected.add("+ timeout: 20" + "\n");
        expected.add("+ verbose: true" + "\n");
        String file1 = "src/test/resources/file1.json";
        String file2 = "src/test/resources/file2.json";
        String actual = Differ.generate(file1, file2);
        assertEquals(expected.toString(), actual);
    }
}
