/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp_properties;

import java.io.Serializable;

/**
 *
 * @author imie
 */
public class MyBean implements Serializable
{
    int i;
    int j;
    String aString;
    
    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public String getaString() {
        return aString;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

}
