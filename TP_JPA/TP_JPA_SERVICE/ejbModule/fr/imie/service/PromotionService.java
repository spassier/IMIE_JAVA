package fr.imie.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.model.Personne;
import fr.imie.model.Promotion;

/**
 * Session Bean implementation class PromotionService
 */
@Stateless
public class PromotionService implements PromotionServiceLocal {

	@PersistenceContext
	EntityManager entityManager;
	
	/**
     * Default constructor. 
     */
    public PromotionService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Promotion> findAll() {
    	Query query = entityManager.createNamedQuery("Promotion.findAll");
    	return query.getResultList();
	}
 }
