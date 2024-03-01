package hexlet.code;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.Objects;

public class CalculateDifference {
    public static TreeMap<String, Status> getDifference(TreeMap<String, Object> map1,
                                                        TreeMap<String, Object> map2) {

        Set<Map.Entry<String, Object>> setOfPairs = new HashSet<>();
        setOfPairs.addAll(map1.entrySet());
        setOfPairs.addAll(map2.entrySet());

        TreeMap<String, Status> resultMap = new TreeMap<>();

        for (Map.Entry<String, Object> pair : setOfPairs) {

            var key = pair.getKey();
            var value = pair.getValue();

            if (!map1.containsKey(key)) {
                resultMap.put(key, new Status(null, value, "added"));
            } else if (!map2.containsKey(key)) {
                resultMap.put(key, new Status(value, null, "deleted"));
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                resultMap.put(key, new Status(value, value, "unchanged"));
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                resultMap.put(key, new Status(map1.get(key), map2.get(key), "changed"));
            }
        }


        return resultMap;

    }
}
