package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DifferTest {

    @Test
    public void testUnsupportedFormat() {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";

        assertThrows(IllegalArgumentException.class, () -> {
            Differ.generateDiff(filePath1, filePath2, "unsupported");
        });
    }

    @Test
    public void testFileNotFound() {
        String filePath1 = "src/test/resources/nonexistentfile.json";
        String filePath2 = "src/test/resources/file2.json";

        assertThrows(IllegalArgumentException.class, () -> {
            Differ.generateDiff(filePath1, filePath2, "stylish");
        });
    }

    @Test
    public void testUnsupportedFileFormat() {
        String filePath1 = "src/test/resources/file1.txt";
        String filePath2 = "src/test/resources/file2.json";

        assertThrows(IllegalArgumentException.class, () -> {
            Differ.generateDiff(filePath1, filePath2, "stylish");
        });
    }
}
