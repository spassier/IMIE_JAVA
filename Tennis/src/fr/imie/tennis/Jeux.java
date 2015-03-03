package fr.imie.tennis;

public class Jeux implements ISerialiser {
	
	private ISerialiser jeuSerialiser;
	private String score = "0-0";
		
	public Jeux (ISerialiser serialiser) {
		jeuSerialiser = serialiser;
	}
	
	public String getScore() {
		return score;
	}
	
	public void joueur1MarqueUnPoint(Joueur joueur) {
		joueur.marqueUnPoint();
		if ( joueur.getPoints() == 4)
			score = joueur.getPointsConvertionEnScore();
		else
			score = joueur.getPointsConvertionEnScore() + score.substring(score.indexOf("-"));
	}
	
	public void joueur2MarqueUnPoint(Joueur joueur) {
		joueur.marqueUnPoint();
		if ( joueur.getPoints() == 4)
			score = joueur.getPointsConvertionEnScore();
		else
			score = score.substring(0, score.indexOf("-")) + "-" +  joueur.getPointsConvertionEnScore();
	}
	
	public void comparePointsJoueurs(Joueur joueur1, Joueur joueur2){
		if ( ( joueur1.getPoints() >= 3 ) && ( joueur1.getPoints() == joueur2.getPoints() ) )
			score = "Egalite";
		else if ( joueur1.getPoints() == 4 && joueur2.getPoints() == 3 )
			score = "Avantage joueur1";
		else if ( joueur1.getPoints() == 3 && joueur2.getPoints() == 4 )
			score = "Avantage joueur2";
	}

	@Override
	public void persist(Jeux jeux) {
		jeuSerialiser.persist(this); 
		
	}

	@Override
	public Jeux read() {

		return jeuSerialiser.read();
	}
	
}
