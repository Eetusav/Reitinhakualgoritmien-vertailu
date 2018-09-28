/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiliteetit;

import reitinhakualgoritmien.vertailu.Dijkstra;
import static reitinhakualgoritmien.vertailu.FloydWarshall.floydWarshall;
import tietorakenteet.Solmu;
import tietorakenteet.Verkko;

/**
 *
 * @author Matti
 */
public class VerkkoGeneraattori {

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
        Solmu A = lista2[0];
//        System.out.println("Timestamp here");
        long start = System.nanoTime();
        graph2 = Dijkstra.dijkstra(graph2, A);
        long end = System.nanoTime();
        long microseconds = (end - start) / 1000;
        System.out.println("Dijkstra: " + microseconds);
//        for (Solmu solmu : graph2.getSolmut()) {
//            System.out.println("Nimi: " + solmu.getNimi() + " ja Etäisyys: " + solmu.getEtaisyys());
//        }
        return graph2;
    }

    public Verkko thickGraph(int size, int etaisyys) {
        Verkko graph2 = new Verkko();
        Solmu[] lista2 = new Solmu[size];
        for (int i = 0; i < size; i++) {
            lista2[i] = new Solmu("a" + i);
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size; j++) {
                if (lista2[i] != lista2[j]) {
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
        long microseconds = (end - start) / 1000;
        System.out.println("Dijkstra: " + microseconds);
        for (Solmu solmu : graph2.getSolmut()) {
            System.out.println("Nimi: " + solmu.getNimi() + " ja Etäisyys: " + solmu.getEtaisyys());
        }
        return graph2;
    }

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
        long microseconds = (end - start) / 1000;
        System.out.println("Floyd Warshall: " + microseconds);
//        for (int i = 0; i < t.length; i++) {
//            for (int j = 0; j < t.length; j++) {
//                System.out.print(t[i][j] + "   ");
//            }
//            System.out.println("");
//        }
        return t;
    }
}
