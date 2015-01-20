/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.formation.adressboard.dao;

import fr.imie.formation.adressboard.dto.ContactDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author imie
 */
public class ContactDAO implements IContactDAO
{
    private static final List<ContactDTO> contactListDTO = new ArrayList<ContactDTO>();
    
    static 
    {
        try {
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-mm-dd");
            
            ContactDTO contact = new ContactDTO();
            contact.setFirstname("Toto");
            contact.setLastname("GRANGOSIER");
            contact.setBirthday(dateFormat.parse("2000-01-01"));
            contactListDTO.add(contact);
            
            
            contact = new ContactDTO();
            contact.setFirstname("Titi");
            contact.setLastname("POPO");
            contact.setBirthday(dateFormat.parse("2001-10-11"));
            contactListDTO.add(contact);
            
            contact = new ContactDTO();
            contact.setFirstname("John");
            contact.setLastname("DOE");
            contact.setBirthday(dateFormat.parse("1966-04-24"));
            contactListDTO.add(contact);
            
            contact = new ContactDTO();
            contact.setFirstname("Robert");
            contact.setLastname("POLSON");
            contact.setBirthday(dateFormat.parse("2079-08-15"));
            contactListDTO.add(contact);
            
            contact = new ContactDTO();
            contact.setFirstname("Petit Ours");
            contact.setLastname("BRUN");
            contact.setBirthday(dateFormat.parse("1851-05-21"));
            contactListDTO.add(contact);
            
            contact = new ContactDTO();
            contact.setFirstname("Dora");
            contact.setLastname("L'EXPLORATRICE");
            contact.setBirthday(dateFormat.parse("1981-02-17"));
            contactListDTO.add(contact);
        } catch (ParseException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void createContact(ContactDTO contact) {
        contactListDTO.add(contact);
    }

    @Override
    public void deleteContact(ContactDTO contact) {
        contactListDTO.remove(contact);
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        return contactListDTO;
    }

}
