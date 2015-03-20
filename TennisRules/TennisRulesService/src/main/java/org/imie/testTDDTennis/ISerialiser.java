package org.imie.testTDDTennis;

public interface ISerialiser {

	public abstract void persist(Jeux jeux);

	public abstract Jeux read();

}