package org.womelanczuk.week4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
class DisqueryTest {
    Disquery.Graph mainDisq = new Disquery.Graph();
    @Test
    void maxAndMin() {
        Disquery disq = new Disquery();
        Disquery.Graph graph = new Disquery.Graph();
        graph.addEdge(3,6,4);
        graph.addEdge(1,7,1);
        graph.addEdge(1,3,2);
        graph.addEdge(1,2,6);
        graph.addEdge(2,5,4);
        graph.addEdge(2,4,4);
        List<Integer> list = graph.dfs(4,6);
        Disquery.Pair<Integer,Integer> pair1 = Disquery.maxAndMin(list,graph);
        Disquery.Pair<Integer,Integer> pair2 = new Disquery.Pair<>(6,2);

        assertEquals(pair2.getFirst(),pair1.getFirst());
        assertEquals(pair2.getSecond(),pair1.getSecond());

        list = graph.dfs(6,7);
        pair1 = Disquery.maxAndMin(list,graph);
        Disquery.Pair<Integer,Integer> pair3 = new Disquery.Pair<>(4,1);

        assertEquals(pair3.getFirst(),pair1.getFirst());
        assertEquals(pair3.getSecond(),pair1.getSecond());
    }

    @Test
    void Graph(){
        Disquery.Graph graph = new Disquery.Graph();
        graph.addEdge(3,6,4);
        graph.addEdge(1,7,1);
        graph.addEdge(1,3,2);
        graph.addEdge(1,2,6);
        graph.addEdge(2,5,4);
        graph.addEdge(2,4,4);
        List<Integer> list = graph.dfs(4,6);
        List<Integer> list2  = new ArrayList<>();
        list2.add(6);
        list2.add(3);
        list2.add(1);
        list2.add(2);
        list2.add(4);
        assertEquals(list2,list);
    }
}