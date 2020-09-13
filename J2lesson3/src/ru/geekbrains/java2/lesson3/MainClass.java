package ru.geekbrains.java2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MainClass {

    private static ArrayList<PhoneBook> phoneBook = new ArrayList<>();

    public static void main (String[] args){

        /*
        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать сколько раз встречается каждое слово.

        2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных
        номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода
        get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько
        телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
         */

        String[] names = {"Olga", "Svetlana","Konstantin","Sergey", "Svetlana"};
        calcRepeatNames(names);
        showUniqueNames(names);
        addPhone("Petrov", 89091111111L);
        addPhone("Sidorov", 89092222222L);
        addPhone("Petrov", 89093333333L);
        addPhone("Ivanova", 89094444444L);
        addPhone("Jul'kina", 89095555555L);
        addPhone("Kuzkina", 89096666666L);
        System.out.println(getPhone("Petrov"));



    }
    private static void showUniqueNames(String[] array){
        HashSet<String> namesList = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            namesList.add(array[i]);
        }
        System.out.println(namesList);
    }

    private static void calcRepeatNames(String[] array){
        HashMap<String, Integer> names = new HashMap<>();
        for (int i = 0; i < array.length; i++){
            if(names.containsKey(array[i])){
                int val = names.get(array[i]);
                names.put(array[i], val + 1);
            } else if(!names.containsKey(array[i])){
                names.put(array[i], 1);
            }
        }
    }
    private static void addPhone(String lastName, long phoneNumber){
        phoneBook.add(new PhoneBook(lastName, phoneNumber));
    }
    private static ArrayList<PhoneBook> getPhone(String lastName){
        ArrayList<PhoneBook> result = new ArrayList<>();
        Iterator<PhoneBook> pb = phoneBook.iterator();
        while (pb.hasNext()){
            PhoneBook user = pb.next();
            if(user.getLastName().equals(lastName))
                result.add(new PhoneBook(user.getLastName(), user.getPhoneNumber()));
        }
        return result;
    }
}
