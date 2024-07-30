package org.womelanczuk.week5;

import java.util.Scanner;

public class Sleep {
    private static  Scanner scanner = new Scanner(System.in);
    private static int roofSizeVariableK;
    private static Pair sleepWalkerCoordinates;
    private static Pair holeCoordinates;
    private static String sleepWalkerPath="";
    static class Pair{
        private int first;
        private int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public void addToFirst(int value){
            first += value;
        }
        public void addToSecond(int value){
            second += value;
        }
    }

    public static int pow(int a,int b){
        int result =1;
        if(a != 0) {
            for (int i = 0; i < b; i++) {
                result *= a;
            }
        }else{
            result = 1;
        }
        return result;
    }
    // metody a, b i c są implementacją funkcji z polecenia zadania a matody z dopiskiem pom są ich rozszerzeniem
    public static String a(String path){
        char[] charArray = path.toCharArray();
        String newPath="";
        for(char letter : charArray){
            newPath += String.valueOf(pomA(letter));
        }
        return newPath;
    }
    public static char pomA(char letter){
        if(letter == 'E'){
            letter = 'N';
        }
        else if(letter == 'W'){
            letter = 'S';
        }
        else if(letter == 'N'){
            letter = 'E';
        }
        else if(letter == 'S'){
            letter = 'W';
        }
        return letter;
    }

    public static String b(String path){
        char[] charArray = path.toCharArray();
        String newPath="";
        for(char letter : charArray){
            newPath += String.valueOf(pomB(letter));
        }
        return newPath;
    }
    public static char pomB(char letter){
        if(letter == 'E'){
            letter = 'S';
        }
        else if(letter == 'W'){
            letter = 'N';
        }
        else if(letter == 'N'){
            letter = 'W';
        }
        else if(letter == 'S'){
            letter = 'E';
        }
        return letter;
    }
    public static String c(String path){
        char[] charArray = path.toCharArray();
        String newPath="";
        for(char letter : charArray){
            newPath += String.valueOf(pomC(letter));
        }
        return newPath;
    }
    public static char pomC(char letter){
        if(letter == 'E'){
            letter = 'W';
        }
        else if(letter == 'W'){
            letter = 'E';
        }
        else if(letter == 'N'){
            letter = 'S';
        }
        else if(letter == 'S'){
            letter = 'N';
        }
        return letter;
    }

    // metoda tworzy Stringa zwierającego całą trasę po dachu
    public static void pathMaker(){
        String path = "EENNWSWN";
        if(roofSizeVariableK != 1) {
            for (int i = 2; i <= roofSizeVariableK; i++) {
                path = new String(a(path) + "E" + a(path) + "E" + path + "N" + path + "N" + path + "W" + c(path) + "S" + b(path) + "W" + b(path) + "N" + path);
            }
        }
        sleepWalkerPath = path;
    }

    // sprawdza kierunek i zmienia koordynaty
    public static Pair changeCoordinates(char direction){
        Pair coordinatesChange = new Pair(0,0);
        if(direction == 'N'){
            coordinatesChange.second = 1;
        }
        else if(direction == 'S'){
            coordinatesChange.second = -1;
        }
        else if(direction == 'W'){
            coordinatesChange.first = -1;
        }
        else if(direction == 'E'){
            coordinatesChange.first = 1;
        }
        return coordinatesChange;
    }

    // metoda sprawdza ile śpioch musi przejść
    public static int pathToList(){
        char[] charArray = sleepWalkerPath.toCharArray();
        boolean sleepWalkerFound = false;
        int result=0;
        Pair coordinates = new Pair(1,1);

        for(char letter : charArray){//EENNWSWN
            coordinates.first += changeCoordinates(letter).getFirst();
            coordinates.second += changeCoordinates(letter).getSecond();
            if(sleepWalkerFound){
                result++;
            }
            if((coordinates.first == sleepWalkerCoordinates.first) && (coordinates.second == sleepWalkerCoordinates.second)){
                sleepWalkerFound = true;
            }
            if((coordinates.first == holeCoordinates.first) && (coordinates.second == holeCoordinates.second)){
                break;
            }
        }
        return result;
    }

    public static void coordinatesReader(){
        String lineWithWordAndOperation = scanner.nextLine();
        String[] fragments = lineWithWordAndOperation.split(" ");
        sleepWalkerCoordinates = new Pair(Integer.parseInt(fragments[0]),Integer.parseInt(fragments[1]));

        lineWithWordAndOperation = scanner.nextLine();
        fragments = lineWithWordAndOperation.split(" ");
        holeCoordinates = new Pair(Integer.parseInt(fragments[0]),Integer.parseInt(fragments[1]));
    }
    public static void main(String[] args){
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<numberOfTests; i++){
            roofSizeVariableK = Integer.parseInt(scanner.nextLine());
            coordinatesReader();
            if((holeCoordinates.first == sleepWalkerCoordinates.first) && (holeCoordinates.second == sleepWalkerCoordinates.second)){
                System.out.println(0);
                continue;
            }
            pathMaker();
            System.out.println(pathToList());
        }
    }
}
