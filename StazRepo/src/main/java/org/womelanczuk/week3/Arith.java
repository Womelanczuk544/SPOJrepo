package org.womelanczuk.week3;

import java.math.BigInteger;
import java.util.Scanner;

public class Arith {
    public static void addition(String number1, String number2){
        int stringDiv;
        int length = number2.length()+1;
        int maxLength = number1.length();

        //zamiana na big Int
        BigInteger bigNumber1 = new BigInteger(number1);
        BigInteger bigNumber2 = new BigInteger(number2);
        BigInteger bigResult = bigNumber1.add(bigNumber2);
        String resultString = bigResult.toString();

        //dodanie plusa do stringa
        number2 = "+" + number2;

        //sprawdzenie co większe żeby dobrze sformatować wyświetlanie
        if(resultString.length()>length)
            length = resultString.length();
        if(maxLength<length)
            maxLength = length;

        //wyświetlenie pokolei pierwszej i drugiej liczby oraz lini i wyniku
        stringDiv = maxLength - number1.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(number1);

        stringDiv = maxLength - number2.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(number2);

        for(int i=0; i<maxLength-length;i++)
            System.out.print(" ");
        for(int i=0;i<length;i++)
            System.out.print("-");
        System.out.println();

        stringDiv = maxLength - resultString.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(resultString);
        //koniec wyświetlania
    }
    public static void substraction(String number1, String number2){
        int stringDiv;
        int length = number2.length()+1;
        int maxLength = number1.length();

        //zamianza na big inta
        BigInteger bigNumber1 = new BigInteger(number1);
        BigInteger bigNumber2 = new BigInteger(number2);
        BigInteger bigResult = bigNumber1.subtract(bigNumber2);
        String resultString = bigResult.toString();

        //dodanie minusa do stringa
        number2 = "-" + number2;

        //sprawdzenie który string wiekszy
        if(resultString.length()>length)
            length = resultString.length();
        if(maxLength<length)
            maxLength = length;

        //wyświetlenie pokolei pierwszej i drugiej liczby oraz lini i wyniku
        stringDiv = maxLength - number1.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(number1);

        stringDiv = maxLength - number2.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(number2);

        for(int i=0; i<maxLength-length;i++)
            System.out.print(" ");
        for(int i=0;i<length;i++)
            System.out.print("-");
        System.out.println();

        stringDiv = maxLength - resultString.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(resultString);
        //koniec wyświetlania
    }
    public static void multiplication(String number1, String number2) {
        int maxLength = 0, firstLineInMultiplicationLength = 0;
        int stringDiv;
        String line = "";

        //zamiana na big int
        BigInteger bigNumber1 = new BigInteger(number1);
        BigInteger bigNumber2 = new BigInteger(number2);
        BigInteger bigResult = bigNumber1.multiply(bigNumber2);
        String resultString = bigResult.toString();

        //sprawdznie co jest wieksze żeby wiedzieć jak długie linie wyświetlać
        firstLineInMultiplicationLength = number2.length() + 1;
        maxLength = number2.length() + 1;
        if (resultString.length() > maxLength)
            maxLength = resultString.length();

        //wyświetlenie iloczynów
        stringDiv = maxLength - number1.length();
        for (int i = 0; i < stringDiv; i++)
            System.out.print(" ");
        System.out.println(number1);

        stringDiv = maxLength - (number2.length() + 1);
        for (int i = 0; i < stringDiv; i++)
            System.out.print(" ");
        System.out.println("*" + number2);

        //sprawdzenie czy musimy dodawać ogonek z dodawaniem
        if (number2.length() > 1)
            for (int i = number2.length() - 1; i >= 0; i--) {

                int intConversion = number2.charAt(i) - '0';
                String num = bigNumber1.multiply(BigInteger.valueOf(intConversion)).toString();

                //sprawdznie czy pierwsze przejście pętli żeby sprawdzić jak długa musi być linia
                if (i == number2.length() - 1) {

                    if (num.length() > firstLineInMultiplicationLength) {
                        firstLineInMultiplicationLength = num.length();
                    }
                    //wyświetlenie lini
                    String temp1 = String.format("%" + firstLineInMultiplicationLength + "s", "", line).replace(' ', '-');
                    String temp2 = String.format("%" + maxLength + "s", temp1);
                    System.out.println(temp2);

                }
                //oblicznie ilości spacji przed wypisaniem wyniku mnożenia oraz dodanie tej ilości spacji
                int freeSpace = maxLength - num.length() - ((number2.length() - 1) - i);
                if (freeSpace != 0) {
                    String num1 = String.format("%" + freeSpace + "s%s", "", num);
                    System.out.println(num1);
                } else {
                    System.out.println(num);
                }
            }

        // wypisanie lini końcowej oraz finalnego wyniku
        {
            String temp1 = String.format("%" + resultString.length() + "s", "", line).replace(' ', '-');
            String temp2 = String.format("%" + maxLength + "s", temp1);
            System.out.println(temp2);
        }

        stringDiv = maxLength - resultString.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(resultString);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(scanner.nextLine());

        for (int i =0;i<numberOfTests;i++){
            String line = scanner.nextLine();
            var numbers = line.split("[+\\-*]");
            String number1 =numbers[0];
            String number2 =numbers[1];

            //sprawdznie z jakim dzialaniem  mamy doczynienia
            if(line.indexOf('+')!=-1)
                addition(number1,number2);

            if(line.indexOf('-')!=-1)
                substraction(number1,number2);

            if(line.indexOf('*')!=-1)
                multiplication(number1,number2);

        }
        scanner.close();
    }
}
