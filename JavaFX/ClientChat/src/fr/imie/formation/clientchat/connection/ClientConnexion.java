/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.formation.clientchat.connection;

import fr.imie.formation.clientchat.communication.Communication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author imie
 */
public class ClientConnexion implements Runnable
{

    PrintWriter out;
    BufferedReader in;
    Socket socket = null;
    Scanner scanner;
    Thread clientThread;

    public ClientConnexion(Socket socket)
    {

        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            scanner = new Scanner(System.in);
            clientThread = new Thread(new Communication(socket));
            clientThread.start();
        }
        catch ( IOException e )
        {
            System.err.println("[ERROR] server does not respond anymore");
        }
    }
}
