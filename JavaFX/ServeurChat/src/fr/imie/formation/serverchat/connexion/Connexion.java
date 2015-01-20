/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.formation.serverchat.connexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author imie
 */
public class Connexion implements Runnable
{
    private ServerSocket serverSocket;
    private Socket socket = null;
    private Thread connexionThread;

    public Connexion(ServerSocket serverSocket)
    {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run()
    {
        try
        {
            while ( true )
            {
                socket = serverSocket.accept();
                System.out.println("...a client request a connexion");

                connexionThread = new Thread(new Authentification(socket));
                connexionThread.start();
            }
        } 
        catch ( IOException e )
        {
            System.err.println("Erreur serveur");
        }

    }

}
