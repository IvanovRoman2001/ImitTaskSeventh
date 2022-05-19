package com.imit.task.seventh;

import java.io.*;

public class SerializableService {
    public static void serializableHouse(OutputStream outputStream, House house) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(house);
        }
    }

    public static House deserializableHouse(InputStream inputStream) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            House house = (House) objectInputStream.readObject();
            return house;
        }
        catch (ClassNotFoundException e) {
//            System.out.println( e.st);
            e.printStackTrace();
            throw e;
        }
    }
}
