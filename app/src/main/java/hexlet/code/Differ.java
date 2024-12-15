package hexlet.code;

import java.io.IOException;
import java.util.Map;

public class Differ {

    public static String generateDiff(Map<String, Object> json1, Map<String, Object> json2, String format)
            throws IOException {
        return Formatter.format(json1, json2, format);
    }

    public static String generateDiff(String filePath1, String filePath2, String format) throws IOException {
        Map<String, Object> jsonContent1 = Parser.parseFile(filePath1);
        Map<String, Object> jsonContent2 = Parser.parseFile(filePath2);

        return generateDiff(jsonContent1, jsonContent2, format);
    }
}
