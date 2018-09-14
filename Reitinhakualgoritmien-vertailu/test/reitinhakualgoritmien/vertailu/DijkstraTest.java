/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reitinhakualgoritmien.vertailu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tietorakenteet.MyHashSet;
import tietorakenteet.Solmu;
import tietorakenteet.Verkko;

/**
 *
 * @author Matti
 */
public class DijkstraTest {

    public DijkstraTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void algoritmiToimiiPienellaVerkolla() {
        Solmu A = new Solmu("A");
        Solmu B = new Solmu("B");
        Solmu C = new Solmu("C");
        Solmu D = new Solmu("D");
        Solmu E = new Solmu("E");
        Solmu F = new Solmu("F");

        A.lisaaVierussolmu(B, 21);
        A.lisaaVierussolmu(C, 14);

        B.lisaaVierussolmu(D, 15);
        B.lisaaVierussolmu(F, 12);

        C.lisaaVierussolmu(E, 7);

        D.lisaaVierussolmu(E, 4);
        D.lisaaVierussolmu(F, 8);

        F.lisaaVierussolmu(E, 10);

        Verkko graph = new Verkko();

        MyHashSet s = new MyHashSet();
        s.add(A);
        s.add(B);
        s.add(C);
        s.add(D);
        s.add(E);
        s.add(F);

        graph.lisaaSolmu(A);
        graph.lisaaSolmu(B);
        graph.lisaaSolmu(C);
        graph.lisaaSolmu(D);
        graph.lisaaSolmu(E);
        graph.lisaaSolmu(F);

        graph = Dijkstra.dijkstra(graph, A);
        assertEquals(A.getEtaisyys(), (Integer) 0);
        assertEquals(B.getEtaisyys(), (Integer) 21);
        assertEquals(C.getEtaisyys(), (Integer) 14);
        assertEquals(D.getEtaisyys(), (Integer) 36);
        assertEquals(E.getEtaisyys(), (Integer) 21);
        assertEquals(F.getEtaisyys(), (Integer) 33);
    }
}
