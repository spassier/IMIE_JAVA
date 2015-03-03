package fr.imie.tennis;

public class Serialiser implements ISerialiser {

	private Jeux jeuxSerialiser;

	@Override
	public void persist(Jeux jeux) {
		jeuxSerialiser = jeux;

	}

	@Override
	public Jeux read() {
		return jeuxSerialiser;
	}

}
