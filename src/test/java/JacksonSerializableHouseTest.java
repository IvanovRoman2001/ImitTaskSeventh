import com.imit.task.seventh.*;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JacksonSerializableHouseTest {
    @Test
    public void serializableObjectJson() throws IOException {
        Date date1 = new Date(2001, 12,1);
        Date date2 = new Date(2003, 8,19);
        Date date3 = new Date(2002, 5,27);
        Date date4 = new Date(1972, 2,11);
        Person person1 = new Person("Иванов", "Роман", "Ильич", date1);
        Person person2 = new Person("Иванов", "Илья", "Ильич", date2);
        Person person3 = new Person("Чапала", "Максим", "Алексеевич", date3);
        List<Person> listPerson1 = new ArrayList<>();
        Collections.addAll(listPerson1, person1, person2);
        List<Person> listPerson2 = new ArrayList<>();
        listPerson2.add(person3);
        Flat flat1 = new Flat(1, 100, listPerson1);
        Flat flat2 = new Flat(1, 99, listPerson2);
        Person oldPerson = new Person("Людмила", "Шиц", "Николаевна", date4);
        List<Flat> listFlat = new ArrayList<>();
        Collections.addAll(listFlat, flat1, flat2);
        House house = new House("numberID101", "Bagrationa_17a", oldPerson, listFlat);

        try (Writer writer = new FileWriter("JsonFile.txt", StandardCharsets.UTF_8);
             Reader reader = new FileReader("JsonFile.txt", StandardCharsets.UTF_8)
        ) {

            JacksonSerializableHouse.serializableObjectJson(house, writer);

            House houseResult = JacksonSerializableHouse.deSerializableObjectJson(reader);

            assertEquals(house, houseResult);
        }

    }
}
