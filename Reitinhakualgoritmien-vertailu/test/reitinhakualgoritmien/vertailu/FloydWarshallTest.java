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
import static reitinhakualgoritmien.vertailu.FloydWarshall.floydWarshall;

/**
 *
 * @author Matti
 */
public class FloydWarshallTest {

    public FloydWarshallTest() {
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
    public void testaaAlgoaPienellaVerkolla() {
        int[][] t = new int[6][6];
        for (int i = 0 ; i < t.length ; i++){
            for (int j = 0 ; j < t.length ; j++){
                t[i][j] = 9999;
            }
        }
        t[0][1] = 21;
        t[0][2] = 14;
        t[1][3] = 15;
        t[1][5] = 12;
        t[2][4] = 7;
        t[3][4] = 4;
        t[3][5] = 8;
        t[5][4] = 10;
        t = floydWarshall(t);
        assertEquals(t[0][1], 21);
        assertEquals(t[0][3], 36);
        assertEquals(t[1][5], 12);
        assertEquals(t[2][4], 7);
        assertEquals(t[0][5], 33);
        assertEquals(t[3][4], 4);
        assertEquals(t[3][5], 8);
    }
}
