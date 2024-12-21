package hexlet.code.formatters;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class Json {

    public static String format(List<Map<String, Object>> comparisonResult) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        Map<String, Object> resultMap = new LinkedHashMap<>();

        for (Map<String, Object> map : comparisonResult) {
            String key = (String) map.get("key");
            String status = (String) map.get("status");

            if ("added".equals(status)) {
                resultMap.put(key, map.get("newValue"));
            } else if ("removed".equals(status)) {
                resultMap.put(key, map.get("oldValue"));
            } else if ("updated".equals(status)) {
                resultMap.put(key, map.get("newValue"));
            } else if ("unchanged".equals(status)) {
                resultMap.put(key, map.get("oldValue"));
            }
        }

        return objectMapper.writeValueAsString(resultMap);
    }
}
