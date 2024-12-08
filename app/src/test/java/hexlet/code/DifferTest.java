package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testGenerateJson() throws IOException {
        String filePath1 = "file1.json";
        String filePath2 = "file2.json";

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        String actual = Differ.generateDiff(filePath1, filePath2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYaml() throws IOException {
        String filePath1 = "file1.yml";
        String filePath2 = "file2.yml";

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        String actual = Differ.generateDiff(filePath1, filePath2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateWithEmptyFile() throws IOException {
        String filePath1 = "file1.json";
        String filePath2 = "empty.json";

        String expected = "{\n"
                + "  - follow: false\n"
                + "  - host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "}";

        String actual = Differ.generateDiff(filePath1, filePath2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateWithIdenticalFiles() throws IOException {
        String filePath1 = "file1.json";
        String filePath2 = "file1.json";

        String expected = "{\n"
                + "    follow: false\n"
                + "    host: hexlet.io\n"
                + "    proxy: 123.234.53.22\n"
                + "    timeout: 50\n"
                + "}";

        String actual = Differ.generateDiff(filePath1, filePath2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateWithDifferentKeys() throws IOException {
        String filePath1 = "file1.json";
        String filePath2 = "file3.json";

        String expected = "{\n"
                + "  - follow: false\n"
                + "  - host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + key3: value3\n"
                + "}";

        String actual = Differ.generateDiff(filePath1, filePath2);
        assertEquals(expected, actual);
    }
}
