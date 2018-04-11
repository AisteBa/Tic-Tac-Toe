package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Zaidimas kryziukai-nuliukai");
        System.out.println("---------------------------");
        String laukas[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String X = "X";
        String O = "O";

        boolean arZaidziam = true;
        while (arZaidziam) {
            zaidimoLaukas(laukas);
            arZaidziam = arZaidziam(laukas, X, O);
            if (arZaidziam){
                zaidejoEjimas(laukas, X);
            }
            zaidimoLaukas(laukas);
            arZaidziam = arZaidziam(laukas, X, O);
            if (arZaidziam){
                zaidejoEjimas(laukas, O);
            }
        }
        if (arLaimejo(laukas, X)) {
            System.out.println("Laimejo X!");
        } else if (arLaimejo(laukas, O)) {
            System.out.println("Laimejo O!");
        } else if (arLygiosios(laukas)) {
            System.out.println("Lygiosios");
        }

    }

    public static boolean arZaidziam(String[] laukas, String X, String O){
        return !arLaimejo(laukas, X) && !arLaimejo(laukas, O) && !arLygiosios(laukas);
    }

    public static void zaidimoLaukas(String laukas[]) {

        System.out.println("_" + laukas[0] + "_|_" + laukas[1] + "_|_" + laukas[2] + "_");
        System.out.println("_" + laukas[3] + "_|_" + laukas[4] + "_|_" + laukas[5] + "_");
        System.out.println(" " + laukas[6] + " | " + laukas[7] + " | " + laukas[8] + " ");

    }

    public static void zaidejoEjimas(String laukas[], String zaidejas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Iveskite zaidejo " + zaidejas + " pozicija: ");

        boolean arReikiaKartoti = true;

        while(arReikiaKartoti) {
            int pozicija = scanner.nextInt();

            if (zaidejas.equals("O") && (!laukas[pozicija - 1].equals("X"))) {
                laukas[pozicija - 1] = "O";
                zaidejas = "X";
                arReikiaKartoti = false;
            } else if (zaidejas.equals("X") && (!laukas[pozicija - 1].equals("O"))) {
                laukas[pozicija - 1] = "X";
                zaidejas = "O";
                arReikiaKartoti = false;
            } else {
                System.out.println("Pozicija uzimta, iveskite kita");
                arReikiaKartoti = true;
            }

        }

    }

    public static boolean arLaimejo(String laukas[], String zenklas) {

        if (laukas[0].equals(zenklas) && laukas[1].equals(zenklas) && laukas[2].equals(zenklas) ||
                laukas[3].equals(zenklas) && laukas[4].equals(zenklas) && laukas[5].equals(zenklas) ||
                laukas[6].equals(zenklas) && laukas[7].equals(zenklas) && laukas[8].equals(zenklas) ||
                laukas[0].equals(zenklas) && laukas[3].equals(zenklas) && laukas[6].equals(zenklas) ||
                laukas[1].equals(zenklas) && laukas[4].equals(zenklas) && laukas[7].equals(zenklas) ||
                laukas[2].equals(zenklas) && laukas[5].equals(zenklas) && laukas[8].equals(zenklas) ||
                laukas[0].equals(zenklas) && laukas[4].equals(zenklas) && laukas[8].equals(zenklas) ||
                laukas[2].equals(zenklas) && laukas[4].equals(zenklas) && laukas[6].equals(zenklas)) {

            return true;
        }

        return false;
    }

    public static boolean arLygiosios(String laukas[]) {
        for (int i = 0; i < laukas.length; i++) {
            if (!(laukas[i].equals("X") || laukas[i].equals("O"))) {
                return false;
            }
        }
        return true;
    }
}