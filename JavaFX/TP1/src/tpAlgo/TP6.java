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
public class TP6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(factoriel(5).toString());

    }

    public static Integer factoriel(Integer value) {
        Integer retour;
        if (value == 0) {
            retour = 1;
        } else {
            retour = value * factoriel(value - 1);
        }
        return retour;
    }
;

}
