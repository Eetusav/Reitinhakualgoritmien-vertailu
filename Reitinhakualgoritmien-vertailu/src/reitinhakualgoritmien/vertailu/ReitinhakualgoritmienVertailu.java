/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reitinhakualgoritmien.vertailu;

import java.util.HashMap;
import java.util.Random;
import static reitinhakualgoritmien.vertailu.FloydWarshall.floydWarshall;
import tietorakenteet.MyHashMap;
import tietorakenteet.MyHashSet;
import tietorakenteet.Solmu;
import tietorakenteet.Verkko;
import tietorakenteet.MyLinkedList;
import utiliteetit.VerkkoGeneraattori;

/**
 *
 * @author Matti
 */
public class ReitinhakualgoritmienVertailu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//         TODO code application logic here
        VerkkoGeneraattori VG = new VerkkoGeneraattori();
        
//        Solmu A = new Solmu("A");
//        Solmu B = new Solmu("B");
//        Solmu C = new Solmu("C");
//        Solmu D = new Solmu("D");
//        Solmu E = new Solmu("E");
//        Solmu F = new Solmu("F");
//
//        A.lisaaVierussolmu(B, 21);
//        A.lisaaVierussolmu(C, 14);
//        B.lisaaVierussolmu(D, 15);
//        B.lisaaVierussolmu(F, 12);
//        C.lisaaVierussolmu(E, 7);
//        D.lisaaVierussolmu(E, 4);
//        D.lisaaVierussolmu(F, 8);
//        F.lisaaVierussolmu(E, 10);
//        
//
//
//        Verkko graph = new Verkko();
//        MyHashSet s = new MyHashSet();
//        s.add(A);
//        s.add(B);
//        s.add(C);
//        s.add(D);
//        s.add(E);
//        s.add(F);
//        Boolean jou = s.add(A);
//
//        graph.lisaaSolmu(A);
//        graph.lisaaSolmu(B);
//        graph.lisaaSolmu(C);
//        graph.lisaaSolmu(D);
//        graph.lisaaSolmu(E);
//        graph.lisaaSolmu(F);
//        
//        long start1 = System.nanoTime();
//        graph = Dijkstra.dijkstra(graph, A);
//        long end1 = System.nanoTime();
//        long microseconds1 = (end1 - start1) / 1000;
//        System.out.println("Dijkstra: " + microseconds1);
//        for (Solmu solmu : graph.getSolmut()) {
//            System.out.println(solmu.getNimi() + "" + solmu.getEtaisyys());
//        }
//
//        int[][] t = new int[6][6];
//        for (int i = 0 ; i < t.length ; i++){
//            for (int j = 0 ; j < t.length ; j++){
//                t[i][j] = 9999;
//            }
//        }
//        t[0][1] = 21;
//        t[0][2] = 14;
//        t[1][3] = 15;
//        t[1][5] = 12;
//        t[2][4] = 7;
//        t[3][4] = 4;
//        t[3][5] = 8;
//        t[5][4] = 10;
//        long start = System.nanoTime();
//        t = floydWarshall(t);
//        long end = System.nanoTime();
//        long microseconds = (end - start) / 1000;
//        System.out.println("Floyd Warshall: " +microseconds);
//        for (int i = 0 ; i < t.length ; i++){
//            for (int j = 0 ; j < t.length ; j++){
//                System.out.print(t[i][j] + "   ");
//            }
//            System.out.println("");
//        }
        
        int[][] t;
        Verkko graph2 = VG.simpleGraph(3000, 5);
        t = VG.simpleSheet(3000, 5);
        
        
    }

}
