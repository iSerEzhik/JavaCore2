package lesson3.phoneBook;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static List<Contact> phonebook= new ArrayList<>();
    public static void main(String[] args) {
        add(new Contact("Кретов","+79152965190"));

        add(new Contact("Марных","+79164278561"));
        add(new Contact("Фартушина","+79848458478"));
        add(new Contact("Кретова","89443574212"));
        add(new Contact("Кретов","+79104585487"));
        System.out.println("Контакты с фамилией <<Кретов>>");
        get("Кретов");
        System.out.println("Контакты с фамилией <<Фартушина>>");
        get("Фартушина");
    }
    public static void add (Contact newContact){
        phonebook.add(newContact);
    }
    public static void get(String name){
        Contact findContact = new Contact(name,"");
        for (int i = 0; i < phonebook.size(); i++) {
            if (phonebook.get(i).equals(findContact)){
                System.out.println(phonebook.get(i));
            }
        }
    }

}
