package org.womelanczuk.week5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SleepTest {
    String coordinates ="EENNWSWN";

    @Test
    void pow() {
        int pom = Sleep.pow(2,3);
        assertEquals(8,pom);
        pom = Sleep.pow(4,0);
        assertEquals(1,pom);
    }

    @Test
    void a() {
        String pom = Sleep.a(coordinates);
        assertEquals("NNEESWSE",pom);
    }

    @Test
    void b() {
        String pom = Sleep.b(coordinates);
        assertEquals("SSWWNENW",pom);
    }

    @Test
    void c() {
        String pom = Sleep.c(coordinates);
        assertEquals("WWSSENES",pom);
    }

    @Test
    void changeCoordinates() {
        Sleep.Pair pom = Sleep.changeCoordinates('W');
        assertEquals(-1,pom.getFirst());
        assertEquals(0,pom.getSecond());
        pom = Sleep.changeCoordinates('E');
        assertEquals(1,pom.getFirst());
        assertEquals(0,pom.getSecond());
        pom = Sleep.changeCoordinates('S');
        assertEquals(0,pom.getFirst());
        assertEquals(-1,pom.getSecond());
        pom = Sleep.changeCoordinates('N');
        assertEquals(0,pom.getFirst());
        assertEquals(1,pom.getSecond());
    }
}