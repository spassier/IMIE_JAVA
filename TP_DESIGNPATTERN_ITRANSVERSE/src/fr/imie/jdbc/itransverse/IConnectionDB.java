package fr.imie.jdbc.itransverse;

import java.sql.Connection;

public interface IConnectionDB
{
	public abstract Connection provideConnection();
	public abstract void closeConnection(Connection connection);
}
