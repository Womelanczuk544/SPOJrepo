import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    public static void addition(String number1, String number2){
        int stringDiv;
        int length = number1.length();

        BigInteger bigNumber1 = new BigInteger(number1);
        BigInteger bigNumber2 = new BigInteger(number2);
        BigInteger bigResult = bigNumber1.add(bigNumber2);
        String resultString = bigResult.toString();

        number2 = "+" + number2;

        if(number2.length()>length)
            length = number2.length();
        if(resultString.length()>length)
            length = resultString.length();

        stringDiv = length - number1.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(number1);

        stringDiv = length - number2.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(number2);

        for(int i=0;i<length;i++)
            System.out.print("-");
        System.out.println();

        stringDiv = length - resultString.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(resultString);
    }
    public static void substraction(String number1, String number2){
        int stringDiv;
        int length = number1.length();

        BigInteger bigNumber1 = new BigInteger(number1);
        BigInteger bigNumber2 = new BigInteger(number2);
        BigInteger bigResult = bigNumber1.subtract(bigNumber2);
        String resultString = bigResult.toString();

        number2 = "-" + number2;

        if(number2.length()>length)
            length = number2.length();
        if(resultString.length()>length)
            length = resultString.length();

        stringDiv = length - number1.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(number1);
        stringDiv = length - number2.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(number2);
        for(int i=0;i<length;i++)
            System.out.print("-");
        System.out.println();
        stringDiv = length - resultString.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(resultString);
    }
    public static void multiplication(String number1, String number2){
        int result;
        int maxLength = 0, firstLineInMultiplicationLength = 0;
        int stringDiv;

        BigInteger bigNumber1 = new BigInteger(number1);
        BigInteger bigNumber2 = new BigInteger(number2);
        BigInteger bigResult = bigNumber1.multiply(bigNumber2);
        String resultString = bigResult.toString();
        firstLineInMultiplicationLength = number1.length();
        maxLength = number1.length();

        List<String> listOfNumbers = new ArrayList<>();

        if(number2.length()>1)
            for(int i=number2.length()-1;i>=0;i--){
                int intConversion = number2.charAt(i) - '0';
                String num = bigNumber1.multiply(BigInteger.valueOf(intConversion)).toString();
                for(int j=number2.length()-1; j>i; j--)
                    num = num + " ";
                maxLength = num.length();
                listOfNumbers.add(num);
            }
        number2 = "*" + number2;
        if(number2.length()>firstLineInMultiplicationLength)
            firstLineInMultiplicationLength= number2.length();
        if(number2.length()>maxLength)
            maxLength= number2.length();
        if((!listOfNumbers.isEmpty()) && (listOfNumbers.get(0).length()>firstLineInMultiplicationLength))
            firstLineInMultiplicationLength = listOfNumbers.get(0).length();
        if((!listOfNumbers.isEmpty()) && (listOfNumbers.get(number2.length()-2).length()>maxLength))
            maxLength = resultString.length();
        if(resultString.length()>maxLength)
            maxLength = resultString.length();
        if(listOfNumbers.isEmpty() && resultString.length()>firstLineInMultiplicationLength)
            firstLineInMultiplicationLength = resultString.length();

        stringDiv = maxLength - number1.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(number1);
        stringDiv = maxLength - number2.length();
        for(int i=0;i<stringDiv;i++)
            System.out.print(" ");
        System.out.println(number2);
        for(int i=0;i<maxLength-firstLineInMultiplicationLength;i++)
            System.out.print(" ");
        for(int i=0;i<firstLineInMultiplicationLength;i++)
            System.out.print("-");
        System.out.println();
        if(!listOfNumbers.isEmpty()){
            for(var num : listOfNumbers){
                stringDiv = maxLength - num.length();
                for(int i=0;i<stringDiv;i++)
                    System.out.print(" ");
                System.out.println(num);
            }
            if(resultString.length()>maxLength)
                maxLength = resultString.length();
            for(int i=0;i<maxLength;i++)
                System.out.print("-");
            System.out.println();
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
            char sign;
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