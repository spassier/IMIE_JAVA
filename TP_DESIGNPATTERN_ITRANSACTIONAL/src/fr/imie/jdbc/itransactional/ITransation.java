/**
 * 
 */
package fr.imie.jdbc.itransactional;

import java.sql.Connection;

/**
 * @author imie
 *
 */
public interface ITransation {
	public abstract void setConnection(Connection connection);
	public abstract Connection getConnection();
	
}
