/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.utiliteetit;

import static fi.helsinki.reitinhakualgoritmien.vertailu.FloydWarshall.floydWarshall;
//import static reitinhakualgoritmien.vertailu.FloydWarshall.floydWarshall;
import fi.helsinki.tietorakenteet.Solmu;
import fi.helsinki.tietorakenteet.Verkko;
import fi.helsinki.reitinhakualgoritmien.vertailu.Dijkstra;

/**
 *
 * @author Matti
 */
public class VerkkoGeneraattori {
    /**
     * Yksinkertainen työkalu, jolla voi tehdä (suuren) 'jono' omaisen verkon, jolla voi testata nopeasti Dijkstran algoritmin ajankulutusta.
     * @param size Verkon solmujen lukumäärä
     * @param etaisyys Mikä etäisyys solmujen välille asetetaan.
     * @return Palautetaan verkko, joka sisältää solmut ja niiden lyhimmät etäisyydet ensimmäiseen solmuun (a0).
     */
    public Verkko simpleGraph(int size, int etaisyys) {
        Verkko graph2 = new Verkko();
        Solmu[] lista2 = new Solmu[size];
        for (int i = 0; i < size; i++) {
            lista2[i] = new Solmu("a" + i);
        }

        for (int i = 0; i < size - 1; i++) {
            lista2[i].lisaaVierussolmu(lista2[i + 1], etaisyys);
        }
        for (int i = 0; i < size; i++) {
            graph2.lisaaSolmu(lista2[i]);
        }
//        System.out.println("Timestamp here");
        Solmu A = lista2[0];
//        System.out.println("Timestamp here");
        long start = System.nanoTime();
        graph2 = Dijkstra.dijkstra(graph2, A);
        long end = System.nanoTime();
        long milliseconds = (end - start) / 1000000;
        System.out.println("Dijkstra: " + milliseconds + " ms");
//        for (Solmu solmu : graph2.getSolmut()) {
//            System.out.println("Nimi: " + solmu.getNimi() + " ja Etäisyys: " + solmu.getEtaisyys());
//        }
        return graph2;
    }
    /**
     * Yksinkertainen työkalu, jolla voi tehdä (suuren) tiheän verkon, jolla voi testata nopeasti Dijkstran algoritmin ajankulutusta.
     * @param size Verkon solmujen lukumäärä
     * @param etaisyys Mikä etäisyys solmujen välille asetetaan.
     * @return Palautetaan verkko, joka sisältää solmut ja niiden lyhimmät etäisyydet ensimmäiseen solmuun (a0).
     */
    public Verkko thickGraph(int size, int etaisyys) {
        Verkko graph2 = new Verkko();
        Solmu[] lista2 = new Solmu[size];
        for (int i = 0; i < size; i++) {
            lista2[i] = new Solmu("a" + i);
        }
//        etaisyys = (int) Math.floor(Math.random() * 100) + 1;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size-1; j++) {
                if (j != i) {
                    lista2[i].lisaaVierussolmu(lista2[j], etaisyys);
                } 
            }
        }
        for (int i = 0; i < size; i++) {
            graph2.lisaaSolmu(lista2[i]);
        }
        Solmu A = lista2[0];
        long start = System.nanoTime();
        graph2 = Dijkstra.dijkstra(graph2, A);
        long end = System.nanoTime();
        long milliseconds = (end - start) / 1000000;
        System.out.println("Dijkstra tiheällä verkolla: " + milliseconds + " ms");
        return graph2;
    }
    /**
     * 
     * Yksinkertainen työkalu, jolla voi tehdä (suuren) 'jono' omaisen verkon, jolla voi testata nopeasti Floyd-Warshallin algoritmin ajankulutusta.
     * @param size Verkon solmujen lukumäärä
     * @param etaisyys Mikä etäisyys solmujen välille asetetaan.
     * @return Palautetaan verkko, joka sisältää solmut ja niiden lyhimmät etäisyydet kaikkiin muihin solmuihin.
     */
    public int[][] simpleSheet(int size, int etaisyys) {
        int[][] t = new int[size][size];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                t[i][j] = 99999;
            }
        }
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length-1; j++) {
                if (i == j){
                    t[i][j+1] = etaisyys;
                }
            }
        }
        long start = System.nanoTime();
        t = floydWarshall(t);
        long end = System.nanoTime();
        long milliseconds = (end - start) / 1000000;
        System.out.println("Floyd Warshall: " + milliseconds + " ms");
        return t;
    }
}
