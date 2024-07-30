package org.womelanczuk.week1;

import java.util.Scanner;

public class Imagerec1 {
    static public int waitForInt(Scanner in){
        String tmp;
        while(true){
            tmp = in.nextLine();
            try{
                int result = Integer.parseInt(tmp);
                return result;
            }
            catch(NumberFormatException ex){

            }
        }
    }

    public static char xOrYCheck(String[] tab, int wys, int szer)
    {
        try {
            int[] pierwszy = new int[2];
            int[] poPrawej = new int[2];
            int[] naDole = new int[2];
            int[] ostatni = new int[2];
            int roznica;
            double poloweczka;
            boolean przypadekPierwszy = false, znaleziono = false, nieZnaleziono = true;
            for (int i = 0; i < wys; i++) {
                for (int j = 0; j < szer; j++) {
                    if (tab[i].charAt(j) == 'x') {
                        znaleziono = true;
                        pierwszy[0] = j;
                        pierwszy[1] = i;
                        for (int x = j; x < szer; x++) {
                            if (tab[i].charAt(x) == 'x') {
                                poPrawej[0] = x;
                                poPrawej[1] = pierwszy[1];
                                przypadekPierwszy = true;
                            }
                        }
                        if (przypadekPierwszy) {
                            roznica = poPrawej[0] - pierwszy[0];
                            if (tab[pierwszy[1] + roznica].charAt(pierwszy[0]) == 'x') {
                                poloweczka = roznica / 2;
                                naDole[0] = pierwszy[0];
                                naDole[1] = pierwszy[1] + roznica;
                                if (tab[naDole[1]].charAt(naDole[0] + roznica) == 'x') {
                                    ostatni[0] = naDole[0] + roznica;
                                    ostatni[1] = naDole[1];
                                    if (tab[pierwszy[1] + (int) Math.ceil(poloweczka)].charAt(pierwszy[0] + (int) Math.ceil(poloweczka)) == 'x') {
                                        return 'x';
                                    } else {
                                        return '0';
                                    }
                                }
                            } else if (tab[i + roznica - 1].charAt(pierwszy[0]) == 'x') {
                                poloweczka = (roznica - 1 / 2);
                                naDole[0] = i + roznica - 1;
                                naDole[1] = pierwszy[1];
                                if (tab[naDole[1]].charAt(naDole[0] + roznica - 1) == 'x') {
                                    ostatni[0] = naDole[0] + roznica - 1;
                                    ostatni[1] = naDole[1];
                                    if (tab[pierwszy[1] + (int) Math.ceil(poloweczka)].charAt(pierwszy[0] + (int) Math.ceil(poloweczka)) == 'x') {
                                        return 'x';
                                    } else {
                                        return '0';
                                    }
                                }
                            }

                        } else {
                            for (int y = i; y < wys; y++) {
                                if (tab[y].charAt(j) == 'x') {
                                    naDole[0] = j;
                                    naDole[1] = y;
                                    nieZnaleziono = false;
                                }
                            }
                            if(nieZnaleziono)
                                continue;
                            roznica = naDole[1] - pierwszy[1];
                            poloweczka = roznica / 2;
                            if ((tab[pierwszy[1] + (int) poloweczka].charAt(pierwszy[0] - (int) poloweczka) == 'x') && (tab[pierwszy[1] + (int) poloweczka].charAt(pierwszy[0] + (int) poloweczka) == 'x')) {
                                if (tab[pierwszy[1] + (int) poloweczka].charAt(pierwszy[0]) == 'x')
                                    return 'x';
                                else
                                    return '0';
                            }
                            poloweczka = (roznica - 1) / 2;
                            if ((tab[pierwszy[1] + (int) poloweczka].charAt(pierwszy[0] - (int) poloweczka) == 'x') && (tab[pierwszy[1] + (int) poloweczka].charAt(pierwszy[0] + (int) poloweczka) == 'x')) {
                                if (tab[pierwszy[1] + (int) poloweczka].charAt(pierwszy[0]) == 'x')
                                    return 'x';
                                else
                                    return '0';
                            }
                        }
                    }
                    if (znaleziono)
                        return '0';
                }
            }
            return '0';
        }catch (Exception problem){
            return '0';
        }
    }

    public static void main(String[] args) {
        String wynik = "", pom = "", linia = "";
        String[] wyrazy;
        char znak;
        Scanner scanner;
        int koniec = 0, koniec2, suma = 0, wys = 0, szer = 0;
        scanner = new Scanner(System.in);
        koniec = waitForInt(scanner);
        for (int i = 0; i < koniec; i++) {
            koniec2 = waitForInt(scanner);
            pom = scanner.nextLine();
            for (int j = 0; j < koniec2; j++) {
                linia = scanner.nextLine();//tu trafiają wymiary
                wyrazy = linia.split(" ");
                wys = Integer.parseInt(wyrazy[0]);
                szer = Integer.parseInt(wyrazy[1]);
                String[] tab = new String[wys];
                for (int y = 0; y < wys; y++) {
                    linia = scanner.nextLine();//a tu się tablica tworzy ze zdjęciem
                    tab[y] = linia;
                }
                znak = xOrYCheck(tab, wys, szer);
                wynik += znak;
            }
            System.out.println(wynik);
            wynik="";
        }
        scanner.close();
    }
}
