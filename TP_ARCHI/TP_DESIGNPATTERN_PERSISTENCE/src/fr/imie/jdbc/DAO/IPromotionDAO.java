package fr.imie.jdbc.DAO;

import java.util.List;

import fr.imie.jdbc.DTO.PromotionDTO;

public interface IPromotionDAO {
	public abstract PromotionDTO findById(PromotionDTO dto);
	public abstract void delete(PromotionDTO dto);
	List<PromotionDTO> findAll();

}
