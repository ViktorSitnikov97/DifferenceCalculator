package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.File;
import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    @Test
    public void generateTest1() throws Exception {
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

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

    @Test
    public void generateTest2() throws Exception {
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        String filePath1 = "src/test/resources/fixtures/file1.yml";
        String filePath2 = "src/test/resources/fixtures/file2.yml";
        File file1 = new File(filePath1);
        File file2 = new File(filePath2);
        String absolutePath1 = file1.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();

        String actual = generate(absolutePath1, absolutePath2);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
