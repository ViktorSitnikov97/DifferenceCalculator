package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DifferTest {
    @Test
    public void generateTest() throws IOException {
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

//        String path = "src/test/resources/fixtures";
//        File file = new File(path);
//        String absolutePath = file.getAbsolutePath();
//        System.out.println(absolutePath);
//        assertTrue(absolutePath.endsWith("src/test/resources/fixtures"));

        String filePath1 = "src/test/resources/fixtures/file1.json";
        String filePath2 = "src/test/resources/fixtures/file2.json";
        File file1 = new File(filePath1);
        File file2 = new File(filePath2);
        String absolutePath1 = file1.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();

        String actual = generate(absolutePath1, absolutePath2);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
