package hexlet.code;

import java.util.TreeMap;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Differ {
    public static String generate(String filePath1, String filePath2, String formatOfReport) throws Exception {

        TreeMap<String, Object> mapFromFile1 = getData(filePath1);
        TreeMap<String, Object> mapFromFile2 = getData(filePath2);

        TreeMap<String, Status> resultMap = CalculateDifference.getDifference(mapFromFile1, mapFromFile2);

        return Formatter.getDataWithSelectedFormat(resultMap, formatOfReport);
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    private static TreeMap<String, Object> getData(String filePath) throws Exception {

        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);
        String format = getDataFormat(filePath);

        return Parser.parse(content, format);
    }

    private static String getDataFormat(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0
                ? filePath.substring(index + 1)
                : "";
    }
}
