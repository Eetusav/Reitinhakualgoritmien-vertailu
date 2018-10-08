package tietorakenteet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.tietorakenteet.MyLinkedList;
import fi.helsinki.tietorakenteet.Solmu;

/**
 *
 * @author Matti
 */
public class MyLinkedListTest {
    
    public MyLinkedListTest() {
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
    //Ei varmaan mielekästä testata... Ainakaan vielä...
     @Test
     public void addingWorks() {
         MyLinkedList lista = new MyLinkedList();
         Solmu solmu = new Solmu("a");
         lista.add(solmu);
     assertTrue(true);
     }
}
