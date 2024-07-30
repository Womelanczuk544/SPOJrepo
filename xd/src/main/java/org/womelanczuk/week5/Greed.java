package org.womelanczuk.week5;

import java.util.*;

public class Greed {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Integer> listOfNCards = new ArrayList<>();
    private static  int numberOfCards;
    private static int validExchangesNumber;

    private static Graph graph = new Graph();

    static class Graph {
        private Map<Integer, List<Integer>> graph;

        public Graph() {
            graph = new HashMap<>();
        }

        public void addEdge(int source, int destination) {
            graph.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
            graph.computeIfAbsent(destination, k -> new ArrayList<>()).add(source); // Graf nieskierowany
        }

        public List<Integer> findPath(int start, int end) {
            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> parentMap = new HashMap<>();
            Set<Integer> visited = new HashSet<>();

            queue.offer(start);
            visited.add(start);

            while (!queue.isEmpty()) {
                int current = queue.poll();

                if (current == end) {
                    return buildPath(parentMap, start, end);
                }


                for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                        parentMap.put(neighbor, current);
                    }
                }
            }

            return Collections.emptyList(); // Nie znaleziono ścieżki
        }


        private List<Integer> buildPath(Map<Integer, Integer> parentMap, int start, int end) {
            List<Integer> path = new ArrayList<>();
            int current = end;

            while (current != 0) {
                path.add(current);
                if (current == start) {
                    break;
                }
                current = parentMap.get(current);
            }

            Collections.reverse(path);
            return path;
        }
    }

    public static void cardsListReader(){
       numberOfCards = Integer.parseInt(scanner.nextLine());
       for(int i=0; i<numberOfCards; i++){
           listOfNCards.add(Integer.parseInt(scanner.nextLine()));
       }
    }

    public static void exchangeListReader(){
        validExchangesNumber = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<validExchangesNumber; i++){
            String lineWithWordAndOperation = scanner.nextLine();
            String[] fragments = lineWithWordAndOperation.split(" ");
            int card1 = Integer.parseInt(fragments[0]);
            int card2 = Integer.parseInt(fragments[1]);
            graph.addEdge(card1,card2);
        }
    }

    public static int searchingForSolution(){
        int result =0;
        for(int i=0; i<numberOfCards; i++){
            if(listOfNCards.get(i) == i+1){
                continue;
            }
            List<Integer> path = graph.findPath(listOfNCards.get(i),i+1);
            result += path.size()-1;
        }
        return result;
    }

    public static void main(String[] args){

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<numberOfTestCases; i++){

            cardsListReader();

            exchangeListReader();

            int result = searchingForSolution();
            System.out.println(result);
            System.out.println();
        }
    }
}
