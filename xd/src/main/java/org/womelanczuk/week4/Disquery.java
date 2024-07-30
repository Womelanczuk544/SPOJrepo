package org.womelanczuk.week4;
import java.util.*;
public class Disquery {
    //klasa implementująca pare dowolnego typu
    static class Pair<A, B>{
        private A first;
        private B second;
        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }
    }

    //klasa implementująca graf
     static class Graph{
        private Map<Integer, List<Edge>> graph;

        public Graph(){
            graph = new HashMap<>();
        }

        //konstruktor
        public void addEdge(int city1, int city2, int distance){
            graph.computeIfAbsent(city1, k-> new ArrayList<>()).add(new Edge(city2,distance));
            graph.computeIfAbsent(city2, k-> new ArrayList<>()).add(new Edge(city1,distance));
        }
        //metoda zwracająca liste wszystkich drug z danego miasta do innych
         public List<Edge> getList(int city){
             return graph.getOrDefault(city, new ArrayList<>());
         }

         //metdoa zwracająca listę zawierającą wszystkie przejścia po miastach w drodze z jednego do drugiego
        public List<Integer> dfs(int end, int start){
            Set<Integer> visited = new HashSet<>();
            List<Integer> result = new ArrayList<>();

            //wywołanie metody pomocniczej
            dfsHelper(end, start, visited, result);

            return result;
        }

        //metoda pomocnicza do dfs która przygotowuje liste przejść rekurencyjnie
        private boolean dfsHelper(int end, int current, Set<Integer> visited, List<Integer> result){
            visited.add(current);
            result.add(current);

            //warunek końca znaleziono miasto docelowe
            if(current == end){
                return true;
            }

            //przeszukiwanie drug z miasta do miasta w poszukiwaniu tej która prowadzi do celu
            for(Edge edge : graph.get(current)){
                int neighbor = edge.destinationCity;

                if(!visited.contains(neighbor)){
                    //zostanie zwrócone true w przypadku znalezienia właściwej ścieżki
                    if(dfsHelper(end ,neighbor, visited, result)) {
                        return true;
                    }
                }
            }
            //tu kończą wszystkie nie poprawne ścieżki które są usuwane
            result.remove(result.size()-1);
            return false;
        }
    }
    //klasa przechwująca drogi i ich długość
    static class Edge{
        int destinationCity;
        int distance;

        public Edge(int destinationCity, int distance){
            this.destinationCity = destinationCity;
            this.distance = distance;
        }

    }

    //metoda ładująca rozkład drug do grafu
    public static void loadRoads(int numberOfRoads, Graph graph, Scanner scanner){
         for(int i=0; i<numberOfRoads-1; i++){

             String line = scanner.nextLine();
             String[] fragments = line.split(" ");

             //podział lini na miasta oraz dystans
             int city1 = Integer.parseInt(fragments[0]);
             int city2 = Integer.parseInt(fragments[1]);
             int distance = Integer.parseInt(fragments[2]);

             //dodanie drogi do grafu
             graph.addEdge(city1,city2,distance);
         }
    }

    //metoda szukająca najdłuższej i najkrótszej drogi na trasie
    public static Pair<Integer,Integer> maxAndMin(List<Integer> Path, Graph graph){
        Pair<Integer, Integer> maxAndMin = new Pair<>(0,Integer.MAX_VALUE);

        for(int i=0; i<Path.size()-1; i++){
            int distance =0;
            //przeszukanie wszystkich drug z miasta na liście i znalezienie następnego miasta na naszej drodzę
            for(Edge edge : graph.getList(Path.get(i))){
               if(edge.destinationCity == Path.get(i+1)){
                   distance = edge.distance;
               }
            }
            //sprawdzenie czy drogi tego mista nie są dłuższe bądź krótsze od naszych dotychczasowych extremów
            if(distance>maxAndMin.getFirst()){
                maxAndMin.first = distance;
            }
            if(distance<maxAndMin.getSecond()){
                maxAndMin.second = distance;
            }
        }
        return maxAndMin;
    }

    //główna metoda obsługująca input z zapytaniami o trasy
    public static void distanceQuery(int numberOfCities,int queries,Scanner scanner, Graph graph){
        for(int i=0; i<queries; i++){
            String line = scanner.nextLine();

            //przyjęcie miast z zapytania
            String[] fragments = line.split(" ");
            int city1 = Integer.parseInt(fragments[0]);
            int city2 = Integer.parseInt(fragments[1]);

            //wywołanie metody dfs z klasy Graph aby znalazła drogę z miasta do miasta
            List<Integer> result = new ArrayList<>(graph.dfs(city2, city1));

            //znalezienie na drodze extremów i ich wyświetlenie
            Pair<Integer, Integer> maxAndMin = maxAndMin(result,graph);
            System.out.println(maxAndMin.getSecond()+ " "+ maxAndMin.getFirst());
        }
    }

    public static void main(String[] args){
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        //wczytanie ilości miast i zapisanie wszystkich drug do grafu za pomocą metody numberOfCities
        int numberOfCities = Integer.parseInt(scanner.nextLine());
        loadRoads(numberOfCities, graph, scanner);
        System.out.println();

        //wczytanie ilości zapytań oraz wywołanie metody je obsługującej
        int queries = Integer.parseInt(scanner.nextLine());
        distanceQuery(numberOfCities, queries, scanner, graph);
    }
}