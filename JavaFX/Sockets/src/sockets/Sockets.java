/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author imie
 */
public class Sockets
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        InetAddress LocaleAdresse;
        InetAddress ServeurAdresse;

        try
        {
            LocaleAdresse = InetAddress.getLocalHost();
            System.out.println("L'adresse locale est : " + LocaleAdresse);

            ServeurAdresse = InetAddress.getByName("www.imie.fr");
            System.out.println("L'adresse de l'IMIE est : " + ServeurAdresse);

        }
        catch ( UnknownHostException e )
        {
            System.out.println("UnknowHostException");
        }
    }
}
