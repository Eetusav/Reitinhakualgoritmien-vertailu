/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reitinhakualgoritmien.vertailu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import tietorakenteet.MyEntry;
import tietorakenteet.MyHashSet;
import tietorakenteet.MyLinkedList;
import tietorakenteet.Solmu;
import tietorakenteet.Verkko;

/**
 *
 * @author Matti
 */
public class Dijkstra {
    /**
     * Dijkstran algoritmi.
     * @param verkko Verkko, josta lyhimmät polut lasketaan.
     * @param srcSolmu Solmu, josta lasketaan lyhimmät polut verkon kaikkiin solmuihin.
     * @return Palautetaan verkko, joka sisältää solmut ja niiden lyhimmät etäisyydet lähtösolmuun (srcSolmu).
     */
    public static Verkko dijkstra(Verkko verkko, Solmu srcSolmu){
        //Alustetaan lähtösolmun etäisyys nollaksi
        srcSolmu.setEtaisyys(0);
        
        MyHashSet kasittelemattomat = new MyHashSet();
        kasittelemattomat.add(srcSolmu);
        
        MyHashSet kasitellyt = new MyHashSet();
        
        while(kasittelemattomat.size() > 0){
            //hae lyhimmällä etäisyydellä oleva solmu ja poistetaan se kasittelemattomista
            Solmu kasiteltavaSolmu = getSeuraavaKasiteltavaSolmu(kasittelemattomat);
            kasittelemattomat.remove(kasiteltavaSolmu);
//            System.out.println(kasiteltavaSolmu.getVierusSolmut().size());
            for (MyEntry<Solmu,Integer> pari : kasiteltavaSolmu.getVierusSolmut().entrySet()){
                Solmu vierusSolmu = pari.getKey();
                Integer paino = pari.getValue();
                if (!kasitellyt.contains(vierusSolmu)){
                    laskeMinEtaisyys(vierusSolmu, paino, kasiteltavaSolmu);
                    kasittelemattomat.add(vierusSolmu);
                }
            }
            kasitellyt.add(kasiteltavaSolmu);
        }
        
        return verkko;
    }
    /**
     * Valitsee parametrina annettavan joukon solmuista solmun, jonka etäisyys on lyhin.
     * @param kasittelemattomat Parametrina annettava joukko solmuja, josta halutaan selvittää solmu, minkä etäisyys on lyhin.
     * @return Palauttaa lyhimmän etäisyyden omaavan solmun.
     */
    public static Solmu getSeuraavaKasiteltavaSolmu(MyHashSet kasittelemattomat){
        Solmu palautettava = null;
        int lyhinEtaisyys = Integer.MAX_VALUE;
        for (Solmu solmu : kasittelemattomat.getSolmut()){
            if (solmu.getEtaisyys() < lyhinEtaisyys){
                lyhinEtaisyys = solmu.getEtaisyys();
                palautettava = solmu;
            }
        }
        return palautettava;
    }
    /**
     * Jos käsiteltävän solmun ja sen vierussolmun painon summa on pienempi kuin käsiteltävän solmun etäisyys, niin asetetaan vierussolmulle uusi etäisyys ja lyhin polku.
     * @param vierusSolmu kasiteltävän solmun vierussolmu  
     * @param paino kasiteltävän solmun ja sen vierussolmun välinen paino
     * @param kasiteltava kasiteltävä solmu
     */
    private static void laskeMinEtaisyys(Solmu vierusSolmu, Integer paino, Solmu kasiteltava){
        Integer lahtoEtaisyys = kasiteltava.getEtaisyys();
        if (lahtoEtaisyys + paino < vierusSolmu.getEtaisyys()){
            vierusSolmu.setEtaisyys(lahtoEtaisyys + paino);
            MyLinkedList lyhinPolku = kasiteltava.getLyhinPolku();
            lyhinPolku.add(kasiteltava);
            vierusSolmu.setLyhinPolku(lyhinPolku);
        }
    }
}
