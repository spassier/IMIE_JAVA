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
public class TP25 {

    public enum direction {

        Nord, NordEst, Est, SudEst, Sud, SudOuest, Ouest, NordOuest
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[][] grille = new Integer[8][8];
        for (int nbElmt = 0; nbElmt < 8; nbElmt++) {
            boolean insertOk = false;
            do {
                double x = Math.floor((Math.random()) * 8);
                double y = Math.floor((Math.random()) * 8);
                if (grille[(int) x][(int) y] == null) {
                    grille[(int) x][(int) y] = Integer.valueOf(1);
                    insertOk = true;
                }
            } while (insertOk == false);
        }

        int posXTest = 4;
        int posYTest = 2;
        grille[posXTest][posYTest] = Integer.valueOf(2);
        for (int yDislplay = 0; yDislplay < 8; yDislplay++) {
            if (yDislplay == 0) {
                System.out.println("|---------------|");
            }
            for (int xDislplay = 0; xDislplay < 8; xDislplay++) {
                System.out.print("|");
                Integer value = grille[xDislplay][yDislplay];
                System.out.print(value == null ? " " : value);

                if (xDislplay == 7) {
                    System.out.println("|");
                }
            }
            if (yDislplay == 7) {
                System.out.println("|---------------|");
            }
        }

        int nbDeplacement = 0;
        int xSearch;
        int ySearch;
        for (direction d : direction.values()) {

            xSearch = posXTest;
            ySearch = posYTest;
            //boolean stop=false;

            while(true) {
                switch (d) {
                    case Nord:
                        ySearch--;
                        break;
                    case NordEst:
                        xSearch++;
                        ySearch--;
                        break;
                    case Est:
                        xSearch++;
                        break;
                    case SudEst:
                        xSearch++;
                        ySearch++;
                        break;
                    case Sud:
                        ySearch++;
                        break;
                    case SudOuest:
                        xSearch--;
                        ySearch++;
                        break;
                    case Ouest:
                        xSearch--;
                        break;
                    case NordOuest:
                        xSearch--;
                        ySearch--;
                        break;

                }
                if(xSearch >=8 || xSearch < 0 || ySearch >= 8 || ySearch < 0){
                    break;
                }
                
                Integer value = grille[xSearch][ySearch];
                if (value != null) {
                    break;
                } else {
                    nbDeplacement++;
                }

            }
            
            System.out.println("direction :".concat(d.toString()).concat(":").concat(String.valueOf(nbDeplacement)));

        }

        System.out.println(nbDeplacement);

    }
}
