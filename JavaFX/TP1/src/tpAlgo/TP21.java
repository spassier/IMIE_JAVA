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
public class TP21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int i = 0; i <= 100; i++) {
            boolean test = true;
            if (i > 2) {
                for (int j = i-1; j >= 2; j--) {
                    if (i % j == 0) {
                        test = false;
                        break;
                    }
                }
            }
            if (test) {
                System.out.println(i);
            }
        }
    }
}
