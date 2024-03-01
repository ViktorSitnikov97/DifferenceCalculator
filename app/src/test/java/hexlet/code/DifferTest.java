package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

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

    @Test
    public void generateTestStylishForFilesJson() throws Exception {

        Path file1 = getPath("DeepStructurefile1.json");
        Path file2 = getPath("DeepStructurefile2.json");

        String absolutePathFile1 = file1.toFile().getAbsolutePath();
        String absolutePathFile2 = file2.toFile().getAbsolutePath();

        String actual = Differ.generate(absolutePathFile1, absolutePathFile2);
        assertEquals(stylishComparisonResult, actual);

    }

    @Test
    public void generateTestStylishForFilesYml() throws Exception {

        Path file1 = getPath("DeepStructurefile1.yml");
        Path file2 = getPath("DeepStructurefile2.yml");

        String absolutePathFile1 = file1.toFile().getAbsolutePath();
        String absolutePathFile2 = file2.toFile().getAbsolutePath();

        String actual = Differ.generate(absolutePathFile1, absolutePathFile2);
        assertEquals(stylishComparisonResult, actual);

    }

    @Test
    public void generateTestPlainForFilesJson() throws Exception {

        Path file1 = getPath("DeepStructurefile1.json");
        Path file2 = getPath("DeepStructurefile2.json");

        String absolutePathFile1 = file1.toFile().getAbsolutePath();
        String absolutePathFile2 = file2.toFile().getAbsolutePath();

        String actual = Differ.generate(absolutePathFile1, absolutePathFile2, "plain");
        assertEquals(plainComparisonResult, actual);

    }

    @Test
    public void generateTestPlainForFilesYml() throws Exception {

        Path file1 = getPath("DeepStructurefile1.yml");
        Path file2 = getPath("DeepStructurefile2.yml");

        String absolutePathFile1 = file1.toFile().getAbsolutePath();
        String absolutePathFile2 = file2.toFile().getAbsolutePath();

        String actual = Differ.generate(absolutePathFile1, absolutePathFile2, "plain");
        assertEquals(plainComparisonResult, actual);

    }

    @Test
    public void generateTestJsonForFilesJson() throws Exception {

        Path file1 = getPath("DeepStructurefile1.json");
        Path file2 = getPath("DeepStructurefile2.json");

        String absolutePathFile1 = file1.toFile().getAbsolutePath();
        String absolutePathFile2 = file2.toFile().getAbsolutePath();

        String actual = Differ.generate(absolutePathFile1, absolutePathFile2, "json");
        assertEquals(jsonComparisonResult, actual);

    }

    @Test
    public void generateTestJsonForFilesYml() throws Exception {

        Path file1 = getPath("DeepStructurefile1.yml");
        Path file2 = getPath("DeepStructurefile2.yml");

        String absolutePathFile1 = file1.toFile().getAbsolutePath();
        String absolutePathFile2 = file2.toFile().getAbsolutePath();

        String actual = Differ.generate(absolutePathFile1, absolutePathFile2, "json");
        assertEquals(jsonComparisonResult, actual);

    }

}












