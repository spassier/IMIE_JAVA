package fr.imie.jdbc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.jdbc.DTO.PersonneDTO;
import fr.imie.jdbc.DTO.PromotionDTO;
import fr.imie.jdbc.ipersistence.IPromotionDAO;

public class PromotionDAO implements IPromotionDAO {

	
	private static PromotionDAO instance = null;
	
	/**
	 * Constructeur private car utilise un pattern singleton
	 */
	private PromotionDAO() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Singleton
	 */
	public static synchronized PromotionDAO getInstance()
	{
		if ( instance == null )
		{
			instance = new PromotionDAO();
		}
		return instance;
	}

	@Override
	public List<PromotionDTO> findAll() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<PromotionDTO> retour = new ArrayList<PromotionDTO>();
		try {

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/imie", "postgres","postgres");

			statement = connection.createStatement();
			resultSet = statement.executeQuery("select id, libelle from promotion");

			while (resultSet.next())
			{
				retour.add(buildDTO(resultSet));
			}
		} catch (SQLException e) {
			throw new RuntimeException("erreure applicative", e);
		} finally {
			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}

			} catch (SQLException e) {
				throw new RuntimeException("erreure applicative", e);
			}
		}

		return retour;
	}

	
	private PromotionDTO buildDTO(ResultSet resultSet) throws SQLException {
		PromotionDTO promotionDTO = new PromotionDTO();
		promotionDTO.setId(resultSet.getInt("id"));
		promotionDTO.setLibelle(resultSet.getString("libelle"));
		return promotionDTO;
	}

	@Override
	public PromotionDTO findById(PromotionDTO dto) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		PromotionDTO retour=null;
		
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/imie", "postgres","postgres");

			preparedStatement = connection.prepareStatement("select id, libelle from promotion where id=?");
			preparedStatement.setInt(1, dto.getId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				retour = new PromotionDTO();
				retour.setId(resultSet.getInt("id"));
				retour.setLibelle(resultSet.getString("libelle"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("erreure applicative", e);
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
				throw new RuntimeException("erreure applicative", e);
			}
		}

		return retour;

	}
	
	@Override
	public void delete(PromotionDTO dto) {
		delete(dto,null);
		
	}
	
	public void delete(PromotionDTO dto, Connection connectionCaller) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		PersonneDTO retour = null;
		
		try {
			if ( connectionCaller != null )
			{
				connection = connectionCaller;
			}
			else
			{
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/imie", "postgres", "postgres");
			}

			preparedStatement = connection.prepareStatement("delete from promotion where id =?");
			preparedStatement.setInt(1, dto.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("erreur applicative", e);
		} finally {
			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
				if (connectionCaller == null && connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("erreur applicative", e);
			}
		}
		
	}

}
