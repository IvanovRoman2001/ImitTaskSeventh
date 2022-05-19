import com.imit.task.seventh.Flat;
import com.imit.task.seventh.House;
import com.imit.task.seventh.Person;
import com.imit.task.seventh.SerializableService;
import com.imit.task.seventh.Date;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SerializableServiceTest {
    @Test
    public void serializableHouseTest() throws ClassNotFoundException {
        Date date1 = new Date(2001, 12,1);
        Date date2 = new Date(2003, 8,19);
        Date date3 = new Date(2002, 5,27);
        Date date4 = new Date(1972, 2,11);
        Person person1 = new Person("Иванов", "Роман", "Ильич", date1);
        Person person2 = new Person("Иванов", "Илья", "Ильич", date2);
        Person person3 = new Person("Чапала", "Максим", "Алексеевич", date3);
        List<Person> listPerson1 = new ArrayList<>();
        listPerson1.add(person1);
        listPerson1.add(person2);
        List<Person> listPerson2 = new ArrayList<>();
        listPerson2.add(person3);
        Flat flat1 = new Flat(1, 100, listPerson1);
        Flat flat2 = new Flat(1, 99, listPerson2);
        Person oldPerson = new Person("Людмила", "Шиц", "Николаевна", date4);
        List<Flat> listFlat = new ArrayList<>();
        listFlat.add(flat1);
        listFlat.add(flat2);
        House house = new House("numberID101", "Bagrationa_17a", oldPerson, listFlat);

        try (OutputStream outputStream = new FileOutputStream("D:\\Serializable.txt");
             InputStream inputStream = new FileInputStream("D:\\Serializable.txt")) {

            SerializableService.serializableHouse(outputStream, house);

            House houseResult = (House) SerializableService.deserializableHouse(inputStream);

            assertEquals(house.toString(), houseResult.toString());
        }
        catch (IOException e) {
            System.out.println("ERROR" + e);
        }
    }
}
