package day7.Frame23HashCode;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Launcher {
    public static void main(String[] args) {
        Map<String,Person>listPerson =new HashMap<String, Person>();
        listPerson.put("Ivanov1", new Person("Ivanov1", 23, 100, new Address("City1", "Street1", 1)));
        listPerson.put("Ivanov2", new Person("Ivanov2", 12, 0, new Address("City2", "Street2", 2)));
        listPerson.put("Ivanov3", new Person("Ivanov3", 69, 600, new Address("City3", "Street3", 3)));


        Iterator<Map.Entry<String, Person>> iterator=listPerson.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Person> pair = iterator.next(); //получение «пары» элементов
            String key = pair.getKey();    //ключ
            Person value = pair.getValue();      //значение
            System.out.println(key + ":" + value);
        }



    }
}
