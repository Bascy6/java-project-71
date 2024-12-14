package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DifferTest {

    @Test
    public void testGenerateDiffJsonPlain() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected_plain.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "plain"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffYmlPlain() throws Exception {
        String filePath1 = "src/test/resources/file1.yml";
        String filePath2 = "src/test/resources/file2.yml";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected_plain.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "plain"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffJsonStylish() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected_stylish.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "stylish"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffYmlStylish() throws Exception {
        String filePath1 = "src/test/resources/file1.yml";
        String filePath2 = "src/test/resources/file2.yml";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected_stylish.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "stylish"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffJsonWithNullValues() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected_plain.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "plain"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffYmlWithNullValues() throws Exception {
        String filePath1 = "src/test/resources/file1.yml";
        String filePath2 = "src/test/resources/file2.yml";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected_plain.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "plain"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffJsonWithAddedValues() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected_plain.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "plain"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffYmlWithAddedValues() throws Exception {
        String filePath1 = "src/test/resources/file1.yml";
        String filePath2 = "src/test/resources/file2.yml";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected_plain.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "plain"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffJsonWithRemovedValues() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected_plain.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "plain"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffYmlWithRemovedValues() throws Exception {
        String filePath1 = "src/test/resources/file1.yml";
        String filePath2 = "src/test/resources/file2.yml";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected_plain.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "plain"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffJsonWithUpdatedValues() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected_plain.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "plain"));
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateDiffYmlWithUpdatedValues() throws Exception {
        String filePath1 = "src/test/resources/file1.yml";
        String filePath2 = "src/test/resources/file2.yml";
        String expected = normalize(Files.readString(Paths.get("src/test/resources/expected_plain.txt")));
        String result = normalize(Differ.generateDiff(filePath1, filePath2, "plain"));
        assertEquals(expected, result);
    }

    private String normalize(String input) {
        return input.replaceAll("\\r\\n|\\r|\\n", "\n").trim();
    }
}
