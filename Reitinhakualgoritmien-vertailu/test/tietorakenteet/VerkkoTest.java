/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matti
 */
public class VerkkoTest {
    
    public VerkkoTest() {
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
     public void addingAndGetSolmutWorks() {
     Verkko graph = new Verkko();
         Solmu A = new Solmu("A");
         Solmu B = new Solmu("B");
         Solmu C = new Solmu("C");
         graph.lisaaSolmu(A);
         graph.lisaaSolmu(B);
         graph.lisaaSolmu(C);
         assertEquals(graph.getSolmut().length, 3);
     }
}
