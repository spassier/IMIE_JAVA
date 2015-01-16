package fr.imie.jdbc.ipersistence;

import java.sql.Connection;
import java.util.List;

import fr.imie.jdbc.DTO.PersonneDTO;
import fr.imie.jdbc.itransactional.ITransation;

public interface IPersonneDAO extends ITransation {
	public abstract List<PersonneDTO> findAll();
	public abstract PersonneDTO findById(PersonneDTO dto);
	public abstract PersonneDTO insert(PersonneDTO dto);
	public abstract PersonneDTO update(PersonneDTO dto);
	public abstract void delete(PersonneDTO dto);
	public abstract PersonneDTO update(PersonneDTO dto, Connection connectionCaller);
	public abstract List<PersonneDTO> findByDTO(PersonneDTO findParameter);
	List<PersonneDTO> findByDTO(PersonneDTO findParameter, Connection connectionCaller);
}
