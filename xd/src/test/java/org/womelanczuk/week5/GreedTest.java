package org.womelanczuk.week5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GreedTest {
    @Test
    void pathFinder(){
        Greed.Graph graf = new Greed.Graph();
        graf.addEdge(1,2);
        graf.addEdge(1,3);
        graf.addEdge(2,4);
        graf.addEdge(2,5);
        graf.addEdge(3,6);
        graf.addEdge(5,6);
        graf.addEdge(1,6);
        List<Integer> list = new ArrayList<>(List.of(1,6));
        List<Integer> list1 = new ArrayList<>();
        list1 = graf.findPath(1,6);
        assertEquals(list,list1);
    }

}