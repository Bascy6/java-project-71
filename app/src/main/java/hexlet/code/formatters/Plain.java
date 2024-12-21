package hexlet.code.formatters;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Plain {

    public static String format(List<Map<String, Object>> comparisonResult) throws IOException {
        StringBuilder result = new StringBuilder();
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
                    result.append("Property '")
                            .append(key)
                            .append("' was updated. From ")
                            .append(formatValue(map.get("oldValue")))
                            .append(" to ")
                            .append(formatValue(map.get("newValue")))
                            .append("\n");
                    break;
                case "added":
                    result.append("Property '")
                            .append(key)
                            .append("' was added with value: ")
                            .append(formatValue(map.get("newValue")))
                            .append("\n");
                    break;
                case "removed":
                    result.append("Property '")
                            .append(key)
                            .append("' was removed")
                            .append("\n");
                    break;
                case "unchanged":
                    break;
                default:
                    throw new IOException("Unknown status: " + status);
            }
        }

        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        } else if (isComplexValue(value)) {
            return "[complex value]";
        } else {
            return formatSimpleValue(value);
        }
    }

    private static boolean isComplexValue(Object value) {
        return value instanceof Map || value instanceof Object[] || value instanceof Iterable;
    }

    private static String formatSimpleValue(Object value) {
        return value instanceof String ? "'" + value + "'" : value.toString();
    }
}
