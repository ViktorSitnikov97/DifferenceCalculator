package hexlet.code;

import java.util.TreeMap;
public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {

        TreeMap<String, Object> mapFromFile1 = Parser.parse(filePath1);
        TreeMap<String, Object> mapFromFile2 = Parser.parse(filePath2);
        TreeMap<String, Status> resultMap = CalculateDifference.getDifference(mapFromFile1, mapFromFile2);

        return Formatter.selectFormat(resultMap, format);
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
