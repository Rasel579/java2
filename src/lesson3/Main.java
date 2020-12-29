package lesson3;

import java.util.ArrayList;

public class Main {
    public static String[] stringsArr = {
              "Uriel",
              "Colby",
              "Keefe",
              "Mark",
              "Lester",
              "Xanthus",
              "Ferris",
              "Graiden",
              "Xanthus",
              "Ryder",
              "Melvin",
              "Demetrius",
              "Lucian",
              "Jamal",
              "Demetrius",
              "Amery",
              "Demetrius",
              "Donovan",
              "Charles"
      };
    public static void main(String[] args) {
//        1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
//        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//        Посчитать, сколько раз встречается каждое слово.
           ArrayStrings stringArrayList = new ArrayStrings();
           stringArrayList.addListOfArrayStrings(stringsArr);
           stringArrayList.getUnicsElements();



//         2. Написать простой класс ТелефонныйСправочник,
//         который хранит в себе список фамилий и телефонных номеров.
//         В этот телефонный справочник с помощью метода add() можно добавлять записи.
//         С помощью метода get() искать номер телефона по фамилии. Следует учесть,
//         что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//         тогда при запросе такой фамилии должны выводиться все телефоны.
           PhoneBook phoneBook = new PhoneBook();
           phoneBook.add("Ivanov", "+79999999543");
           phoneBook.add("Ivanov", "+79995555654");
           phoneBook.add("Petrov", "+79995344433");
           phoneBook.add("Petrov", "+79994564545");
           phoneBook.add("Morozov", "+79994564545");
           phoneBook.add("Morozov", "+79994564567");
           phoneBook.add("Morozov", "+79994564343");
           phoneBook.get("Ivanov");
           phoneBook.get("Morozov");
           phoneBook.get("Petrov");

    }
}
