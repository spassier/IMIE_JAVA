/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.formation.adressboard.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author imie
 */
public class ContactDTO
{
    private String firstname;
    private String lastname;
    private Date birthday;

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        return firstname + "\n" + lastname + "\n" + dateFormat.format(birthday);
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    

}
