/**
 * 
 */
package fr.imie.jdbc.DAO;

import java.sql.Connection;
import java.util.List;

import fr.imie.jdbc.DTO.PersonneDTO;
import fr.imie.jdbc.ipersistence.IPersonneDAO;
import fr.imie.jdbc.itransactional.ITransation;

/**
 * @author imie
 *
 */
public class ProxyPersonneDAO implements ITransation, IPersonneDAO {

	/*
	 * Ici le proxy est en charge de la gestion de la connection
	 * 
	 * */
	
	private IPersonneDAO realPersonneDAO = null;

	public ProxyPersonneDAO(IPersonneDAO realPersonneDAO)
	{
		super();
		this.realPersonneDAO = realPersonneDAO;
	}
	
	@Override
	public void setConnection(Connection connection) {
		throw new UnsupportedOperationException("Pas sur le proxy");
	}

	@Override
	public Connection getConnection() {
		throw new UnsupportedOperationException("Pas sur le proxy");
	}
	
	@Override
	public List<PersonneDTO> findAll() {
		
		return realPersonneDAO.findAll();
	}

	@Override
	public PersonneDTO findById(PersonneDTO dto) {
		return realPersonneDAO.findById(dto);
	}

	@Override
	public PersonneDTO insert(PersonneDTO dto) {
		return realPersonneDAO.insert(dto);
	}

	@Override
	public PersonneDTO update(PersonneDTO dto) {
		return realPersonneDAO.update(dto);
	}

	@Override
	public void delete(PersonneDTO dto) {
		realPersonneDAO.delete(dto);
	}

	@Override
	public PersonneDTO update(PersonneDTO dto, Connection connectionCaller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonneDTO> findByDTO(PersonneDTO findParameter) {
		return realPersonneDAO.findByDTO(findParameter);
	}

	@Override
	public List<PersonneDTO> findByDTO(PersonneDTO findParameter, Connection connectionCaller) {
		// TODO Auto-generated method stub
		return null;
	}
}
