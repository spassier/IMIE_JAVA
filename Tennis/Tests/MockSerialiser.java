

import fr.imie.tennis.ISerialiser;
import fr.imie.tennis.Jeux;

public class MockSerialiser implements ISerialiser {

	private Jeux jeuxSerialiser;

	@Override
	public void persist(Jeux jeux) {
		//jeuxSerialiser = jeux;

	}

	@Override
	public Jeux read() {
		
		jeuxSerialiser = new Jeux(this);
		jeuxSerialiser.setJ1(1);
		jeuxSerialiser.setJ2(1);
		return jeuxSerialiser;
	}

}
