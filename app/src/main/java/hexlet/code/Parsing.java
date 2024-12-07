package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parsing {

    public static Map<String, Object> parseJsonFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            path = Paths.get("./src/test/resources", filePath);
            if (!Files.exists(path)) {
                throw new IllegalArgumentException("File not found: " + path.toAbsolutePath());
            }
        }
        return objectMapper.readValue(path.toFile(), Map.class);
    }
}
