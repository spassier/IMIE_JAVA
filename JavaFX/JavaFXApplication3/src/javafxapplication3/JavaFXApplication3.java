/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author imie
 */
public class JavaFXApplication3 extends Application {
    
    @Override
    public void start(Stage primaryStage)
    {
        BorderPane border = new BorderPane();
        border.setTop(new Button("TOP"));
        border.setBottom(new Button("BOTTOM"));
        border.setCenter(new Button("CENTER"));
        border.setLeft(new Button("LEFT"));
        border.setRight(new Button("RIGHT"));
         
        Scene scene = new Scene(border, 300, 250);
        
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
