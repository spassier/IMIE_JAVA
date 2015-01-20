/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchat;

import fr.imie.formation.clientchat.connection.ClientConnexion;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author imie
 */
public class ClientChat
{
    public static String address = "127.0.0.1";
    public static int port = 2009;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Socket socket;
        Thread clientThread;

        try
        {
            System.out.println("----------------------");
            System.out.println("...client started");
            System.out.println("...request server to connect");
            socket = new Socket(address, port);
            System.out.println("...connexion done, authentification :"); // Si le message s'affiche c'est que je suis connecté

            clientThread = new Thread(new ClientConnexion(socket));
            clientThread.start();

        } catch ( UnknownHostException e )
        {
            System.err.println("[ERROR] can not connect to IP " + address);
        } catch ( IOException e )
        {
            System.err.println("[ERROR] no server listen to port " + port);
        } finally
        {
            System.out.println("...client closed");
            System.out.println("----------------------");
        }
    }
}
