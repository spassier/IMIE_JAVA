/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.formation.serverchat.connexion;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author imie
 */
public class Sender implements Runnable
{
    private Scanner scanner = null;
    private PrintWriter out;
    private String message = null;
    
    public Sender(PrintWriter out)
    {
        this.out = out;
    }

    @Override
    public void run()
    {
        scanner = new Scanner(System.in);

        while ( true )
        {
            System.out.println("...server message :");
            message = scanner.nextLine();
            out.println(message);
            out.flush();
        }
    }

}
