/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

/**
 *
 * @author Matti
 */
public class MyHashSet {

    // add, remove, size, contains
    private Solmu[] buckets;
//    private int current;
    private int currentSize;

    /**
     * Oletuskonstruktori HashSetille
     */
    public MyHashSet() {
        buckets = new Solmu[5000];
        currentSize = 0;
    }

    /**
     * Konstruktori HashSetille, jossa voi valita ämpärien koon.
     * @param bucketsSize Ämpärien koko.
     */
    public MyHashSet(int bucketsSize) {
        buckets = new Solmu[bucketsSize];
        currentSize = 0;
    }
    /**
     * Lisää parametrina annetun solmun HashSettiin. Jos solmu on jo siellä, niin ei lisätä.
     * @param solmu Lisättävä solmu
     * @return Palauttaa true jos solmu lisättiin, muuten false
     */
    public boolean add(Solmu solmu) {
        throwIfKeyIsNull(solmu);
        int bucketIndex = bucketIndexForKey(solmu);
        Solmu s = buckets[bucketIndex];
        if (s != null) {
            boolean lisatty = false;
            while (!lisatty) {
                if (s.equals(solmu)) {
//                    s = solmu;
//                    lisatty = true;
                    return false;
                } else if (s.getNext() == null) {
                    s.setNext(solmu);
                    currentSize++;
                    lisatty = true;                    
                }
                s.getNext();
            }
        } else {
            buckets[bucketIndex] = solmu;
            currentSize++;
        }
        if (currentSize > (buckets.length * 0.75)) {
            kasvata();
        }
        return true;
    }

    /**
     * Palauttaa HashSetin alkioiden lukumäärän.
     * @return HashSetin koko
     */
    public int size() {
        return currentSize;
    }
    /**
     * Tarkastaa onko parametrina annettu solmu HashSetissä
     * @param solmu Solmu, joka halutaan tarkistaa, että onko se joukossa
     * @return Jos solmu on HashSetissä, niin palautetaan true, muuten false
     */
    public boolean contains(Solmu solmu) {
        int bucketIndex = bucketIndexForKey(solmu);
        Solmu s = buckets[bucketIndex];
        if (s != null) {
            boolean sisaltyyko = false;
            while (!sisaltyyko) {
                if (s.equals(solmu)) {
                    return true;
                }
                s=s.getNext();
            }
        }
        return false;
    }
    /**
     * Poistaa parametrina annetun solmun HashSetistä. Jos solmua ei ole HashSetissä, niin mitään ei tapahdu.
     * @param solmu Poistettava solmu
     */
    public void remove(Solmu solmu) {
//        if (solmu == null){
//            return;
//        }
        int bucketIndex = bucketIndexForKey(solmu);
        Solmu s = buckets[bucketIndex];
        if (s.equals(solmu)) {
            buckets[bucketIndex] = s.getNext();
            currentSize--;
        }
        boolean b = false;
        while (!b) {
            if (s.getNext() != null) {
                Solmu temp = s.getNext();
                if (temp.equals(solmu)) {
                    s.setNext(temp.getNext());
                    b = true;
                    currentSize--;
                }
                s.getNext();
            }
            b = true;
        }

    }
    /**
     * Palauttaa HashSetin alkiot 
     * @return Lista HashSetin alkioista
     */
    public Solmu[] getSolmut() {
        int size = 0;
        for (int i = 0; i < buckets.length; i++) {
            Solmu s = buckets[i];
            if (s != null) {
                size++;
                while (s.getNext() != null) {
                    s=s.getNext();
                    size++;                
                }
            }
        }
        Solmu[] pal = new Solmu[size];
        int toIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            Solmu s = buckets[i];
            if (s != null) {
                pal[toIndex] = s;
                toIndex++;
                while (s.getNext() != null) {
                    s=s.getNext();
                    pal[toIndex] = s;
                    toIndex++;                 
                }
            }
        }
        return pal;
    }

    private void kasvata() {
        Solmu[] temp = buckets;
        buckets = new Solmu[buckets.length * 2];
        for (int i = 0; i < temp.length; i++) {
            buckets[i] = temp[i];
        }
    }

    private int bucketIndexForKey(Solmu solmu) {
        throwIfKeyIsNull(solmu);
        int bucketIndex = solmu.hashCode() % buckets.length;
        return bucketIndex;
    }

    private void throwIfKeyIsNull(Solmu solmu) {
        if (solmu == null) {
            throw new IllegalArgumentException("Solmu ei saa olla null");
        }
    }
}
