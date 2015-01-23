package fr.imie.service;

import java.util.List;
import java.sql.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import fr.imie.model.Personne;
import fr.imie.model.Promotion;

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
    
    @Override
    public List<Personne> findAll()
    {
    	Query query = entityManager.createNamedQuery("Personne.findAll");
    	return query.getResultList();
    }

	@Override
	public void delete(Personne personne) {
		//  Solution par merge (attention aux héritage multiples qui peuvent bugger)
		Personne personneToDelete = entityManager.merge(personne);
		entityManager.remove(personneToDelete);
		
		//  Solution par findById recuperer depuis le serveur (methode la plus sure)
		/*
		Personne personneToDelete = this.findById(personne);
		entityManager.remove(personneToDelete);
		*/
		
		// Solution par query, a utiliser pour les batchs
		/*
		Query query = entityManager.createNamedQuery("Personne.delete");
		query.setParameter("id", personne.getId()).executeUpdate();
		*/
	}

	@Override
	public void update(Personne personne) {
		// Solution par merge
		entityManager.merge(personne);
		
		// Solution par query, a utiliser pour les batchs
		/*
		Query query = entityManager.createNamedQuery("Personne.update");
		query.setParameter("nom", personne.getNom());
		query.setParameter("prenom", personne.getPrenom());
		query.setParameter("password", personne.getPassword());
		query.setParameter("tel", personne.getTel());
		query.setParameter("promotion_id", personne.getPromotionId());
		//Date dateNaiss = new Date(personne.getDatenaiss().getTime());
		//query.setParameter("datenaiss", dateNaiss, TemporalType.DATE);
		query.setParameter("id", personne.getId());
		query.executeUpdate();
		*/
	}

	@Override
	public void create(Personne personne) {
		// Solution persist, pas d'autre solution (le CREATE n'existe pas en JPQL)
		entityManager.persist(personne);
	}

	@Override
	public List<Promotion> findAllPromotions() {
    	Query query = entityManager.createNamedQuery("Promotion.findAll");
    	return query.getResultList();
	}

	@Override
	public List<Personne> findAllPersonneByPromotion(Promotion promotion) {
		
		Query query = entityManager.createNamedQuery("Promotion.findById");
		query.setParameter("id", promotion.getId());
		Promotion promotionFound = (Promotion)query.getSingleResult();
		
		for ( Personne personneItem : promotionFound.getPersonnes() )
		{
			// Boucle pour remplir la liste (OneToMany est en lazy...)
		}
		
		return promotionFound.getPersonnes();
	}
}
