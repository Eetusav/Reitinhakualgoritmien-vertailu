/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Matti
 */
public class Verkko {
    
    private Set<Solmu> solmut = new HashSet();
    
    public void lisaaSolmu(Solmu solmu){
        solmut.add(solmu);
    }
    public Set<Solmu> getSolmut(){
        return this.solmut;
    }
}
