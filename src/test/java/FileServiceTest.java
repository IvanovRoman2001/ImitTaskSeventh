import com.imit.task.seventh.ExtensionFilter;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertArrayEquals;

public class FileServiceTest {
    @Test
    public void getListFileWithExtensionTest() {
        File file = new File("D://");
        String[] arrFile = file.list(new ExtensionFilter(".txt"));
        String[] expected = new String[4];
        expected[0] = "raf.txt";
        expected[1] = "RandomAccessFile.txt";
        expected[2] = "Serializable.txt";
        expected[3] = "ServerSocket1.txt";
        assertArrayEquals(expected, arrFile);
    }
}
