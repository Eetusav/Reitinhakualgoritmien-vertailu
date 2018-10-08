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
public class Verkko {
    
    private MyHashSet solmut = new MyHashSet();
    
    public void lisaaSolmu(Solmu solmu){
        solmut.add(solmu);
    }
    public Solmu[] getSolmut(){
        return this.solmut.getSolmut();
    }
}
