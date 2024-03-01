package hexlet.code.formats;

import hexlet.code.Status;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Plain {
    public static String getReport(TreeMap<String, Status> resultMap) {

        StringBuilder resultString = new StringBuilder();

        for (Map.Entry<String, Status> pair : resultMap.entrySet()) {
            var key = pair.getKey();
            var valueObject = pair.getValue();
            var oldValueString = getPropertyValue(valueObject.getOldValue());
            var newValueString = getPropertyValue(valueObject.getNewValue());

            if (valueObject.getStatusKey().equals("deleted")) {
                resultString.append("Property " + "'" + key + "'" + " was removed\n");
            } else if (valueObject.getStatusKey().equals("unchanged")) {
                resultString.append("");
            } else if (valueObject.getStatusKey().equals("changed")) {
                resultString.append("Property " + "'" + key + "'" + " was updated. From "
                        + oldValueString + " to " + newValueString + "\n");
            } else if (valueObject.getStatusKey().equals("added")) {
                resultString.append("Property " + "'" + key + "'" + " was added with value: "
                         + newValueString + "\n");
            }
        }
        return resultString.toString();
    }

    public static String getPropertyValue(Object value) {
        if (value instanceof Map<?, ?> || value instanceof List<?>) {
            return "[complex value]";
        } else if (value == null) {
            return "null";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value.toString();
    }
}
