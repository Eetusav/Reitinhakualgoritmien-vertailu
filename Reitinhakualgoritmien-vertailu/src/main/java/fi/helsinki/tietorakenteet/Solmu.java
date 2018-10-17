/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.tietorakenteet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solmu on olio, jolla on nimi ja etäisyys. Solmu voi kaarien avulla olla
 * linkitettynä muihin solmuihin. Linkitettyjä solmuja kutsutaan
 * vierussolmuiksi.
 *
 * @author Matti
 */
public class Solmu {

    private String nimi;
    //TODO: tietorakenne linkedlist
    private MyLinkedList lyhinPolku = new MyLinkedList();
    private Integer etaisyys;
    private Solmu next;

    MyHashMap<Solmu, Integer> vierusSolmut= new MyHashMap<>();;

    /**
     * Alustetaan etäisyydeksi "ääretön", niinkuin tiran muistiinpanoissa.
     *
     * @param nimi Solmun nimi.
     */
    public Solmu(String nimi) {
        this.nimi = nimi;
        this.etaisyys = Integer.MAX_VALUE;
        this.next = null;
        
    }

    /**
     * Lisää solmulle vierussolmun.
     *
     * @param vierusSolmu vierussolmu
     * @param etaisyys etäisyys solmusta vierussolmuun.
     */
    public void lisaaVierussolmu(Solmu vierusSolmu, int etaisyys) {
        vierusSolmut.put(vierusSolmu, etaisyys);
    }

    public MyHashMap<Solmu, Integer> getVierusSolmut() {
        return this.vierusSolmut;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return this.nimi;
    }

    /**
     * Asettaa solmulle uuden lyhimmän polun.
     *
     * @param lyhinPolku
     */
    public void setLyhinPolku(MyLinkedList lyhinPolku) {
        this.lyhinPolku = lyhinPolku;
    }
    /**
     * Palauttaa lyhimmän polun
     * @return Palautettava lyhin polku
     */
    public MyLinkedList getLyhinPolku() {
        return this.lyhinPolku;
    }

    public void setEtaisyys(Integer etaisyys) {
        this.etaisyys = etaisyys;
    }

    public Integer getEtaisyys() {
        return this.etaisyys;
    }
    public Solmu getNext(){
        return this.next;
    }
    public void setNext(Solmu next){
        this.next = next;
    }

    @Override
    public int hashCode() {
        return getNimi().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Solmu
                && getNimi().equals(((Solmu) obj).getNimi());
    }

}
