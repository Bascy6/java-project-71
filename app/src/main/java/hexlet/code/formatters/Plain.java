package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeMap;

public class Plain {

    public static String format(Map<String, Object> json1, Map<String, Object> json2) {
        Map<String, Object> map1 = new TreeMap<>(json1);
        Map<String, Object> map2 = new TreeMap<>(json2);

        StringBuilder result = new StringBuilder();

        TreeMap<String, Object> combinedMap = new TreeMap<>(map1);
        combinedMap.putAll(map2);

        for (String key : combinedMap.keySet()) {
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);

            if (map1.containsKey(key) && !map2.containsKey(key)) {
                result.append("Property '").append(key).append("' was removed\n");
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                result.append("Property '").append(key).append("' was added with value: ")
                        .append(formatValue(value2)).append("\n");
            } else if (map1.containsKey(key) && map2.containsKey(key)) {
                if (value1 == null && value2 != null) {
                    result.append("Property '").append(key).append("' was updated. From null to ")
                            .append(formatValue(value2)).append("\n");
                } else if (value1 != null && value2 == null) {
                    result.append("Property '").append(key).append("' was updated. From ")
                            .append(formatValue(value1)).append(" to null\n");
                } else if (value1 != null && !value1.equals(value2)) {
                    result.append("Property '").append(key).append("' was updated. From ")
                            .append(formatValue(value1)).append(" to ").append(formatValue(value2)).append("\n");
                }
            }
        }

        return result.toString().trim();
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof Map || value instanceof Object[] || value instanceof Iterable) {
            return "[complex value]";
        } else {
            return value instanceof String ? "'" + value + "'" : value.toString();
        }
    }
}
