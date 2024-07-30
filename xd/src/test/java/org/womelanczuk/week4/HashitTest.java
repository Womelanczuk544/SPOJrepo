package org.womelanczuk.week4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class HashitTest {

    @Test
    void hash() {
        Hashit hashItObj = new Hashit();
        assertEquals(0,hashItObj.hash("e"));
        assertEquals(0,hashItObj.hash("ee"));
        assertEquals(0,hashItObj.hash("eee"));
    }

    @Test
    void hash2() {
        String[] hashedList = new String[101];
        Hashit hashItObj = new Hashit();
        hashedList[24]="eeee";
        hashedList[0]="e";
        assertEquals(50,hashItObj.hash2(0,"eee", hashedList));
        for(int i=0; i<101; i++){
            hashedList[i]="a";
        }
        assertEquals(-1,hashItObj.hash2(0,"eee",hashedList));
    }

    @Test
    void isTheWordInTheList() {
        String[] hashedList = new String[101];
        Hashit hashItObj = new Hashit();
        hashedList[24]="eeee";
        hashedList[0]="e";
        hashedList[96]="xyz";
        assertEquals(24,hashItObj.isTheWordInTheList(0,"eeee", hashedList));
        assertEquals(0,hashItObj.isTheWordInTheList(0,"e", hashedList));
        assertEquals(96,hashItObj.isTheWordInTheList(96,"xyz", hashedList));
        assertEquals(-1,hashItObj.isTheWordInTheList(100,"abc", hashedList));
    }

}