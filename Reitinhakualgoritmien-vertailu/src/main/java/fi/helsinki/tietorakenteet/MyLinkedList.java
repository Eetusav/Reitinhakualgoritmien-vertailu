/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.tietorakenteet;

/**
 * Oma tietorakenne linkitetylle listalle
 * @author Matti
 */
public class MyLinkedList {

    private ListanSolmu head;
    LinkedListIterator p;

    /**
     * Alustaa uuden linkitetyn listan
     */
    public MyLinkedList() {
        head = new ListanSolmu(null);
    }

    /**
     * Lisää solmun linkitetyn listan perään. Ts. rekursion avulla etsitään listan viimeinen listansolmu ja linkitetään siihen uusi listansolmu, jonka sisältönä on parametrina annettu solmu.
     * Huom! Lista koostuu listansolmuista, jotka ovat ketjutettu toisiinsa. Listansolmut sisältävät solmuja.
     * @param solmu Lisättävä solmu
     */
    public void add(Solmu solmu) {
        if (p != null && p.current != null) {
            p.current.next = new ListanSolmu(solmu, p.current.next);
        }
    }

}

class ListanSolmu {
    /**
     * Konstruktori uudelle listansolmulle, jolla ei ole seuraavaa listansolmua. Käytetään linkitetyn listan konstruktorissa.
     * @param o Lisättävä solmu
     */
    public ListanSolmu(Solmu o) {
        this(o, null);
    }
    /**
     * Konstruktori uudelle listansolmulle.
     * @param o Lisättävä solmu
     * @param n Seuraava listansolmu
     */
    public ListanSolmu(Solmu o, ListanSolmu n) {
        solmu = o;
        next = n;
    }

    public Solmu solmu;

    public ListanSolmu next;
}

class LinkedListIterator {

    ListanSolmu current;
    /**
     * Iteraattori linkitetylle listalle
     * @param theNode 
     */
    LinkedListIterator(ListanSolmu theNode) {
        current = theNode;
    }

}
