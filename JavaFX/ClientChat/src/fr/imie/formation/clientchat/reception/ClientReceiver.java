/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.formation.clientchat.reception;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author imie
 */
public class ClientReceiver implements Runnable
{

    private BufferedReader in;
    private String message = null;

    public ClientReceiver(BufferedReader in)
    {
        this.in = in;
    }

    @Override
    public void run()
    {
        while ( true )
        {
            try
            {
                message = in.readLine();
                System.out.println("...server message :" + message);

            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
        }
    }

}
