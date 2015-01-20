package fr.imie.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.model.Personne;

/**
 * Session Bean implementation class PersonneService
 */
@Stateless
public class PersonneService implements PersonneServiceLocal {

	@PersistenceContext
	EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public PersonneService() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Personne findById(Personne personne)
    {
    	return entityManager.find(Personne.class, personne.getId());
    }
}
