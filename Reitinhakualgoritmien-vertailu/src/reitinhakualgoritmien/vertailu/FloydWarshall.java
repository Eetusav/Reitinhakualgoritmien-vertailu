/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reitinhakualgoritmien.vertailu;

/**
 *
 * @author Matti
 */
public class FloydWarshall {
    
    public static void floydWarshall(int verkko[][]){
        int etaisyys[][] = new int[verkko.length][verkko.length];
        
        for (int i = 0 ; i < verkko.length ; i++){
            for (int j = 0 ; j < verkko.length ; j++){
                if (i==j){
                    etaisyys[i][j] = 0;
                } 
                else {
                    etaisyys[i][j] = verkko[i][j];
                }
            }
        }
        
        for (int k = 0 ; k < verkko.length ; k++){
            for (int i = 0 ; i < verkko.length ; i++){
                for (int j = 0 ; j < verkko.length ; j++){
                    if (etaisyys[i][k] + etaisyys[k][j] < etaisyys[i][j]){
                        etaisyys[i][j] = etaisyys[i][k] + etaisyys[k][j];
                    }
                }
            }
        }
        
    }
}
