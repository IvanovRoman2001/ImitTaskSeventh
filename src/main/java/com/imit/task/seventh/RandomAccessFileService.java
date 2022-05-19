package com.imit.task.seventh;

import java.io.*;

public class RandomAccessFileService {
    public static void writeArrInRandomFile(RandomAccessFile raf, int [] arr) throws IOException {
            for (int elem: arr) {
                raf.writeInt(elem);
            }
    }

    public static int[] readArrRandomFile(RandomAccessFile raf, int position) throws IOException {
            int[] result = new int[(int) (raf.length() / Integer.BYTES - position + 1)];
            raf.seek((long)(position - 1) * Integer.BYTES);

            int i = 0;
            while (raf.getFilePointer() < raf.length()) {
                result[i] = raf.readInt();
                i++;
            }

        return result;
        }
    }
