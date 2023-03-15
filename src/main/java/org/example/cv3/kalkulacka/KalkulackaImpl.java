package org.example.cv3.kalkulacka;

import org.example.cv3.kalkulacka.Kalkulacka;

public class KalkulackaImpl implements Kalkulacka {
    @Override
    public double secti(double cislo1, double cislo2) {
        return cislo1 + cislo2;
    }

    @Override
    public double vynasob(double cislo1, double cislo2) {
        return cislo1 * cislo2;
    }

    @Override
    public double vydel(double cislo1, double cislo2) {
        if (cislo2 == 0) {
            throw new IllegalArgumentException("Dělení nulou!");
        }
        return cislo1 / cislo2;
    }

    @Override
    public double odecti(double cislo1, double cislo2) {
        return cislo1 - cislo2;
    }
}
