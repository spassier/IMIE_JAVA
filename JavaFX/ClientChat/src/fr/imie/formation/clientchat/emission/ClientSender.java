/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.formation.clientchat.emission;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author imie
 */
public class ClientSender implements Runnable
{

    private final PrintWriter out;
    //private String login = null;
    private String message = null;
    private Scanner scanner = null;

    public ClientSender(PrintWriter out)
    {
        this.out = out;
    }

    @Override
    public void run()
    {
        scanner = new Scanner(System.in);

        while ( true )
        {
            System.out.println("Message : ");
            message = scanner.nextLine();
            out.println(message);
            out.flush();
        }
    }

}
