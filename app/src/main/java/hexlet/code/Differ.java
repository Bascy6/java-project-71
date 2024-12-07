package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Differ {

    public static String generate(Map<String, Object> json1, Map<String, Object> json2) {
        Map<String, Object> map1 = new TreeMap<>(json1);
        Map<String, Object> map2 = new TreeMap<>(json2);

        StringBuilder result = new StringBuilder("{\n");

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    result.append("    ").append(key).append(": ").append(map1.get(key)).append("\n");
                } else {
                    result.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
                    result.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
                }
                map2.remove(key);
            } else {
                result.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
            }
        }

        for (String key : map2.keySet()) {
            result.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
        }

        result.append("}");
        return result.toString();
    }

    public static String generateDiff(String filepath1, String filepath2) throws IOException {
        Map<String, Object> jsonContent1 = Parsing.parseJsonFile(filepath1);
        Map<String, Object> jsonContent2 = Parsing.parseJsonFile(filepath2);

        return generate(jsonContent1, jsonContent2);
    }
}
