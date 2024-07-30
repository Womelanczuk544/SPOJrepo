package week1;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Stpar {
    public static boolean validate( Vector<Integer> inputRoad){
        Vector<Integer> tempRoad = new Vector<>();
        Vector<Integer> outputRoad = new Vector<>();
        while(inputRoad.size()!=0 || tempRoad.size()!=0)
        {
            if(inputRoad.isEmpty() && !tempRoad.isEmpty())
                return true;
            if(inputRoad.size()!=1)
            {
                if(!outputRoad.isEmpty() && inputRoad.lastElement()<outputRoad.lastElement())
                    return false;
                if(!tempRoad.isEmpty() && ((outputRoad.isEmpty()||outputRoad.lastElement()< tempRoad.lastElement()) && tempRoad.lastElement()< inputRoad.lastElement()))
                {
                    outputRoad.add(tempRoad.lastElement());
                    tempRoad.remove(tempRoad.lastElement());
                    continue;
                }
                if(inputRoad.lastElement()<inputRoad.elementAt(inputRoad.size()-2)&&((outputRoad.size()==0)||(inputRoad.lastElement()> outputRoad.lastElement())))
                {
                    outputRoad.add(inputRoad.lastElement());
                    inputRoad.remove(inputRoad.lastElement());
                    continue;
                }
                if(inputRoad.lastElement()>inputRoad.elementAt(inputRoad.size()-2)&&((tempRoad.size()==0)||(inputRoad.lastElement()< tempRoad.lastElement())))
                {
                    tempRoad.add(inputRoad.lastElement());
                    inputRoad.remove(inputRoad.lastElement());
                    continue;
                }
                return false;
            }
            else{
                if(!outputRoad.isEmpty() && inputRoad.lastElement()<outputRoad.lastElement())
                    return false;
                if(!tempRoad.isEmpty() && ((outputRoad.isEmpty()||outputRoad.lastElement()< tempRoad.lastElement()) && tempRoad.lastElement()< inputRoad.lastElement()))
                {
                    outputRoad.add(tempRoad.lastElement());
                    tempRoad.remove(tempRoad.lastElement());
                    continue;
                }
                if(outputRoad.isEmpty()||(inputRoad.lastElement()> outputRoad.lastElement()))
                {
                    outputRoad.add(inputRoad.lastElement());
                    inputRoad.remove(inputRoad.lastElement());
                    continue;
                }
                if(tempRoad.isEmpty()||(inputRoad.lastElement()< tempRoad.lastElement()))
                {
                    tempRoad.add(inputRoad.lastElement());
                    inputRoad.remove(inputRoad.lastElement());
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n;
        String linia;
        String[] wyrazy;
        Scanner scanner;
        Vector<Integer> inputRoad = new Vector<>();
        scanner = new Scanner(System.in);
        while(true) {
            n = Integer.parseInt(scanner.nextLine());
            if(n==0)
                break;
            linia = scanner.nextLine();
            wyrazy = linia.split(" ");
            for(String wyraz : wyrazy){
                inputRoad.add(Integer.parseInt(wyraz));
            }
            Collections.reverse(inputRoad);
            if(validate(inputRoad))
                System.out.println("yes");
            else
                System.out.println("no");
            inputRoad.removeAllElements();
        }
        scanner.close();
    }
}
