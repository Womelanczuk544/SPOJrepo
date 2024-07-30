package week2;

import java.util.Scanner;
import java.util.Vector;

public class Onp {
    public static String rPN(String exp){
        String result="";
        Vector<Character> temp = new Vector<>();

        for(int i = 0; i<exp.length(); i++){
            if(exp.charAt(i)=='(') {
                temp.add('(');
                continue;
            }
            if(exp.charAt(i)==')') {
                while (!temp.isEmpty()){
                    if(!temp.isEmpty() && temp.lastElement()=='(') {
                        temp.remove(temp.size()-1);
                        break;
                    }
                    result += temp.lastElement();
                    temp.remove(temp.size()-1);
                }
                continue;
            }
            if(exp.charAt(i)=='+'||exp.charAt(i)=='-'){
                while (!temp.isEmpty()){
                    if(!temp.isEmpty() && temp.lastElement()=='(')
                        break;
                    result += temp.lastElement();
                    temp.remove(temp.size()-1);
                }
                temp.add(exp.charAt(i));
                continue;
            }
            if(exp.charAt(i)=='*'||exp.charAt(i)=='/'){
                while (!temp.isEmpty()){
                    if(!temp.isEmpty() && (temp.lastElement()=='(' || temp.lastElement()=='+' || temp.lastElement()=='-'))
                        break;
                    result += temp.lastElement();
                    temp.remove(temp.size()-1);
                }
                temp.add(exp.charAt(i));
                continue;
            }
            if(exp.charAt(i)=='^') {
                if(!temp.isEmpty() && temp.lastElement()=='^') {
                    result += temp.lastElement();
                }else{
                    temp.add('^');
                }
                continue;
            }
            result += exp.charAt(i);
        }
        while(!temp.isEmpty()){
            result+=temp.lastElement();
            temp.remove(temp.size()-1);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression,result;
        int n = Integer.parseInt(scanner.nextLine());

        for(int i =0; i < n; i++){
            expression = scanner.nextLine();
            result = rPN(expression);
            System.out.println(result);
        }
        scanner.close();
    }
}
