/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp_properties;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author imie
 */
public class TP_PROPERTIES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        IntegerProperty param1 = new SimpleIntegerProperty();
        IntegerProperty param2 = new SimpleIntegerProperty();
        IntegerProperty result = new SimpleIntegerProperty();

        // Ici un listener sous forme de Lambas
        param1.addListener((valueInt, oldInt, newInt) -> {
            System.out.println("P1 changed " + valueInt + " " + oldInt + " " + newInt);
        } );
        
        // Ici un listener classique sous forme de classe anonyme
        param2.addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                System.out.println("P3 changed " + ov + " " + t + " " + t1);
            }
        });
        
        // On ajoute des listener pour afficher les modifications apportées sur la variable
        result.addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                System.out.println("P2 changed " + ov + " " + t + " " + t1);
            }
        });
        

        
        param1.set(10);
        param2.set(2);


        result.bind(param1.multiply(10).add(param2));
        // Chaque fois qu'e la valeur d'un des parametres est modifié alors la variable result est recalculer selon le bind qui est definie
        param2.set(500);
        param1.set(3);
    }
    
}
