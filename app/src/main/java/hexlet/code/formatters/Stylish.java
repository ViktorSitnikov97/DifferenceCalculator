package hexlet.code.formats;

import hexlet.code.Status;

import java.util.Map;
import java.util.TreeMap;

public class Stylish {
    public static String getReport(TreeMap<String, Status> resultMap) {

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
