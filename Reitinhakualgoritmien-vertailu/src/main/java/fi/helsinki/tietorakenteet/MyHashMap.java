/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.tietorakenteet;



/**
 *
 * @author Matti
 */
public class MyHashMap<Key, Value> {

    private int BUCKET_COUNT = 10000;
    private int currentSize = 0;

    private MyEntry<Key, Value>[] buckets;
    /**
     * Oletus konstruktori MyHashMapille
     */
    public MyHashMap() {
        buckets = new MyEntry[BUCKET_COUNT];
    }
    /**
     * Konstruktori MyHashMapille, jossa voi valita ämpärien koon.
     * @param size Ämpärien koko
     */
    public MyHashMap(int size) {
        buckets = new MyEntry[size];
    }
    /**
     * Palauttaa parametrina annettua avainta vastaavan arvon MyHashMapista.
     * @param solmu Avain, jota vastaava arvo halutaan hakea
     * @return Avainta vastaava arvo
     */
    public Value get(Key solmu) {
        throwIfKeyIsNull(solmu);
        MyEntry<Key, Value> entry = buckets[bucketIndexForKey(solmu)];
        while (entry != null && !solmu.equals(entry.getKey())) {
            entry = entry.getNext();
        }
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }
    /**
     * Lisää avain-arvo parin MyHashMappiin
     * @param nimi Avain, joka halutaan lisätä
     * @param solmu Arvo, joka halutaan lisätä
     */
    public void put(Key nimi, Value solmu) {
        throwIfKeyIsNull(nimi);
        int bucketIndex = bucketIndexForKey(nimi);
        MyEntry<Key, Value> entry = buckets[bucketIndex];
        if (entry != null) {
            boolean lisatty = false;
            while (!lisatty) {
                if (nimi.equals(entry.getKey())) {
                    entry.setValue(solmu);
                    lisatty = true;
                } else if (entry.getNext() == null) {
                    entry.setNext(new MyEntry<Key, Value>(nimi, solmu));
                    currentSize++;
                    lisatty = true;
                }
                entry = entry.getNext();
            }
        } else {
            buckets[bucketIndex] = new MyEntry<Key, Value>(nimi, solmu);
        }
    }
    /**
     * Laskee avainta vastaavan ämpäri-indeksin
     * @param solmu Avain, jota vastaava indeksi halutaan hakea.
     * @return palautettava indeksi
     */
    public int bucketIndexForKey(Key solmu) {
        int bucketIndex = solmu.hashCode() % buckets.length;
        return bucketIndex;
    }

    private void throwIfKeyIsNull(Key solmu) {
        if (solmu == null) {
            throw new IllegalArgumentException("Solmu ei saa olla null");
        }
    }
    
    /**
     * Palauttaa MyHashMapin sisältämät alkiot taulukkona.
     * @return MyHashMapin sisätämät alkiot taulukkona
     */
    public MyEntry<Key, Value>[] entrySet() {
        int size = 0;
        for (int i = 0; i < buckets.length; i++) {
            MyEntry s = buckets[i];
            if (s != null) {
                size++;
                while (s.getNext() != null) {
                    s = s.getNext();
                    size++;
                }
            }
        }
        MyEntry[] pal = new MyEntry[size];
        int toIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            MyEntry s = buckets[i];
            if (s != null) {
                pal[toIndex] = s;
                toIndex++;
                while (s.getNext() != null) {
                    s = s.getNext();
                    pal[toIndex] = s;
                    toIndex++;
                }
            }
        }
        return pal;
    }
    
    /**
     * Palauttaa ämpärien lukumäärän
     * @return ämpärien lukumäärä
     */
    public int size() {
        return this.buckets.length;
    }

}
