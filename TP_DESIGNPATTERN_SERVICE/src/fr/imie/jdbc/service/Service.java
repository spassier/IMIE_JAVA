package fr.imie.jdbc.service;

import java.util.List;

import fr.imie.jdbc.DAO.IPersonneDAO;
import fr.imie.jdbc.DAO.IPromotionDAO;
import fr.imie.jdbc.DAO.PersonneDAO;
import fr.imie.jdbc.DAO.PromotionDAO;
import fr.imie.jdbc.DTO.PersonneDTO;
import fr.imie.jdbc.DTO.PromotionDTO;

/*
 * Service implement le design pattern FACADE
 */
public class Service implements IService
{
	private IPersonneDAO personneDAO;
	private IPromotionDAO promotionDAO;
	
	//
	// Constructeur
	//
	public Service() {
		this.personneDAO = new PersonneDAO();
		this.promotionDAO = new PromotionDAO();
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
	public void deletePromotionDTO(PromotionDTO promotion)
	{
		promotionDAO.delete(promotion);
	}
	
	public List<PromotionDTO> findAllPromotionDTO()
	{
		return promotionDAO.findAll();
	}
}
