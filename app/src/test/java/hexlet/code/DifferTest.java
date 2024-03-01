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
        String expected = "Property 'follow' was removed\n"
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From 50 to 20\n"
                + "Property 'verbose' was added with value: true";

        String filePath1 = "src/test/resources/fixtures/file1.yml";
        String filePath2 = "src/test/resources/fixtures/file2.yml";
        File file1 = new File(filePath1);
        File file2 = new File(filePath2);
        String absolutePath1 = file1.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();

        String actual = generate(absolutePath1, absolutePath2, "plain");
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void generateTest3() throws Exception {
        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";

        String filePath1 = "src/test/resources/fixtures/file3.json";
        String filePath2 = "src/test/resources/fixtures/file4.json";
        File file1 = new File(filePath1);
        File file2 = new File(filePath2);
        String absolutePath1 = file1.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();

        String actual = generate(absolutePath1, absolutePath2);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
