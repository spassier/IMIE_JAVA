/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.image.;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author imie
 */
public class JavaFXApplication5 extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        // Border decorate the picture 
        final ImageView imv = new ImageView(); 
        final Image image2 = Image(GeneratingBorders.class.getResourceAsStream("smoke_glass_buttons1.png")); 
        imv.setImage(image2);
        
        Group group = new Group();
        group.getChildren().add(imv);
        
        Scene scene = new Scene(group, 300, 300);
        
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
