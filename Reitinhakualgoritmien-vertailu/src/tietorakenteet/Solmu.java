/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matti
 */
public class Solmu {

    private String nimi;
    //TODO: tietorakenne linkedlist
    private List<Solmu> lyhinPolku = new LinkedList<>();
    private Integer etaisyys;

    Map<Solmu, Integer> vierusSolmut = new HashMap<>();

    //Alustetaan etäisyydeksi "ääretön", niinkuin tiran muistiinpanoissa.
    public Solmu(String nimi) {
        this.nimi = nimi;
        this.etaisyys = Integer.MAX_VALUE;
    }

    public void lisaaVierussolmu(Solmu vierusSolmu, int etaisyys) {
        vierusSolmut.put(vierusSolmu, etaisyys);
    }

    public Map<Solmu, Integer> getVierusSolmut() {
        return this.vierusSolmut;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return this.nimi;
    }

    public void setLyhinPolku(List<Solmu> lyhinPolku) {
        this.lyhinPolku = lyhinPolku;
    }

    public List<Solmu> getLyhinPolku() {
        return this.lyhinPolku;
    }

    public void setEtaisyys(Integer etaisyys) {
        this.etaisyys = etaisyys;
    }

    public Integer getEtaisyys() {
        return this.etaisyys;
    }

}
