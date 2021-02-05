package Java_2_AdvancedLevel.lesson3;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Map<String, String> map;

    public Phonebook() {
        map = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (map.containsKey(phoneNumber)) {
            System.out.println("Контакт с номером телефона: " + phoneNumber + " уже существует");
        } else {
            map.put(phoneNumber, name);
            System.out.println("Контакт - " + name + " успешно добавлен в телефонную книгу");
        }

    }
    
    public void get(String name) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == name) {
                System.out.println("Фамилия: " + entry.getValue() + " Тел.: "
                        + entry.getKey());
            }
        }
    }
}
