/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reitinhakualgoritmien.vertailu;

import java.util.HashSet;
import java.util.Set;
import tietorakenteet.Solmu;
import tietorakenteet.Verkko;

/**
 *
 * @author Matti
 */
public class Dijkstra {
    
    public static Verkko DijkstranAlgoritmi(Verkko verkko, Solmu srcSolmu){
        //Alustetaan lähtösolmun etäisyys nollaksi
        srcSolmu.setEtaisyys(0);
        
        Set<Solmu> kasittelemattomat = new HashSet<>();
        kasittelemattomat.add(srcSolmu);
        
        Set<Solmu> kasitellyt = new HashSet<>();
        
        while(kasittelemattomat.size() > 0){
            //hae lyhimmällä etäisyydellä oleva solmu
        }
        
        return verkko;
    }
    
    public static Solmu getSeuraavaKasiteltavaSolmu(Set<Solmu> kasittelemattomat){
        Solmu palautettava = null;
        int lyhinEtaisyys = Integer.MAX_VALUE;
        for (Solmu solmu : kasittelemattomat){
            if (solmu.getEtaisyys() < lyhinEtaisyys){
                lyhinEtaisyys = solmu.getEtaisyys();
                palautettava = solmu;
            }
        }
        return palautettava;
    }
}
