/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import fr.imie.formation.serverchat.connexion.Connexion;
import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author imie
 */
public class ServerChat
{
    static int port = 2009;
    public static ServerSocket serverSocket = null;
    public static Thread thread;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            System.out.println("----------------------");
            System.out.println("...application started");
            serverSocket = new ServerSocket(port);
            System.out.println("...server is listening to port " + serverSocket.getLocalPort());

            thread = new Thread(new Connexion(serverSocket));
            thread.start();

        }
        catch ( IOException e )
        {
            System.err.println("[WARNING] port " + serverSocket.getLocalPort() + " is already used");
        }
    }

}
