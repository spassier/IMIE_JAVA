/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import fr.imie.formation.addcontact.FXMLContactViewController;
import fr.imie.formation.adressboard.dao.ContactDAO;
import fr.imie.formation.adressboard.dto.ContactDTO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;


/**
 *
 * @author imie
 */
public class FXMLDocumentController implements Initializable
{
    
    @FXML
    private MenuItem close;
    @FXML
    private MenuItem list;
    @FXML
    private MenuItem help;
    @FXML
    private ListView<ContactDTO> listview;

    private ObservableList<ContactDTO> contactObs;
    @FXML
    private MenuItem newContact;
    
    private final ContactDAO contactDAO = new ContactDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        contactObs = FXCollections.observableArrayList();
        listview.setItems(contactObs);
        
      
        //this.reloadData();
      
        /*
         newContact.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader(FXMLContactViewController.class.getResource("FXMLContactView.fxml"));

                Parent root;
                try {
                    root = (Parent) loader.load();
                    Scene scene = new Scene(root, 320, 200);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.showAndWait();
                    reloadData();
                }
                catch (IOException ex)
                {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
                */
        this.reloadData();       
    }    

    
 
    @FXML
    private void handleOnActionClose(ActionEvent event)
    {
        System.exit(1);
    }

    @FXML
    private void handleOnActionHelp(ActionEvent event)
    {
        System.out.println("Sébastien PASSIER - 2014");
    }

    @FXML
    private void handleOnActionList(ActionEvent event)
    {
        this.reloadData();
    }

    @FXML
    private void handleMenuRequested(ContextMenuEvent event) {
    }
    
    private void reloadData()
    {
        contactObs.clear();
        contactObs.setAll(contactDAO.getAllContacts());
    }

    @FXML
    private void handleOnActionNew(ActionEvent event)
    {
       
        FXMLLoader loader = new FXMLLoader(FXMLContactViewController.class.getResource("FXMLContactView.fxml"));

        Parent root;
        try
        {
            root = (Parent) loader.load();
            Scene scene = new Scene(root, 320, 200);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
            reloadData();
        }
        catch (IOException ex)
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
              
}
