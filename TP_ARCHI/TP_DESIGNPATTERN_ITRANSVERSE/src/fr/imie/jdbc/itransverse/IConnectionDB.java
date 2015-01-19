package fr.imie.jdbc.itransverse;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionDB
{
	public abstract Connection provideConnection() throws SQLException;
	public abstract void closeConnection(Connection connection);
}
