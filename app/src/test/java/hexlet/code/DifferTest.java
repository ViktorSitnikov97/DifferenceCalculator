package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DifferTest {

    private static String stylishComparisonResult;
    private static String jsonComparisonResult;
    private static String plainComparisonResult;


    private static Path getPath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String getDataString(String fileName) throws Exception {
        Path currentPath = getPath(fileName);
        return Files.readString(currentPath);
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        stylishComparisonResult = getDataString("StylishComparisonResultDeepStructure.txt");
        plainComparisonResult = getDataString("PlainComparisonResultDeepStructure.txt");
        jsonComparisonResult = getDataString("JsonComparisonResultDeepStructure.json");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateTest(String format) throws Exception {
        String filePath1 = getPath("DeepStructurefile1." + format).toString();
        String filePath2 = getPath("DeepStructurefile2." + format).toString();

        assertEquals(Differ.generate(filePath1, filePath2), stylishComparisonResult);
        assertEquals(Differ.generate(filePath1, filePath2, "stylish"), stylishComparisonResult);
        assertEquals(Differ.generate(filePath1, filePath2, "plain"), plainComparisonResult);
        assertEquals(Differ.generate(filePath1, filePath2, "json"), jsonComparisonResult);

    }

    @Test
    public void getDataFormatTest() {
        var actualJson = "json";
        var actualYml = "yml";
        var actualEmpty = "";

        String filePathJson = getPath("DeepStructurefile1.json").toString();
        String filePathYml = getPath("DeepStructurefile1.yml").toString();
        String filePathWithoutFormat = getPath("DeepStructurefile1").toString();

        assertEquals(Differ.getDataFormat(filePathJson), actualJson);
        assertEquals(Differ.getDataFormat(filePathYml), actualYml);
        assertEquals(Differ.getDataFormat(filePathWithoutFormat), actualEmpty);

    }

}












