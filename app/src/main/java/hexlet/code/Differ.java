package hexlet.code;

import java.io.IOException;
import java.util.Map;

public class Differ {

    public static String generate(Map<String, Object> json1, Map<String, Object> json2, String format)
            throws IOException {
        return Formatter.format(json1, json2, format);
    }

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Map<String, Object> jsonContent1 = Parser.parseFile(filePath1);
        Map<String, Object> jsonContent2 = Parser.parseFile(filePath2);

        return generate(jsonContent1, jsonContent2, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }
}
