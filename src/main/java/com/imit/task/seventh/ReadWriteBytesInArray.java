package com.imit.task.seventh;

import java.io.*;

public class ReadWriteBytesInArray {
    public static void writeBytesArray(OutputStream outputStream, int [] arr) throws IOException{
        try (DataOutputStream dataOutputStream = new DataOutputStream(outputStream)) {
            for (int elem: arr) {
                dataOutputStream.writeInt(elem);
            }
        }
    }

    public static void readBytesInArray(InputStream inputStream, int [] arr) throws IOException{
        try (DataInputStream dataInputStream = new DataInputStream(inputStream)) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = dataInputStream.readInt();
            }
        }
    }
}
