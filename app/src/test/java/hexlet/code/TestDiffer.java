package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

public class TestDiffer {

    @Test
    public void testGenerate() throws IOException {
        Differ differ = new Differ();

        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";

        String expected = "{\n"
                + "  - proxy: \"123.234.53.22\"\n"
                + "  - follow: false\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "    host: \"hexlet.io\"\n"
                + "}";

        String result = differ.generate(filePath1, filePath2);
        assertEquals(expected, result);
    }

    @Test
    public void testFileNotFound() {
        Differ differ = new Differ();

        String filePath1 = "src/test/resources/nonexistentfile.json";
        String filePath2 = "src/test/resources/file2.json";

        assertThrows(IllegalArgumentException.class, () -> {
            differ.generate(filePath1, filePath2);
        });
    }

    @Test
    public void testInvalidJsonFile() {
        Differ differ = new Differ();

        String filePath1 = "src/test/resources/invalidfile.json";
        String filePath2 = "src/test/resources/file2.json";

        assertThrows(IOException.class, () -> {
            differ.generate(filePath1, filePath2);
        });
    }

    @Test
    public void testIdenticalFiles() throws IOException {
        Differ differ = new Differ();

        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file1.json";

        String expected = "{\n"
                + "    host: \"hexlet.io\"\n"
                + "    timeout: 50\n"
                + "    proxy: \"123.234.53.22\"\n"
                + "    follow: false\n"
                + "}";

        String result = differ.generate(filePath1, filePath2);
        assertEquals(expected, result);
    }

    @Test
    public void testDifferentKeys() throws IOException {
        Differ differ = new Differ();

        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file3.json";

        String expected = "{\n"
                + "  - proxy: \"123.234.53.22\"\n"
                + "  - follow: false\n"
                + "  - timeout: 50\n"
                + "  + timeout: 30\n"
                + "  + verbose: true\n"
                + "  + newKey: \"newValue\"\n"
                + "    host: \"hexlet.io\"\n"
                + "}";

        String result = differ.generate(filePath1, filePath2);
        assertEquals(expected, result);
    }
}
