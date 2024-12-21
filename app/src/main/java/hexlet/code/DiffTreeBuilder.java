package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DiffTreeBuilder {
    public static List<Map<String, Object>> compareFiles(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        for (String key : map1.keySet()) {
            Map<String, Object> result = new LinkedHashMap<>();
            if (!map2.containsKey(key)) {
                result.put("key", key);
                result.put("oldValue", map1.get(key));
                result.put("status", "removed");
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                result.put("key", key);
                result.put("oldValue", map1.get(key));
                result.put("newValue", map2.get(key));
                result.put("status", "unchanged");
            } else {
                result.put("key", key);
                result.put("oldValue", map1.get(key));
                result.put("newValue", map2.get(key));
                result.put("status", "updated");
            }
            resultList.add(result);
        }

        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                Map<String, Object> result = new LinkedHashMap<>();
                result.put("key", key);
                result.put("newValue", map2.get(key));
                result.put("status", "added");
                resultList.add(result);
            }
        }

        return resultList;
    }
}
