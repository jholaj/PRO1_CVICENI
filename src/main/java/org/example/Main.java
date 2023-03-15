package org.example;

import org.example.cv3.kalkulacka.Kalkulacka;
import org.example.cv3.kalkulacka.KalkulackaImpl;

public class Main {
    public static void main(String[] args) {
        Kalkulacka kalkulacka = new KalkulackaImpl();
;
        double soucet = kalkulacka.secti(1,2);
        System.out.println("Soucet: " + soucet);
        double nasobeni = kalkulacka.vynasob(1,2);
        System.out.println("Nasobeni: " + nasobeni);
    }
}