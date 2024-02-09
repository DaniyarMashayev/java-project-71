package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {
    @Test
    public void testGenerateJsonStylish() throws Exception {
        Path pathStylish = Paths.get("src/test/resources/expected/testStylishFormat").toAbsolutePath().normalize();
        String expected = Files.readString(pathStylish);
        String file1 = "src/test/resources/file1.json";
        String file2 = "src/test/resources/file2.json";
        String actual = Differ.generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateYamlStylish() throws Exception {
        Path pathStylish = Paths.get("src/test/resources/expected/testStylishFormat").toAbsolutePath().normalize();
        String expected = Files.readString(pathStylish);
        String file1 = "src/test/resources/file1.yml";
        String file2 = "src/test/resources/file2.yml";
        String actual = Differ.generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateJsonPlain() throws Exception {
        Path pathPlain = Paths.get("src/test/resources/expected/testPlainFormat").toAbsolutePath().normalize();
        String expected = Files.readString(pathPlain);
        String file1 = "src/test/resources/file1.json";
        String file2 = "src/test/resources/file2.json";
        String actual = Differ.generate(file1, file2, "plain");
        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateJson() throws Exception {
        Path pathJson = Paths.get("src/test/resources/expected/testJsonFormat").toAbsolutePath().normalize();
        String expected = Files.readString(pathJson);
        String file1 = "src/test/resources/file1.json";
        String file2 = "src/test/resources/file2.json";
        String actual = Differ.generate(file1, file2, "json");
        assertEquals(expected, actual);
    }
}
