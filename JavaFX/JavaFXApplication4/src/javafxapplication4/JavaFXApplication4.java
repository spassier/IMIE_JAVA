/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication4;

import java.awt.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author imie
 */
public class JavaFXApplication4 extends Application {
    private Button nex;
    
    @Override
    public void start(Stage primaryStage)
    {
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new javafx.geometry.Insets(7));
        Label name = new Label("Nom");
        GridPane.setHalignment(name, HPos.LEFT);
        gridPane.add(name, 0, 0);
        Label surname = new Label("Prénom");
        GridPane.setHalignment(surname, HPos.LEFT);
        gridPane.add(surname, 0, 1);
        Label birthday = new Label("Date de naissance");
        GridPane.setHalignment(birthday, HPos.LEFT);
        gridPane.add(birthday, 0, 2);

        
        TextField nameText = new TextField();
        gridPane.add(nameText, 1, 0);
        
        TextField surnameText = new TextField();
        gridPane.add(surnameText, 1, 1);
        
        DatePicker datePicker = new DatePicker(); 
        gridPane.add(datePicker, 1, 2); 
        
        Button validate = new Button("valider");
        validate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println(name.getText());
                System.out.println(surname.getText());
                System.out.println(datePicker.getValue());
            }
        });
        gridPane.add(validate, 2, 3);
        
        
        Scene scene = new Scene(gridPane, 450, 150);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
