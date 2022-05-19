import com.imit.task.seventh.RandomAccessFileService;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

import static org.junit.Assert.assertArrayEquals;

public class RandomAccessFileServiceTest {
    @Test
    public void readArrRandomFileTest() throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile("D:\\RandomAccessFile.txt", "rw")) {
            int[] arr = {1, 2, 3, 4, 5};
            RandomAccessFileService.writeArrInRandomFile(raf, arr);
            int[] result = RandomAccessFileService.readArrRandomFile(raf, 2);
            int[] expected = {2, 3, 4, 5};
            assertArrayEquals(expected, result);
        }
    }
}
