package org.example.cv5;

import java.util.HashMap;
import java.util.Map;

public class MapObjExample {
    public static void main(String[] args) {
        Map<String, Person> persons = new HashMap<>();
        persons.put("homer.simpson@uhk.cz", new Person("Homer", "Simpson", 30));
        persons.put("marge.simpson@uhk.cz", new Person("Marge", "Simpson", 28));
        persons.put("bart.simpson@uhk.cz", new Person("Bart", "Simpson", 18));

        System.out.println(persons);
    }
}
