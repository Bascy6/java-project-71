package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeMap;

public class Stylish {


    public static String format(Map<String, Object> json1, Map<String, Object> json2) {
        Map<String, Object> map1 = new TreeMap<>(json1);
        Map<String, Object> map2 = new TreeMap<>(json2);

        StringBuilder result = new StringBuilder("{\n");

        TreeMap<String, Object> combinedMap = new TreeMap<>(map1);
        combinedMap.putAll(map2);

        for (String key : combinedMap.keySet()) {
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);

            if (map1.containsKey(key) && !map2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(formatValue(value1)).append("\n");
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(formatValue(value2)).append("\n");
            } else if (map1.containsKey(key) && map2.containsKey(key)) {
                if (value1 == null && value2 != null) {
                    result.append("  - ").append(key).append(": ").append(formatValue(value1)).append("\n");
                    result.append("  + ").append(key).append(": ").append(formatValue(value2)).append("\n");
                } else if (value1 != null && value2 == null) {
                    result.append("  - ").append(key).append(": ").append(formatValue(value1)).append("\n");
                    result.append("  + ").append(key).append(": ").append(formatValue(value2)).append("\n");
                } else if (value1 != null && !value1.equals(value2)) {
                    result.append("  - ").append(key).append(": ").append(formatValue(value1)).append("\n");
                    result.append("  + ").append(key).append(": ").append(formatValue(value2)).append("\n");
                } else if (value1.equals(value2)) {
                    result.append("    ").append(key).append(": ").append(formatValue(value1)).append("\n");
                }
            }
        }


        result.append("}");
        return result.toString();
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof Map) {
            return formatMap((Map<String, Object>) value);
        } else if (value instanceof Object[]) {
            return formatArray((Object[]) value);
        } else {
            return value.toString();
        }
    }

    private static String formatArray(Object[] array) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            result.append(formatValue(array[i]));
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    private static String formatMap(Map<String, Object> map) {
        StringBuilder result = new StringBuilder("{");
        int count = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            result.append(entry.getKey()).append("=").append(formatValue(entry.getValue()));
            count++;
            if (count < map.size()) {
                result.append(", ");
            }
        }
        result.append("}");
        return result.toString();
    }
}
