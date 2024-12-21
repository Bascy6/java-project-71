package hexlet.code;

import java.io.IOException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;
import java.util.List;

public class Formatter {

    public static String format(List<Map<String, Object>> comparisonResult, String formatName)
            throws IOException {
        switch (formatName) {
            case "stylish":
                return Stylish.format(comparisonResult);
            case "plain":
                return Plain.format(comparisonResult);
            case "json":
                return Json.format(comparisonResult);
            default:
                throw new IllegalArgumentException("Unsupported format: " + formatName);
        }
    }
}
