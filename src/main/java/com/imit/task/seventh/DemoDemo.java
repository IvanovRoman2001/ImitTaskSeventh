package com.imit.task.seventh;

import java.io.*;

public class DemoDemo {
    public static void main(String [] args) {
        try (RandomAccessFile raf = new RandomAccessFile("D:\\raf.txt", "rw")) {
            int n;
            do {
                n = raf.readInt();
                System.out.println(n);
            } while (n != -1);
        } catch (IOException e) {
            System.out.println("error " + e);
        }
    }
}
