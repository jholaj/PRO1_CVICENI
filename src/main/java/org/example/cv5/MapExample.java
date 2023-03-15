package org.example.cv5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Value 1");
        map.put(2, "Value 2");
        map.put(2, "Prepsana hodnota");
        map.put(null, "Null hodnota");

        System.out.println(map);

        System.out.println(map.get(1)); //prvek s cislem 1
        System.out.println(map.get(null)); //prvek s null
        System.out.println(map.getOrDefault(-1,"Vychozi hodnota")); //vychozi hodnota pokud prvek neexistuje

        for (Map.Entry<Integer, String> entry:map.entrySet()) {
            System.out.println("Klíč: " + entry.getKey() + " : " + entry.getValue());
        }

        Set<Integer> keys = map.keySet();
        for(Integer i : keys){
            System.out.println("klíč: " + i);
        }

        Collection<String> values = map.values();
        for (String s : values) {
            System.out.println("Hodnota: " + s);
        }


        for (int i = 0; i < map.size(); i++){
            System.out.println(map.get(i));
        }


    }
}
