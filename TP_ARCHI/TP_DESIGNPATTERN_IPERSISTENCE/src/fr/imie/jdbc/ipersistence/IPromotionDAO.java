package fr.imie.jdbc.ipersistence;

import java.util.List;
import java.sql.Connection;
import fr.imie.jdbc.DTO.PromotionDTO;

public interface IPromotionDAO {
	public abstract PromotionDTO findById(PromotionDTO dto);
	public abstract void delete(PromotionDTO dto);
	public abstract void delete(PromotionDTO dto, Connection connection);
	List<PromotionDTO> findAll();
}
