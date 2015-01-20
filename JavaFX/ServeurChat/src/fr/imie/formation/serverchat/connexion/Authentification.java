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
public class Authentification implements Runnable
{

    private BufferedReader in;
    private PrintWriter out;
    private Thread thread;
    
    Socket serverSocket;

    public Authentification(Socket socket)
    {
        this.serverSocket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            // On creer un flux d'entrée ainsi qu'un flux de sortie
            in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            out = new PrintWriter(serverSocket.getOutputStream());
        
            // Boucle d'authetification du client
            /*
            Boolean isAuthenticate= false;
            while(!isAuthenticate)
            {
            
            }
            */
           
            thread = new Thread(new Communication(serverSocket, "toto"));
            thread.start();
            
        }
        catch ( IOException e )
        {

            System.err.println(/*login +*/ " ne répond pas !");
        }
    }
}
