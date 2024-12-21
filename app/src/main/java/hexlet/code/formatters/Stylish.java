package hexlet.code.formatters;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Stylish {
    private static StringBuilder result;

    public static String format(List<Map<String, Object>> comparisonResult) throws IOException {
        result = new StringBuilder("{\n");
        TreeMap<String, Map<String, Object>> sortedMap = new TreeMap<>();

        for (Map<String, Object> map : comparisonResult) {
            String key = (String) map.get("key");
            sortedMap.put(key, map);
        }

        for (Map<String, Object> map : sortedMap.values()) {
            String key = (String) map.get("key");
            String status = (String) map.get("status");

            switch (status) {
                case "updated":
                    result.append("  - ").append(key).append(": ").append(map.get("oldValue")).append("\n");
                    result.append("  + ").append(key).append(": ").append(map.get("newValue")).append("\n");
                    break;
                case "added":
                    result.append("  + ").append(key).append(": ").append(map.get("newValue")).append("\n");
                    break;
                case "removed":
                    result.append("  - ").append(key).append(": ").append(map.get("oldValue")).append("\n");
                    break;
                case "unchanged":
                    result.append("    ").append(key).append(": ").append(map.get("oldValue")).append("\n");
                    break;
                default:
                    throw new IOException("Unknown status: " + status);
            }
        }
        result.append("}");
        return result.toString();
    }
}
