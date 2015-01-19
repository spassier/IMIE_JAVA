package fr.imie.jdbc.itransverse;


import fr.imie.jdbc.ipersistence.IPersonneDAO;
import fr.imie.jdbc.ipersistence.IPromotionDAO;
import fr.imie.jdbc.ipresentation.IPresentation;
import fr.imie.jdbc.iservice.IService;


public interface IFactory {
	public abstract IService createService();
	public abstract IPersonneDAO createPersonneDAO();
	public abstract IPromotionDAO createPromotionDAO();
	public abstract IPresentation createPresentation();
}
