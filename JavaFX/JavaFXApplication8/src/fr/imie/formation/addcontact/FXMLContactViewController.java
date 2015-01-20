/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.formation.addcontact;

import fr.imie.formation.adressboard.dao.ContactDAO;
import fr.imie.formation.adressboard.dao.IContactDAO;
import fr.imie.formation.adressboard.dto.ContactDTO;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author imie
 */
public class FXMLContactViewController implements Initializable
{
    @FXML
    private TextField surnameField;
    @FXML
    private DatePicker birthdayDate;
    @FXML
    private TextField nameField;
    @FXML
    private Button saveBtn;
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void handleOnActionSaveBtn(ActionEvent event)
    {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setFirstname(nameField.getText());
        contactDTO.setLastname(surnameField.getText());
        Date date = Date.from(birthdayDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        contactDTO.setBirthday(date);
        IContactDAO contactDAO = new ContactDAO();
        contactDAO.createContact(contactDTO);
        
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
