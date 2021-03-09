package Java_2_AdvancedLevel.lesson3;

import java.util.*;

public class MainLesson3 {
    //1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
    static String[] array = {"cat", "dog", "mouse", "cow", "bird", "cat", "mouse", "human", "monkey", "bird", "cat"};


    public static void main(String[] args) {
        System.out.println("******************Задание №1: ******************");

        Map<String, Integer> mapArray = new HashMap<>();
        for (String s : array) {
            Integer frequency = mapArray.get(s);
            mapArray.put(s, (frequency == null ? 1 : frequency + 1));
        }
        //Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        System.out.println(mapArray.keySet());
        //Посчитать, сколько раз встречается каждое слово.
        System.out.println(mapArray);

        //2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        // В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии.
        // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        // тогда при запросе такой фамилии должны выводиться все телефоны.

        System.out.println("\n******************Задание №2: ******************");
        Phonebook phonebook = new Phonebook();

        //Добавляем новые контакты
        phonebook.add("Иванов", "+7(926)111-11-11");
        phonebook.add("Петров", "+7(926)222-22-11");
        phonebook.add("Сидоров", "+7(926)333-11-33");
        phonebook.add("Иванов", "+7(926)444-44-33");
        phonebook.add("Иванов", "+7(926)111-11-11");

        System.out.println("\nРезультат поиска контактов по фамилии:");
        phonebook.get("Иванов");
        phonebook.get("Сидоров");


    }
}
