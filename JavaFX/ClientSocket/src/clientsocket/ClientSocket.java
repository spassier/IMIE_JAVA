/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author imie
 */
public class ClientSocket
{
    static String addr = "127.0.0.1";
    static int port = 2009;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        try
        {
            //byte[] addr = {127, 0, 0, 1};
            //socket = new Socket(InetAddress.getLocalHost(), port);
            //socket = new Socket(InetAddress.getByAddress(addr), port);
            socket = new Socket(addr, port);

            System.out.println("Demande de connexion");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = in.readLine();
            System.out.println(message);

            socket.close();

        }
        catch ( UnknownHostException e )
        {
            e.printStackTrace();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}
