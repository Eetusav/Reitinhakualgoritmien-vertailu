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
public class MyHashSetTest {

    public MyHashSetTest() {
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
    public void addingAndSizeWorks() {
        MyHashSet set = new MyHashSet();
        Solmu s1 = new Solmu("a");
        Solmu s2 = new Solmu("b");
        assertTrue(set.add(s1));
        assertTrue(set.add(s2));
        assertFalse(set.add(s1));
        assertEquals(set.size(), 2);
    }

    @Test
    public void containsAndRemoveWorks() {
        MyHashSet set = new MyHashSet();
        Solmu s1 = new Solmu("a");
        Solmu s2 = new Solmu("b");
        set.add(s1);
        assertTrue(set.contains(s1));
        assertFalse(set.contains(s2));
        set.remove(s1);
        assertFalse(set.contains(s1));
    }

    @Test
    public void getSolmutWorks() {
        MyHashSet set = new MyHashSet(1);
        Solmu s1 = new Solmu("a");
        Solmu s2 = new Solmu("b");
        set.add(s1);
        set.add(s2);
        Solmu[] lista = set.getSolmut();
        assertEquals(lista[0], s1);
        assertEquals(lista[1], s2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addSomethingThatIsNull() {
        MyHashSet set = new MyHashSet();
        Solmu a = null;
        set.add(a);
    }

    @Test
    public void containsSomethingFromBucketWithManyElements() {
        MyHashSet set = new MyHashSet(1);
        Solmu s1 = new Solmu("a111");
        Solmu s2 = new Solmu("b123");
        set.add(s1);
        set.add(s2);
        assertTrue(set.contains(s2));
        assertTrue(set.contains(s1));
    }

    @Test
    public void removingSomethingFromBucketWithManyElements() {
        MyHashSet set = new MyHashSet(1);
        Solmu s1 = new Solmu("a111");
        Solmu s2 = new Solmu("b123");
        set.add(s1);
        set.add(s2);
        set.remove(s2);
        assertEquals(set.getSolmut().length, 1);
    }

}
