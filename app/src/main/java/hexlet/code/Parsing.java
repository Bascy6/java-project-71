package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Parsing {
    private final ObjectMapper objectMapper;

    public Parsing() {
        this.objectMapper = new ObjectMapper();
    }

    public Config parseJsonFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            path = Paths.get("src/main/resources", filePath);
            if (!Files.exists(path)) {
                throw new IllegalArgumentException("File not found: " + path.toAbsolutePath());
            }
        }
        return objectMapper.readValue(path.toFile(), Config.class);
    }

    public Config parsing(String filePath1, String filePath2) throws IOException {
        Config config1 = parseJsonFile(filePath1);
        Config config2 = parseJsonFile(filePath2);

        if (config1 == null || config2 == null) {
            throw new IllegalArgumentException("One or both files could not be parsed.");
        }

        Config pars = new Config();
        pars.setHost(config2.getHost() != null ? config2.getHost() : config1.getHost());
        pars.setTimeout(config2.getTimeout() != 0 ? config2.getTimeout() : config1.getTimeout());
        pars.setProxy(config2.getProxy() != null ? config2.getProxy() : config1.getProxy());
        pars.setFollow(config2.isFollow() || config1.isFollow());
        pars.setVerbose(config2.isVerbose() || config1.isVerbose());

        return pars;
    }
}