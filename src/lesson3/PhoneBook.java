package lesson3;

import java.util.HashMap;
import java.util.LinkedList;

public class PhoneBook {
    private HashMap<String, LinkedList<String>> phoneBook = new HashMap<String, LinkedList<String>>();


    public void add(String firstName, String phoneNumber){
        if (!phoneBook.containsKey(firstName)) {
            phoneBook.put(firstName, new LinkedList<String>());
        }
        phoneBook.get(firstName).add(phoneNumber);
    }

    public void get(String firstName){
        System.out.printf("Номера телефонов %s - %s \n", firstName, phoneBook.get(firstName));

    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }
}
