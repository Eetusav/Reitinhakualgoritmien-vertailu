/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.reitinhakualgoritmien.vertailu;

import java.util.HashMap;
import java.util.Random;
//import static reitinhakualgoritmien.vertailu.FloydWarshall.floydWarshall;
import fi.helsinki.tietorakenteet.MyHashMap;
//import tietorakenteet.MyHashSet;
import fi.helsinki.tietorakenteet.Solmu;
import fi.helsinki.tietorakenteet.Verkko;
import fi.helsinki.tietorakenteet.MyLinkedList;
import fi.helsinki.utiliteetit.Kayttoliittyma;
import fi.helsinki.utiliteetit.VerkkoGeneraattori;

/**
 *
 * @author Matti
 */
public class ReitinhakualgoritmienVertailu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VerkkoGeneraattori VG = new VerkkoGeneraattori();
        Kayttoliittyma ui = new Kayttoliittyma();
        Kayttoliittyma.Ui();
        
    }

}
