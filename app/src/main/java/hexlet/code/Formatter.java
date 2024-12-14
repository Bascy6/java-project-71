package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {

    public static String format(Map<String, Object> json1, Map<String, Object> json2, String formatName) {
        switch (formatName) {
            case "stylish":
                return Stylish.format(json1, json2);
            case "plain":
                return Plain.format(json1, json2);
            default:
                throw new IllegalArgumentException("Unsupported format: " + formatName);
        }
    }
}
