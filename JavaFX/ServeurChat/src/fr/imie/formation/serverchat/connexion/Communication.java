/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.formation.serverchat.connexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author imie
 */
public class Communication implements Runnable
{
    BufferedReader in;
    PrintWriter out;
    String login;
    Socket socket;

    public Communication(Socket socket, String login)
    {
        this.socket = socket;
        this.login = login;
    }

    @Override
    public void run()
    {
        try
        {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            Thread threadReceiver = new Thread(new Receiver(in, login));
            threadReceiver.start();
            Thread threadSender = new Thread(new Sender(out));
            threadSender.start();

        }
        catch ( IOException e )
        {
            System.err.println(login + "s'est déconnecté ");
        }
    }

}
