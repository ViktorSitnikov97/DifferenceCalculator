package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.TreeMap;

public class Formatter {
    public static String getDataWithSelectedFormat(TreeMap<String, Status> resultMap, String format) throws Exception {
        switch (format) {
            case "plain":
                return Plain.getReport(resultMap);
            case "stylish":
                return Stylish.getReport(resultMap);
            default:
                throw new Exception("Format " + "'" + format + "'" + " is wrong!");
        }
    }
}

