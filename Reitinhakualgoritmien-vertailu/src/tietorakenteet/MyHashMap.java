/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

//import java.util.Map;
import java.util.HashSet;

/**
 *
 * @author Matti
 */
public class MyHashMap<Key, Value> {

    private int BUCKET_COUNT = 10;
    private int currentSize = 0;

    private MyEntry<Key, Value>[] buckets;

    public MyHashMap() {
        buckets = new MyEntry[BUCKET_COUNT];
    }

    public MyHashMap(int size) {
        buckets = new MyEntry[size];
    }

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

    public void put(Key nimi, Value solmu) {
        throwIfKeyIsNull(nimi);
        int bucketIndex = bucketIndexForKey(nimi);
        MyEntry<Key, Value> entry = buckets[bucketIndex];
        if (entry != null) {
            boolean lisatty = false;
            while (!lisatty) {
                if (nimi.equals(entry.getKey())) {
                    entry.setValue(solmu);
                    currentSize++;
                    lisatty = true;
                } else if (entry.getNext() == null) {
                    entry.setNext(new MyEntry<Key, Value>(nimi, solmu));
                    currentSize++;
                    lisatty = true;
                }
                entry.getNext();
            }
        } else {
            buckets[bucketIndex] = new MyEntry<Key, Value>(nimi, solmu);
        }
    }

    public int bucketIndexForKey(Key solmu) {
        int bucketIndex = solmu.hashCode() % buckets.length;
        return bucketIndex;
    }

    private void throwIfKeyIsNull(Key solmu) {
        if (solmu == null) {
            throw new IllegalArgumentException("Solmu ei saa olla null");
        }
    }

//    public HashSet<MyEntry<Key, Value>> entrySet() {
//        HashSet<MyEntry<Key, Value>> set = new HashSet<>();
//        for (int i = 0; i < buckets.length; i++) {
//            MyEntry<Key, Value> entry = buckets[i];
//            if (entry != null) {
//                set.add(entry);
//                while (entry.getNext() != null) {
//                    entry = entry.getNext();
//                    set.add(entry);
//                }
//            }
//        }
//        return set;
//    }
    public MyEntry<Key, Value>[] entrySet() {
        MyEntry<Key, Value>[] pal;
        // TODO: sizing problem
        pal = new MyEntry[1024 + currentSize];
//        System.out.println(currentSize);
        int toIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            MyEntry s = buckets[i];
            if (s != null) {
                pal[toIndex] = s;
                toIndex++;
                while (s.getNext() != null) {
                    pal[toIndex] = s;
                    toIndex++;
                }
            }
        }
        MyEntry<Key,Value>[] pal2 = new MyEntry[toIndex];
        for (int j = 0; j < toIndex; j++) {
            pal2[j] = pal[j];
        }
        return pal2;
    }
    public int size(){
        return this.size();
    }

}
