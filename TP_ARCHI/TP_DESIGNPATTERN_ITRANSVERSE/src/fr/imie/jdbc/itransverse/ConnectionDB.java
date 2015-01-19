package fr.imie.jdbc.itransverse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import fr.imie.jdbc.itransverse.IConnectionDB;


public abstract class ConnectionDB //implements IConnectionDB
{
	//private static ConnectionDB instance = null;
	
	/*
	 * Singleton
	 */
	/*
	public static synchronized ConnectionDB getInstance()
	{
		if ( instance == null )
		{
			instance = new ConnectionDB();
		}
		return instance;
	}*/

	//@Override
	public Connection provideConnection() throws SQLException
	{
		Connection connection = null;

			synchronized(DriverManager.class) // Thread-safe
			{
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/imie", "postgres", "postgres");
			}
		
		return connection;
	}
	
	//@Override
	public void closeConnection(Connection connection)
	{
		try
		{
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException("erreure applicative", e);
		}
	}
}
