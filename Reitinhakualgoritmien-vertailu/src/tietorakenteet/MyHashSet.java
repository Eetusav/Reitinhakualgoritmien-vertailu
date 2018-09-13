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

    public MyHashSet() {
        buckets = new Solmu[128];
        currentSize = 0;
    }

    public MyHashSet(int bucketsSize) {
        buckets = new Solmu[bucketsSize];
        currentSize = 0;
    }

    public boolean add(Solmu solmu) {
        int bucketIndex = bucketIndexForKey(solmu);
        Solmu s = buckets[bucketIndex];
        if (s != null) {
            boolean lisatty = false;
            while (!lisatty) {
                if (s.equals(solmu)) {
                    s = solmu;
                    lisatty = true;
                } else if (s.getNext() == null) {
                    s.setNext(solmu);
                    lisatty = true;
                    currentSize++;
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

    public int size() {
        return currentSize;
    }

    // TODO
    public boolean contains(Solmu solmu) {
        int bucketIndex = bucketIndexForKey(solmu);
        Solmu s = buckets[bucketIndex];
        if (s != null) {
            boolean sisaltyyko = false;
            while (!sisaltyyko) {
                if (s.equals(solmu)) {
                    return true;
                }
                s.getNext();
            }
        }
        return false;
    }

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

    public Solmu[] getSolmut() {
        Solmu[] pal = new Solmu[currentSize];
        int toIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            Solmu s = buckets[i];
            if (s != null) {
                pal[toIndex] = s;
                toIndex++;
                while (s.getNext() != null) {
                    pal[toIndex] = s;
                    toIndex++;
                }
            }
        }
//        Solmu[] pal2 = new Solmu[toIndex];
//        for (int j = 0 ; j < toIndex ; j++){
//            pal2[j] = pal[j];
//        }
        return pal;
    }

    public void kasvata() {
        Solmu[] temp = buckets;
        buckets = new Solmu[buckets.length * 2];
        for (int i = 0; i < temp.length; i++) {
            buckets[i] = temp[i];
        }
    }

    public int bucketIndexForKey(Solmu solmu) {
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
