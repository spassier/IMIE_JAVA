package fr.imie.service;

import javax.ejb.Local;

import fr.imie.model.Personne;

@Local
public interface PersonneServiceLocal {
	public abstract Personne findById(Personne personne);
}
