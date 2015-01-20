/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressboard;


import java.awt.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author imie
 */
public class AdressBoard extends Application {
    
    @Override
    public void start(Stage primaryStage)
    {
        Group group = new Group();
        Scene scene = new Scene(group, 400, 400, Color.GOLDENROD);
        
        // creation du background
        Image background = new Image("/adressboard/board.jpg");
        ImageView imgView = new ImageView(background);
        imgView.fitWidthProperty().bind(scene.widthProperty());
        imgView.fitHeightProperty().bind(scene.widthProperty());

        Group viewGroup = new Group(); 
        viewGroup.setAutoSizeChildren(true);
        viewGroup.setStyle("-fx-background-color: goldenrod;");
        viewGroup.getChildren().add(imgView);
        
        group.getChildren().add(viewGroup);
        
        // creation de la sous fenetre share
        GridPane shareGrid = new GridPane();
        shareGrid.setVisible(false);
        group.getChildren().add(shareGrid);
        
        // Creation du menu
        MenuBar menu = new MenuBar();
        
        Menu management = new Menu("Gestion contact");
        Menu display = new Menu("Affichage");
        MenuItem list = new MenuItem("Liste");
        MenuItem tile = new MenuItem("Tuile");
        display.getItems().add(list);
        display.getItems().add(tile);
        MenuItem close = new MenuItem("Fermer");
        close.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
              closeOnAction();
            }
        });
        management.getItems().add(display);
        management.getItems().add(close);
        
        Menu share = new Menu("Partager");
        share.getItems().add(new MenuItem("par IP"));
        share.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event) {
                shareOnAction(shareGrid);
            }
        });
        menu.getMenus().add(management);
        menu.getMenus().add(share);
        
        group.getChildren().add(menu);
        
      
        primaryStage.setTitle("AdressBoard");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
  
    private void closeOnAction()
    {
        System.exit(1);
    }
    
    private void shareOnAction(GridPane container)
    {
        container.setVisible(true);
        
    }
}
