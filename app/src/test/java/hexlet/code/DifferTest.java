package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {
    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;
    private static String fileJson1;
    private static String fileJson2;
    private static String fileYaml1;
    private static String fileYaml2;
    @BeforeAll
    public static void initFiles() {
        expectedStylish = "src/test/resources/expected/testStylishFormat";
        expectedPlain = "src/test/resources/expected/testPlainFormat";
        expectedJson = "src/test/resources/expected/testJsonFormat";
        fileJson1 = "src/test/resources/fixtures/file1.json";
        fileJson2 = "src/test/resources/fixtures/file2.json";
        fileYaml1 = "src/test/resources/fixtures/file1.yml";
        fileYaml2 = "src/test/resources/fixtures/file2.yml";
    }
    @Test
    public void testGenerateJsonStylish() throws Exception {
        String expected = readingFile(expectedStylish);
        String actual = Differ.generate(fileJson1, fileJson2, "stylish");
        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateYamlStylish() throws Exception {
        String expected = readingFile(expectedStylish);
        String actual = Differ.generate(fileYaml1, fileYaml2, "stylish");
        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateJsonPlain() throws Exception {
        String expected = readingFile(expectedPlain);
        String actual = Differ.generate(fileJson1, fileJson2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYamlPlain() throws Exception {
        String expected = readingFile(expectedPlain);
        String actual = Differ.generate(fileYaml1, fileYaml2, "plain");
        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateJsonJson() throws Exception {
        String expected = readingFile(expectedJson);
        String actual = Differ.generate(fileJson1, fileJson2, "json");
        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateYamlJson() throws Exception {
        String expected = readingFile(expectedJson);
        String actual = Differ.generate(fileYaml1, fileYaml2, "json");
        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateDefaultJsonExtension() throws Exception {
        String expected = readingFile(expectedStylish);
        String actual = Differ.generate(fileJson1, fileJson2);
        assertEquals(expected, actual);
    }
    @Test
    public void testGenerateDefaultYamlExtension() throws Exception {
        String expected = readingFile(expectedStylish);
        String actual = Differ.generate(fileYaml1, fileYaml2);
        assertEquals(expected, actual);
    }

    private static Path getFilePath(String file) {
        return Paths.get(file).toAbsolutePath().normalize();
    }

    private static String readingFile(String file) throws Exception {
        return Files.readString(getFilePath(file));
    }
}
