import org.junit.jupiter.api.Test;
import java.io.IOException;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String filePath1 =
                "/home/viktor/java-project-71/app/src/test/resources/fixtures/file1.json";
        String filePath2 =
                "/home/viktor/java-project-71/app/src/test/resources/fixtures/file2.json";
        String actual = generate(filePath1, filePath2);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
