package fr.imie.jdbc.iservice;

import java.util.List;

import fr.imie.jdbc.DTO.PersonneDTO;
import fr.imie.jdbc.DTO.PromotionDTO;


public interface IService
{

	// Personnes
	public abstract List<PersonneDTO> getAllPersonneDTO();
	public abstract void deletePersonneDTO(PersonneDTO personne);
	public abstract PersonneDTO insertPersonneDTO(PersonneDTO personne);
	public abstract PersonneDTO findPersonneDTO(PersonneDTO personne);
	public abstract PersonneDTO updatePersonneDTO(PersonneDTO personne);
	
	// Promotion
	public abstract void deletePromotionDTO(PromotionDTO promotion);
	public abstract List<PromotionDTO> findAllPromotionDTO();
}
