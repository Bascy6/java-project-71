package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    private static final ObjectMapper JSON_OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper YAML_OBJECT_MAPPER = new ObjectMapper(new YAMLFactory());

    public static Map<String, Object> parseFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            path = Paths.get("./src/test/resources", filePath);
            if (!Files.exists(path)) {
                throw new IllegalArgumentException("File not found: " + path.toAbsolutePath());
            }
        }

        String fileName = path.getFileName().toString().toLowerCase();
        if (fileName.endsWith(".json")) {
            return JSON_OBJECT_MAPPER.readValue(path.toFile(), Map.class);
        } else if (fileName.endsWith(".yml") || fileName.endsWith(".yaml")) {
            return YAML_OBJECT_MAPPER.readValue(path.toFile(), Map.class);
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + fileName);
        }
    }
}
