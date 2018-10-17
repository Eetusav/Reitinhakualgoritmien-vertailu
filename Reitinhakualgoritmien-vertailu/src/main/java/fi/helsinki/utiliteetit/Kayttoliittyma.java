/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.utiliteetit;

import fi.helsinki.tietorakenteet.Verkko;
import java.util.Scanner;

/**
 *
 * @author Matti
 */
public class Kayttoliittyma {

    public static void Ui() {
        VerkkoGeneraattori VG = new VerkkoGeneraattori();
        Scanner lukija = new Scanner(System.in);
        System.out.println("Mitä tehdään? Vaihtoehdot: verkko, lopeta");
        while (true) {
            String line = lukija.nextLine();
            if (line.equals("verkko")) {
                System.out.print("Verkon koko: ");
                int koko = Integer.parseInt(lukija.nextLine());
                System.out.print("Solmujen välinen etäisyys: ");
                int etaisyys = Integer.parseInt(lukija.nextLine());
                int[][] t;
                Verkko graph2 = VG.simpleGraph(koko, etaisyys);
                t = VG.simpleSheet(koko, etaisyys);
                Verkko graph3 = VG.thickGraph(koko, etaisyys);
            } else if (line.equals("lopeta")) {
                return;
            } else {
                System.out.println("Virheellinen syöte. Yritä uudestaan. ");
            }
        }
    }

}
