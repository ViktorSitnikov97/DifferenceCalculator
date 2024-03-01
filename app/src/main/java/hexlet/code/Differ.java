package hexlet.code;

import java.util.TreeMap;
import hexlet.code.formats.Stylish;
import hexlet.code.formats.Plain;
public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {

        TreeMap<String, Object> mapFromFile1 = Parser.parse(filePath1);
        TreeMap<String, Object> mapFromFile2 = Parser.parse(filePath2);
        TreeMap<String, Status> resultMap = CalculateDifference.getDifference(mapFromFile1, mapFromFile2);

        if (format.equals("stylish")) {
            return Stylish.getReport(resultMap);
        } else if (format.equals("plain")) {
            return Plain.getReport(resultMap);
        } else {
            return "yy";
        }
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
