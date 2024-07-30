import java.util.Scanner;
public class Main {

    public static int cubeSolve(int x){
        if(x==1)
            return 1;
        return x*x + cubeSolve(x-1);
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner;
        scanner = new Scanner(System.in);
        while(true) {
            n = scanner.nextInt();
            if(n==0)
                break;
            System.out.println(cubeSolve(n));
        }
        scanner.close();
    }
}