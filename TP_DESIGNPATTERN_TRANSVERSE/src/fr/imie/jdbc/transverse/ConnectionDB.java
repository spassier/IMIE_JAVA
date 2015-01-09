package fr.imie.jdbc.transverse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.imie.jdbc.itransverse.IConnectionDB;


public class ConnectionDB implements IConnectionDB
{
	private static ConnectionDB instance = null;
	
	/*
	 * Constructeur private car utilise un pattern singleton
	 */
	private ConnectionDB ()
	{
		
	}
	
	/*
	 * Singleton
	 */
	public static synchronized ConnectionDB getInstance()
	{
		if ( instance == null )
		{
			instance = new ConnectionDB();
		}
		return instance;
	}

	@Override
	public Connection provideConnection()
	{
		Connection connection = null;
		
		try {
			synchronized(DriverManager.class) // Thread-safe
			{
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/imie", "postgres", "postgres");
			}
		} catch (SQLException e) {
			throw new RuntimeException("erreure applicative", e);
		}
		
		return connection;
	}
}
