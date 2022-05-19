import com.imit.task.seventh.ReadWriteSymbolArray;
import org.junit.Test;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import static org.junit.Assert.assertArrayEquals;

public class ReadWriteSymbolArrayTest {
    @Test
    public void writeArrayTest() throws IOException {
        int[] arr = {2, 3, 5, 7};
        char[] expected = {'2', ' ', '3', ' ', '5', ' ', '7', ' '};
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        ReadWriteSymbolArray.writeArray(charArrayWriter, arr);
        assertArrayEquals(expected, charArrayWriter.toCharArray());
    }

    @Test
    public void readArrayTest() throws IOException {
        int[] expected = {2, 3, 5, 7};
        char[] symbols = {'2', ' ', '3', ' ', '5', ' ', '7', ' '};
        int[] arr = new int[4];
        CharArrayReader charArrayReader = new CharArrayReader(symbols);
        ReadWriteSymbolArray.readArray(charArrayReader, arr);
        assertArrayEquals(expected, arr);
    }
}
