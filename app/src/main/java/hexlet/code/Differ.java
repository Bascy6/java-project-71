package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.List;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Map<String, Object> map1 = reading(filePath1);
        Map<String, Object> map2 = reading(filePath2);

        List<Map<String, Object>> comparisonResult = DiffTreeBuilder.compareFiles(map1, map2);

        return Formatter.format(comparisonResult, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    private static Map<String, Object> reading(String filePath) throws IOException {
        return Parser.parseFile(filePath);
    }
}
