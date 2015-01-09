package fr.imie.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.imie.jdbc.DTO.PersonneDTO;
import fr.imie.jdbc.DTO.PromotionDTO;
import fr.imie.jdbc.ipersistence.IPersonneDAO;
import fr.imie.jdbc.ipersistence.IPromotionDAO;
import fr.imie.jdbc.iservice.IService;
import fr.imie.jdbc.itransverse.IFactory;
import fr.imie.jdbc.service.*;

/*
 *  
 */

/*
 * Service implement le design pattern FACADE
 */
public class Service implements IService
{
	private static Service instance = null;
	private IPersonneDAO personneDAO;
	private IPromotionDAO promotionDAO;
	
	/*
	 * Constructeur : private car on implemente un pattern singleton
	 */
	private Service()
	{
		
	}
	
	private Service(IFactory factory)
	{
		super();
		this.personneDAO = factory.createPersonneDAO();//PersonneDAO.getInstance();
		this.promotionDAO = factory.createPromotionDAO();//PromotionDAO.getInstance();
	}
		
	/*
	 * Singleton
	 */
	public static synchronized Service getInstance()
	{
		if ( instance == null )
		{
			instance = new Service();
		}
		return instance;
	}
	
	public static synchronized Service getInstance(IFactory factory)
	{
		if ( instance == null )
		{
			instance = new Service(factory);
		}
		return instance;
	}
	
	//
	// Personne
	//
	public List<PersonneDTO> getAllPersonneDTO()
	{
		return personneDAO.findAll();
	}
	
	public void deletePersonneDTO(PersonneDTO personne)
	{
		personneDAO.delete(personne);
	}
	
	public PersonneDTO insertPersonneDTO(PersonneDTO personne)
	{
		return personneDAO.insert(personne);
	}
	
	public PersonneDTO findPersonneDTO(PersonneDTO personne)
	{
		return personneDAO.findById(personne);
	}
	
	public PersonneDTO updatePersonneDTO(PersonneDTO personne)
	{
		return personneDAO.update(personne);
	}
	
	//
	// Promotion
	//
	
	@Override
	public void deletePromotionDTO(PromotionDTO selectedPromotion)
	{

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		PersonneDTO retour = null;
		
		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/imie", "postgres",
					"postgres");
			connection.setAutoCommit(false);

//			IPersonneDAO personneDAO = new PersonneDAO();
			PersonneDTO findParameter = new PersonneDTO();
			findParameter.setPromotionDTO(selectedPromotion);
			List<PersonneDTO> findedPersonne = personneDAO.findByDTO(
					findParameter, connection);

			for (PersonneDTO personneDTO : findedPersonne) {
				personneDTO.setPromotionDTO(null);
				personneDAO.update(personneDTO, connection);
			}
			
			promotionDAO.delete(selectedPromotion,connection);
			
			connection.commit();

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException("erreur applicative", e1);
			}
			throw new RuntimeException("erreur applicative", e);
		} finally {
			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("erreur applicative", e);
			}
		}
	}
	
	public List<PromotionDTO> findAllPromotionDTO()
	{
		return promotionDAO.findAll();
	}
}
