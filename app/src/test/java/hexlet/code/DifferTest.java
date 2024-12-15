package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DifferTest {

    @Test
    public void testGenerateDiffJsonPlain() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected/expected_plain.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "plain"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffYmlPlain() throws Exception {
        String filePath1 = "src/test/resources/file1.yml";
        String filePath2 = "src/test/resources/file2.yml";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected/expected_plain.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "plain"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffJsonStylish() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected/expected_stylish.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "stylish"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffYmlStylish() throws Exception {
        String filePath1 = "src/test/resources/file1.yml";
        String filePath2 = "src/test/resources/file2.yml";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected/expected_stylish.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "stylish"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffJsonJson() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected/expected_json.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "json"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffYmlJson() throws Exception {
        String filePath1 = "src/test/resources/file1.yml";
        String filePath2 = "src/test/resources/file2.yml";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected/expected_json.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "json"));
        assertEquals(expected, result);
    }

    @Test
    public void testFileNotFound() {
        String filePath1 = "src/test/resources/nonexistent_file.json";
        String filePath2 = "src/test/resources/file2.json";
        assertThrows(IllegalArgumentException.class, () -> Differ.generateDiff(filePath1, filePath2, "stylish"));
    }

    @Test
    public void testUnsupportedFormat() {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        assertThrows(IllegalArgumentException.class, () -> Differ.generateDiff(filePath1, filePath2, "unsupported"));
    }

    @Test
    public void testUnsupportedFileExtension() {
        String filePath1 = "src/test/resources/file1.txt";
        String filePath2 = "src/test/resources/file2.json";
        assertThrows(IllegalArgumentException.class, () -> Differ.generateDiff(filePath1, filePath2, "stylish"));
    }

    private String normalize(String input) {
        return input.replaceAll("\\r\\n|\\r|\\n", "\n").trim();
    }
}
