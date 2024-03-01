package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Status;

import java.util.TreeMap;

public class Json {
    public static String getReport(TreeMap<String, Status> resultMap) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(resultMap);
    }
}
