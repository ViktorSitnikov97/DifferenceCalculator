package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> parse(String filePath) throws Exception {

        int index = filePath.lastIndexOf('.');
        String formatOfFile = index > 0 ? filePath.substring(index + 1) : "";
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);

        switch (formatOfFile) {
            case "json":
                ObjectMapper mapperJson = new ObjectMapper();
                return mapperJson.readValue(content,
                        new TypeReference<TreeMap<String, Object>>() {
                        });
            case "yml":
                ObjectMapper mapperYaml = new YAMLMapper();
                return mapperYaml.readValue(content,
                        new TypeReference<TreeMap<String, Object>>() {
                        });
            default:
                throw new Exception("Wrong format: '" + formatOfFile + "'");
        }
    }
}
