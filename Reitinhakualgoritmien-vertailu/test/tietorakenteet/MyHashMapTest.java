/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

import java.util.HashMap;
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
public class MyHashMapTest {

    public MyHashMapTest() {
    }

    @BeforeClass
    public static void setUpClass() {

        HashMap<Solmu, Integer> HashMap = new HashMap<Solmu, Integer>();
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

    @Test
    public void putJaGetMetoditToimii() {
        MyHashMap<String, Solmu> myHashMap = new MyHashMap<>();
        Solmu a = new Solmu("a");
        a.setEtaisyys(14);
        Solmu b = new Solmu("b");
        b.setEtaisyys(123);
        myHashMap.put("a", a);
        myHashMap.put("b", b);
        assertEquals(myHashMap.get("a").getEtaisyys(), (Integer) 14);
        assertEquals(myHashMap.get("b").getEtaisyys(), (Integer) 123);
    }

    @Test
    public void getSomethingThatIsNull() {
        MyHashMap<String, Solmu> myHashMap = new MyHashMap<>();
        assertEquals(null, myHashMap.get("123"));
    }

    @Test
    public void putMetodinYlikirjoitusToimii() {
        MyHashMap<String, Solmu> myHashMap = new MyHashMap<>();
        Solmu a = new Solmu("a");
        a.setEtaisyys(14);
        Solmu b = new Solmu("b");
        b.setEtaisyys(123);
        myHashMap.put("a", a);
        myHashMap.put("a", b);
        assertEquals(myHashMap.get("a").getNimi(), "b");
        assertEquals(myHashMap.get("a").getEtaisyys(), (Integer) 123);
    }
    @Test
    public void hashMapEntrySetToimii(){
        MyHashMap<String, Solmu> myHashMap = new MyHashMap<>();
        Solmu a = new Solmu("a");
        a.setEtaisyys(14);
        Solmu b = new Solmu("b");
        b.setEtaisyys(123);
        myHashMap.put("a",a);
        myHashMap.put("b", b);
        MyEntry<String, Solmu>[] t = myHashMap.entrySet();
        assertEquals(t[0].getValue(),a);
        assertEquals(t[1].getValue(),b);
        
    }

}
