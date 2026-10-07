package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {

    private Map<String, List<String>> telephoneDirectory = new HashMap<>();

    public void add(String lastName, String telephone) {
        if (telephoneDirectory.containsKey(lastName)) {
            telephoneDirectory.get(lastName).add(telephone);
        } else {
            List<String> tel = new ArrayList<>();
            tel.add(telephone);
            telephoneDirectory.put(lastName, tel);
        }
    }

    public void get(String lastName) {
        if (telephoneDirectory.containsKey(lastName)) {
            System.out.println(lastName + ": ");
            for (String telephone : telephoneDirectory.get(lastName)) {
                System.out.println(telephone);
            }
        } else {
            System.out.println("Такой фамилии в справочнике нет");
        }
    }
}
