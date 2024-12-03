package hexlet.code;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    private final ObjectMapper objectMapper;

    public Differ() {
        this.objectMapper = new ObjectMapper();
    }

    public JsonNode readJsonFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            path = Paths.get("src/main/resources", filePath);
            if (!Files.exists(path)) {
                throw new IllegalArgumentException("File not found: " + path.toAbsolutePath());
            }
        }
        return objectMapper.readTree(path.toFile());
    }

    public String generate(String filePath1, String filePath2) throws IOException {
        JsonNode json1 = readJsonFile(filePath1);
        JsonNode json2 = readJsonFile(filePath2);

        Map<String, JsonNode> map1 = new TreeMap<>();
        Map<String, JsonNode> map2 = new TreeMap<>();

        json1.fields().forEachRemaining(entry -> map1.put(entry.getKey(), entry.getValue()));
        json2.fields().forEachRemaining(entry -> map2.put(entry.getKey(), entry.getValue()));

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
}
