package hexlet.code;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Differ {
    public static String generate(String filepath1, String filepath2) throws IOException {

        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        ObjectMapper mapper = new ObjectMapper();
        TreeMap<String, Object> mapFromFile1 = mapper.readValue(content1,
                new TypeReference<TreeMap<String, Object>>() {
                });
        TreeMap<String, Object> mapFromFile2 = mapper.readValue(content2,
                new TypeReference<TreeMap<String, Object>>() {
                });
        Set<Map.Entry<String, Object>> setOfPairs = new HashSet<>();
        setOfPairs.addAll(mapFromFile1.entrySet());
        setOfPairs.addAll(mapFromFile2.entrySet());

        TreeMap<String, Status> resultMap = new TreeMap<>();

        for (Map.Entry<String, Object> pair : setOfPairs) {
            var key = pair.getKey();
            var value = pair.getValue();

            if (!mapFromFile1.containsKey(key)) {
                resultMap.put(key, new Status(null, value, "added"));
            } else if (!mapFromFile2.containsKey(key)) {
                resultMap.put(key, new Status(value, null, "deleted"));
            } else if (mapFromFile1.get(key).equals(mapFromFile2.get(key))) {
                resultMap.put(key, new Status(value, value, "unchanged"));
            } else if (!mapFromFile1.get(key).equals(mapFromFile2.get(key))) {
                resultMap.put(key, new Status(mapFromFile1.get(key), mapFromFile2.get(key), "changed"));
            }
        }

        StringBuilder resultString = new StringBuilder("{\n");

        for (Map.Entry<String, Status> pair : resultMap.entrySet()) {
            var key = pair.getKey();
            var valueObject = pair.getValue();

            if (valueObject.getStatusKey().equals("deleted")) {
                resultString.append(" ".repeat(2) + "- " + key + ": " + valueObject.getOldValue() + "\n");
            } else if (valueObject.getStatusKey().equals("unchanged")) {
                resultString.append(" ".repeat(4) +  key + ": " + valueObject.getOldValue() + "\n");
            } else if (valueObject.getStatusKey().equals("changed")) {
                resultString.append(" ".repeat(2) + "- " +  key + ": " + valueObject.getOldValue() + "\n");
                resultString.append(" ".repeat(2) + "+ " +  key + ": " + valueObject.getNewValue() + "\n");
            } else if (valueObject.getStatusKey().equals("added")) {
                resultString.append(" ".repeat(2) + "+ " +  key + ": " + valueObject.getNewValue() + "\n");
            }
        }
        resultString.append("}");
        return resultString.toString();
    }
}
