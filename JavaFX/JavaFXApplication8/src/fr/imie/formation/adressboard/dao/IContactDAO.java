/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.formation.adressboard.dao;

import fr.imie.formation.adressboard.dto.ContactDTO;
import java.util.List;

/**
 *
 * @author imie
 */
public interface IContactDAO {
    public abstract void createContact(ContactDTO contact);
    public abstract void deleteContact(ContactDTO contact);
    public abstract List<ContactDTO> getAllContacts();
}
