package org.womelanczuk.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Hashit {
    private static int countOfStrings;//ilość stringów w tablicy

    //podstawowa metoda hashująca
    public static int hash(String word) {
        int result = 0;
        //obliczanie indexu wg wzoru
        for (int i = 0; i < word.length(); i++) {
            result += word.charAt(i) * (i + 1);
        }
        result *= 19;
        result %= 101;
        return result;
    }

    //dodatkowa metoda kashująca
    public static int hash2(int key, String word, String[] list) {
        int index = -1;
        //obliczanie indexu wg drugiego wzoru jeśli znajdzie puste miejsce przerywa szukanie
        for (int i = 1; i < 20; i++) {
            int position = (key + i * i + 23 * i) % 101;
            if (list[position] == null || list[position].equals("")) {
                index = position;
                break;
            }
        }
        return index;
    }

    //metoda sprawdzająca czy na liście jest taki string
    public static int isTheWordInTheList(int key, String word, String[] list) {
        int index = -1;
        //sprawdzamy miejsce wyliczone przez metode hash
        if (list[key] != null && list[key].equals(word)) {
            index = key;
        }
        //sprawdzamy potencjalne miejsca wyliczane przez metode hash2
        for (int i = 1; i < 20; i++) {
            int position = (key + i * i + 23 * i) % 101;
            if (list[position] != null && list[position].equals(word)) {
                index = position;
            }
        }
        return index;//wartość -1 oznacza że nie znaleziono takiego stringa
    }

    //metoda dodająca do listy string na odpowiednim miejscu
    public static void add(int key, String word, String[] list) {

        if (isTheWordInTheList(key, word, list) == -1) {
            //wstawianie słowa do listy na miejsce wyliczone przez hash jeśli jest puste
            if (list[key] == null || list[key].equals("")) {
                list[key] = word;
                countOfStrings++;

            } else {
                int index = hash2(key, word, list);
                //wstawianie słowa do listy na miejsce wyliczone przez hash2 jeśli jest puste
                if (index != -1) {
                    list[index] = word;
                    countOfStrings++;
                }
            }
        }
    }

    //metoda usuwająca string z tablicy
    public static void del(int key, String word, String[] list) {
        int index = isTheWordInTheList(key, word, list);
        if (index != -1) {
            list[index] = "";
            countOfStrings--;
        }
    }

    //główna metoda odpowiedzialna za wczytywanie poleceń i wywoływanie metod add i del
    public static void hashIt(String[] list, Scanner scanner) {
        String operation = "";//nazwa operacji add lub del
        String word = "";//słowo na którym wykonamy add lub del
        int key;//index wyliczony przez metode hash

        //pobranie lini z inputu sprawdzenie czy słowo nie jest puste bo jeśli tak to pomijamy
        String lineWithWordAndOperation = scanner.nextLine();
        String[] fragments = lineWithWordAndOperation.split(":");
        //pominięcie
        if (fragments.length == 1) {
            return;
        }
        operation = fragments[0];
        word = fragments[1];
        key = hash(word);

        //wybór metody add lub del
        switch (operation) {
            case "ADD":
                add(key, word, list);
                break;
            case "DEL":
                del(key, word, list);
                break;
            default:
        }
    }

    //funkcja wyświetlająca wynik
    public static void show(String[] list) {
        System.out.println(countOfStrings);
        for (int i = 0; i < 101; i++) {
            if (list[i] != null && !list[i].equals("")) {
                System.out.println(i + ":" + list[i]);
            }
        }
    }


    //główna metoda pobiera informacje ile ma być testów i ile testy mają operacji
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        //pętla po testach
        for (int i = 0; i < numberOfTests; i++) {

            int numberOfOperations = Integer.parseInt(scanner.nextLine());
            countOfStrings = 0;
            String[] hashedList = new String[101];//tablica hashująca
            //pętla po operacjach
            for (int j = 0; j < numberOfOperations; j++) {
                hashIt(hashedList, scanner);
            }
            //wyświetlanie wyniku
            show(hashedList);
            System.out.println();
        }
    }
}
