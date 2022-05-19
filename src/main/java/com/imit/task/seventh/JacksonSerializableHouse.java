package com.imit.task.seventh;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;

public class JacksonSerializableHouse {
    public static void serializableObjectJson(House house, Writer writer) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, house);
    }

    public static House deSerializableObjectJson(Reader reader) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        House houseResult = mapper.readValue(reader, House.class);
        return houseResult;
    }
}
