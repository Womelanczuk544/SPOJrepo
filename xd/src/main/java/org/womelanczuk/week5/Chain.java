package org.womelanczuk.week5;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chain {
    private static int numberOfAnimals;
    private static int numberOfConditions;
    private static Scanner scanner = new Scanner(System.in);
    private static int wrongConditions;

    class DisjointSetUnion {
        int[] parent;
        int[] rank;

        public DisjointSetUnion(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
    public static void checkIfConditionIsCorrectAboutanimalBeingTheSame(int animal1, int animal2){
        if(animal1>numberOfAnimals || animal2>numberOfAnimals){
            wrongConditions++;
            return;
        }
    }

    public static void checkIfConditionIsCorrectAboutAnimal1CanEatAnimal2(int animal1, int animal2){
        if(animal1>numberOfAnimals || animal2>numberOfAnimals || animal2 ==animal1){
            wrongConditions++;
            return;
        }
    }

    public static void conditionsReader(){
        for(int i=0;i<numberOfConditions;i++){
            String lineWithWordAndOperation = scanner.nextLine();
            String[] fragments = lineWithWordAndOperation.split(" ");
            int form = Integer.parseInt(fragments[0]);
            int animal1 = Integer.parseInt(fragments[1]);
            int animal2 = Integer.parseInt(fragments[2]);
            switch (form) {
                case 1:
                    checkIfConditionIsCorrectAboutanimalBeingTheSame(animal1,animal2);
                    break;
                case 2:
                    checkIfConditionIsCorrectAboutAnimal1CanEatAnimal2(animal1,animal2);
                    break;
                default:
            }
        }
    }

    public static void main(String[] args){

        int testsNumber = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<testsNumber; i++){
            wrongConditions = 0;
            String lineWithWordAndOperation = scanner.nextLine();
            String[] fragments = lineWithWordAndOperation.split(" ");
            numberOfAnimals = Integer.parseInt(fragments[0]);
            numberOfConditions = Integer.parseInt(fragments[1]);
            conditionsReader();
        }
    }
}
