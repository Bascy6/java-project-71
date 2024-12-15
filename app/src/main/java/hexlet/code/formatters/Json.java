package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Map;

public class Json {
    public static String format(Map<String, Object> json1, Map<String, Object> json2) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootNode = mapper.createObjectNode();

        for (Map.Entry<String, Object> entry : json1.entrySet()) {
            rootNode.set(entry.getKey(), mapper.valueToTree(entry.getValue()));
        }
        for (Map.Entry<String, Object> entry : json2.entrySet()) {
            rootNode.set(entry.getKey(), mapper.valueToTree(entry.getValue()));
        }

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
    }
}
