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
public class TP11 {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] moyenne={3,4,6,2,7,2,4,1,9,5,7};
        int somme=0;
        for (int i : moyenne) {
            somme+=i;
        }
        double moyenneValue = (float)somme/((float)moyenne.length);
        System.out.println(moyenneValue);
    
   }

    
}
