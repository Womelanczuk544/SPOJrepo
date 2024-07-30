package week2;

public class Kamil {
    public static void main(String[]a){
        for(int i=0,r=1;i<10;i++,System.out.println(r),r=1)
            for(var c:new java.util.Scanner(System.in).next().toCharArray())
                r=("TLDF".indexOf(c)<0)?r:r*2;
    }
}
