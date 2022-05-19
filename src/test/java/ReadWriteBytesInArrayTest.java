import com.imit.task.seventh.ReadWriteBytesInArray;
import org.junit.Test;

import java.io.*;

import static com.imit.task.seventh.ReadWriteBytesInArray.readBytesInArray;
import static com.imit.task.seventh.ReadWriteBytesInArray.writeBytesArray;
import static org.junit.Assert.assertArrayEquals;

public class ReadWriteBytesInArrayTest {
    @Test
    public void writeBytesArrayTest() throws IOException {
        int[] arr = new int[] {10, 11, 12};
        byte[] expected = {0,0,0,10,  0,0,0,11,  0,0,0,12};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        writeBytesArray(outputStream, arr);
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void readBytesInArrayTest() throws IOException {
        int[] expected = {10, 11, 12};
        byte[] buf = {0,0,0,10,  0,0,0,11,  0,0,0,12};
        int[] arr = new int[3];
        ByteArrayInputStream inputStream = new ByteArrayInputStream(buf);
        readBytesInArray(inputStream, arr);
        assertArrayEquals(expected, arr);
    }
}
