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
public class TP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        short age = 9;
        String categorie=null;
        if (age>=7 && age < 8){
            categorie="poussin";
        }  else if (age>=8 && age < 10){
            categorie="pupille";
        } else if (age>=10 && age < 12){
            categorie="minime";
        } else if (age>=12 && age < 14){
            categorie="cadet";
        }
        System.out.println(categorie);
    }
    
}
