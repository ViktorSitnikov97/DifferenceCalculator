package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> parse(String content, String format) throws Exception {

        switch (format) {
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
                throw new Exception("Wrong format: '" + format + "'");

        }
    }
}
