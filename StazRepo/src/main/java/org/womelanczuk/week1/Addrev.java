package org.womelanczuk.week1;

import java.util.Scanner;
public class Addrev {
    public static void main(String[] args) {
     String wynik="", pom="" , linia="";
     String[] wyrazy;
     StringBuilder odwrocony;
     Scanner scanner;
     int koniec=0, suma=0;
     scanner = new Scanner(System.in);
     System.out.println("podaj ilosc");
     koniec = Integer.parseInt(scanner.nextLine());
     for(int i = 0; i < koniec; i++){
         System.out.println("podaj cyfry do sumowania");
         linia = scanner.nextLine();
         wyrazy = linia.split(" ");
         for(String wyraz : wyrazy){
             odwrocony = new StringBuilder(wyraz).reverse();
             pom = odwrocony.toString();
             suma += Integer.parseInt(pom);
         }
         odwrocony = new StringBuilder(Integer.toString(suma)).reverse();
         suma = 0;
         wynik = odwrocony.toString();
         System.out.println(Integer.parseInt(wynik));
     }
        scanner.close();
    }

}