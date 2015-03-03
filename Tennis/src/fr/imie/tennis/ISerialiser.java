package fr.imie.tennis;

public interface ISerialiser {
	public abstract void persist(Jeux jeux);
	public abstract Jeux read();
}
