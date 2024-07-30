package week3;

import java.util.Arrays;
import java.util.Scanner;

public class Palin {
    //metoda zmieniająca numer w palindrom
    public static char[] palinChanger(char[] array, String originalNumber){
        boolean isChanged = false;
        for(int j=originalNumber.length()/2-1; j>=0;j--){
            //zamiana 9 na zero
            if(array[j]=='9'){
                array[j] = '0';
                array[originalNumber.length()-1-j] = '0';
                continue;
            }
            //wyrównywanie cyfr
            array[j] = (char) (originalNumber.charAt(j) + 1);
            array[originalNumber.length()-1-j] = (char) (originalNumber.charAt(j) + 1);
            isChanged = true;
            break;
        }
        //dokładanie 1 na końcu
        if(!isChanged){
            String temporaryString = new String(array);
            temporaryString = '1'+temporaryString;
            array = temporaryString.toCharArray();
            array[originalNumber.length()] = '1';
        }
        return array;
    }
    public static void main(String[] args) {
        //implementacja sccanera
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<numberOfTests;i++){
            //implementacja zmiennych
            String number = scanner.nextLine();
            StringBuilder reversedBuilder = new StringBuilder(number);
            String reversNumber = reversedBuilder.reverse().toString();
            char[] charArrayToRebuildString = number.toCharArray();

            if(number.length() !=1){
                //przypadek w którym mamy doczynienia z palindromem i szukamy jedynie najmniejszego kolejnego
                if(number.equals(reversNumber)){
                    if(number.length()%2==0){
                        charArrayToRebuildString = palinChanger(charArrayToRebuildString, number);
                    }else {
                        if (charArrayToRebuildString[number.length() / 2] != '9') {
                            charArrayToRebuildString[number.length() / 2] = (char) (number.charAt(number.length() / 2) + 1);
                        } else{
                            charArrayToRebuildString[number.length() / 2] = '0';
                            charArrayToRebuildString = palinChanger(charArrayToRebuildString, number);
                        }
                    }
                }else{
                    //przypadek w którym najpierw uzyskujemy palindrom, a nastepnie szukamy najmniejszego wiekszego od poprzedniej liczby
                    if(number.length()%2==0) {
                        for (int j = 0; j < (number.length()) / 2; j++) {
                            charArrayToRebuildString[number.length()-1-j] = number.charAt(j);
                        }
                        for(int j = number.length()/2;j<number.length();j++){
                            if(charArrayToRebuildString[j]<number.charAt(j)){
                                charArrayToRebuildString = palinChanger(charArrayToRebuildString, number);
                                break;
                            }
                            if(charArrayToRebuildString[j]>number.charAt(j)){
                                break;
                            }
                        }
                    }else{
                        for (int j = 0; j < (number.length()) / 2; j++) {
                            charArrayToRebuildString[number.length()-1-j] = number.charAt(j);
                        }
                        for(int j = number.length()/2+1;j<number.length();j++){
                            if(charArrayToRebuildString[j]<number.charAt(j)){
                                if (charArrayToRebuildString[number.length() / 2] != '9') {
                                    charArrayToRebuildString[number.length() / 2] = (char) (number.charAt(number.length() / 2) + 1);
                                } else {
                                    charArrayToRebuildString[number.length() / 2] = '0';
                                    charArrayToRebuildString = palinChanger(charArrayToRebuildString, number);
                                }
                                break;
                            }
                            if(charArrayToRebuildString[j]>number.charAt(j)){
                                break;
                            }
                        }
                    }
                }
            }else{
                //przypadek dla Stringa długości jeden
                if(charArrayToRebuildString[0]!='9'){
                    charArrayToRebuildString[0] = (char)(number.charAt(0) + 1);
                }else {
                    String temp = "11";
                    charArrayToRebuildString = temp.toCharArray();
                }
            }

            String result = new String(charArrayToRebuildString);
            System.out.println(result);
        }
        scanner.close();
    }
}
