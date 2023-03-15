package org.example.cv3;

import org.example.cv3.kalkulacka.Kalkulacka;
import org.example.cv3.kalkulacka.KalkulackaImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class KalkulackaImplTest {

    private Kalkulacka kalkulacka;

    @BeforeEach
    void setUp() {
        kalkulacka = new KalkulackaImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Test odecitani cisel")
    @Order(4)
    @Test
    void secti() {
        //priprava dat
        double c1 = 5;
        double c2 = 10;

        //vykonani business logiky
        double soucet = kalkulacka.secti(c1,c2);

        //overeni vysledku
        assertEquals(15,soucet);
    }
    @RepeatedTest(5)
    @Order(2)
    @Test
    void vynasob() {
        double c1 = 10;
        double c2 = 5;

        double vysledek = kalkulacka.vynasob(c1,c2);

        assertEquals(50, vysledek);
    }
    @Disabled("Ukazka")
    @Test
    void vydel_DivisionByZero() {
        double c1 = 10;
        double c2 = 0;

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> kalkulacka.vydel(10,0));

        assertEquals("Dělení nulou!", ex.getMessage());
        //double vysledek = kalkulacka.vydel(c1, c2);

        //assertEquals(5, vysledek);
    }

    @Test
    void odecti() {
        double c1 = 10;
        double c2 = 5;

        double vysledek = kalkulacka.odecti(c1,c2);

        assertEquals(5, vysledek);
    }

    @Test
    void secti_Mock() {
        Kalkulacka kalkulackaMock = Mockito.mock(KalkulackaImpl.class);
        Mockito.when(kalkulackaMock.secti(1, 2))
                .thenReturn(10D);
        double soucet = kalkulackaMock.secti(1,2);
        assertEquals(3, soucet);
    }
}