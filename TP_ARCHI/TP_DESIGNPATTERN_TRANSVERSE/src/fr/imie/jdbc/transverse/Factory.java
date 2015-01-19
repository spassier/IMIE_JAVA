package fr.imie.jdbc.transverse;


import fr.imie.jdbc.ipersistence.IPersonneDAO;
import fr.imie.jdbc.ipersistence.IPromotionDAO;
import fr.imie.jdbc.ipresentation.IPresentation;
import fr.imie.jdbc.iservice.IService;
import fr.imie.jdbc.itransverse.IFactory;
import fr.imie.jdbc.presentation.Presentation;
import fr.imie.jdbc.service.Service;
import fr.imie.jdbc.DAO.*;


public class Factory implements IFactory
{
	private static Factory instance = null;
	
	private Factory()
	{
		
	}
	
	/*
	 * Singleton
	 */
	public static synchronized Factory getInstance()
	{
		if ( instance == null )
		{
			instance = new Factory();
		}
		return instance;
	}
	
	@Override
	public IService createService() {
		return Service.getInstance(instance);
	}

	@Override
	public IPersonneDAO createPersonneDAO() {
		return new ProxyPersonneDAO(PersonneDAO.getInstance());
	}

	@Override
	public IPromotionDAO createPromotionDAO() {
		return PromotionDAO.getInstance();
	}

	@Override
	public IPresentation createPresentation() {
		return new Presentation(instance);
	}
}
