/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.formation.clientchat.communication;

import fr.imie.formation.clientchat.emission.ClientSender;
import fr.imie.formation.clientchat.reception.ClientReceiver;
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
public class Communication implements Runnable
{

    private final Socket socket;
    private PrintWriter out = null;
    private BufferedReader in = null;
    //private Scanner scanner;
    private Thread senderThread;
    private Thread receiverThread;

    public Communication(Socket socket)
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

            //scanner = new Scanner(System.in);

            senderThread = new Thread(new ClientSender(out));
            senderThread.start();
            receiverThread = new Thread(new ClientReceiver(in));
            receiverThread.start();

        }
        catch ( IOException e )
        {
            System.err.println("[ERROR] server is disconnected");
        }
    }
}
