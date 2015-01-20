/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveursocketthreaded;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author imie
 */
public class ServeurSocketThreaded
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ServerSocket socket;

        try
        {
            socket = new ServerSocket(2009);
            Thread t = new Thread(new accepterClients(socket));
            t.start();
            System.out.println("Mes employeurs sont prêts !");

        } catch ( IOException e )
        {

            e.printStackTrace();
        }
    }

    static class accepterClients implements Runnable
    {
        private ServerSocket socketserver;
        private Socket socket;
        private int nbrclient = 1;

        public accepterClients(ServerSocket s)
        {
            socketserver = s;
        }

        public void run()
        {

            try
            {
                while ( true )
                {
                    socket = socketserver.accept(); // Un client se connecte on l'accepte
                    System.out.println("Le client numéro " + nbrclient + " est connecté !");
                    nbrclient++;
                    socket.close();
                }

            } catch ( IOException e )
            {
                e.printStackTrace();
            }
        }

    }
}
