package fr.imie.service;

import java.util.List;

import javax.ejb.Local;

import fr.imie.model.Promotion;

@Local
public interface PromotionServiceLocal {
	public abstract List<Promotion> findAll();
}
