/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication1;

import java.awt.event.MouseEvent;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author imie
 */
public class JavaFXApplication1 extends Application {
    
    private Circle circle;
    
    @Override
    public void start(Stage primaryStage)
    {       
        Group group = new Group();
        
        Scene scene = new Scene(group, 500, 500, Color.FIREBRICK);
        
        this.showTextInColumn(group);
        this.createCircle(group, 50);

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
    
    private void changeTextColor(Text text)
    {
        Random rnd = new Random(System.currentTimeMillis());
        int r = rnd.nextInt(255);
        int g = rnd.nextInt(255);
        int b = rnd.nextInt(255);
        text.setFill(Color.rgb(r, g, b));
    }
    
    private void showTextInColumn(Group group)
    {
         for (int i = 0; i < 100; i++)
        {
            Text text = new Text("Hello World");
            text.setX(0);
            text.setY(0 + i * text.getBoundsInLocal().getHeight());
            this.changeTextColor(text);
            group.getChildren().add(text);
        }
    }
    
    private void createCircle(Group group, double radius)
    {
        circle = new Circle(radius);
        circle.setCenterX(250);
        circle.setCenterY(250);
        circle.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

            @Override
            public void handle(javafx.scene.input.MouseEvent t)
            {
                double x = t.getX();
                double y = t.getY();
                
                //if ( (y > radius) && (y < (500 - radius)) )
                    circle.setCenterY(t.getY());
                //if ( (x > radius) && (x  < (500 - radius)) )
                    circle.setCenterX(t.getX());
            }
        }); 

        group.getChildren().add(circle);
    }
}
