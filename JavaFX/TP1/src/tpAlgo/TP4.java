/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tpAlgo;

/**
 *
 * @author imie
 */
public class TP4 {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer nbPhotocop=123;
        Double somme=0d;
        somme +=((nbPhotocop<=10?nbPhotocop:10)*0.1);
        nbPhotocop -= nbPhotocop<=10?nbPhotocop:10;
        somme +=((nbPhotocop<=20?nbPhotocop:20)*0.08);
        nbPhotocop -= nbPhotocop<=20?nbPhotocop:20;
        somme +=(nbPhotocop*0.05);
        System.out.println(somme);
         
        
    }
    
}
