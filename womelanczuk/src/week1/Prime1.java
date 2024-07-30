package week1;

import java.util.Scanner;

public class Prime1 {
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        if (number <= 3) {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(number);
        for (int i = 5; i <= sqrt; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int koniec = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < koniec; i++) {
            try {
                String linia = scanner.nextLine();
                String[] wyrazy = linia.split(" ");
                int begin = Integer.parseInt(wyrazy[0]);
                int end = Integer.parseInt(wyrazy[1]);

                if (begin < 2) {
                    begin = 2;
                }

                for (int number = begin; number <= end; number++) {
                    if (isPrime(number)) {
                        System.out.println(number);
                    }
                }
            } catch (Exception problem) {
                System.out.println(problem);
            }
            System.out.println();
        }
        scanner.close();
    }
}
