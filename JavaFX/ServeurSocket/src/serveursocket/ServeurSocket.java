/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveursocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author imie
 */
public class ServeurSocket
{
    static int port = 2009;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ServerSocket socketserver;
        Socket socketduserveur;
        PrintWriter out;

        try
        {
            socketserver = new ServerSocket(port);
            socketduserveur = socketserver.accept();
            System.out.println("Une connexion est effectuée !");
            
            out = new PrintWriter(socketduserveur.getOutputStream());
            out.println("Vous êtes connecté!");
            out.flush();
                        
            socketserver.close();
            socketduserveur.close();

        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}
