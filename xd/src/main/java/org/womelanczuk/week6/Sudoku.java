package org.womelanczuk.week6;

import java.util.Scanner;

public class Sudoku {
    private static final int TIME_LIMIT = 500;
    private static long startTime = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static int [][] grid = new int[9][9];

    //wczytanie sudoku
    public static void fillSudoku(){
        String input = scanner.nextLine();
        int x = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(input.charAt(x) == '.'){
                    grid[i][j] = 0;
                    x++;
                    continue;
                }
                grid[i][j] = input.charAt(x++) - '0';
            }
        }
    }
    //algorytm backtrackingu i jego implementacja
    private static boolean solveSudoku() {
        long currentTime = System.currentTimeMillis();
        if(currentTime - startTime > TIME_LIMIT) {
            return false;
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValidPlacement(row, col, num)) {
                            grid[row][col] = num;
                            if (solveSudoku()) {
                                return true;
                            }
                            grid[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    //sprawdzanie poprawności
    private static boolean isValidPlacement(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num || grid[i][col] == num || grid[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    //wyświetlenie sudoku
    private static void printSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j]);
            }
        }
    }
    public static void main(String[] args) {
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<numberOfTests; i++){
            fillSudoku();
            startTime = System.currentTimeMillis();
            if(solveSudoku()){
                System.out.println("Y");
                printSudoku();
                System.out.println();
            }else{
                System.out.println("N");
            }
        }
        scanner.close();
    }
}
