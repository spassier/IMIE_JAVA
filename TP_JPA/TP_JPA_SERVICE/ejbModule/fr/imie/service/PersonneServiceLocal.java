package fr.imie.service;

import java.util.List;

import javax.ejb.Local;

import fr.imie.model.Personne;

@Local
public interface PersonneServiceLocal {
	public abstract Personne findById(Personne personne);
	public abstract List<Personne> findAll();
	public abstract void delete(Personne personne);
	public abstract void update(Personne personne);
	public abstract void create(Personne personne);
}
