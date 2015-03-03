package fr.imie.tennis;

public class Jeux implements ISerialiser {
	
	private ISerialiser jeuSerialiser;
	private String score = "0-0";
	private Integer j1 = 0;
	private Integer j2 = 0;
	
	public Jeux (ISerialiser serialiser) {
		jeuSerialiser = serialiser;
	}
	/*
	0 = 0
	1 = 15
	2 = 30
	3 = 40
	4 = egalite ou victoire
	 */
	
	public String getScore() {
		

		if ( (j1 < 4) && (j2 < 4) && !( j1 == 3 && j2 == 3 ) ) {
			score = convertionPointsEnString(j1) + "-" + convertionPointsEnString(j2);
		}
		else if ( ( j1 >= 3 || j2 >= 3 ) ) {
			if ( j1 == j2 )
				score = "Egalite";
			else if ( j1 - j2 == 1 )
				score = "Avantage joueur1";
			else if ( j2 - j1 == 1 )
				score = "Avantage joueur2";
			else if ( j1 - j2 > 1)
				score = "Victoire joueur1";
			else if ( j2 - j1 > 1)
				score = "Victoire joueur2";
		}
		return score;
	}
	
	private String convertionPointsEnString(Integer points) {	
		String score = null;
		
		switch ( points )
		{
		case 0:
			score = "0";
			break;
		case 1:
			score = "15";
			break;
		case 2:
			score = "30";
			break;
		case 3:
			score = "40";
			break;
		/*
		case 4:
			score = "Victoire";
			break;
		*/
		default :
			throw new IllegalStateException(); 
		}
		
		return score;
	}
	public void joueur1MarqueUnPoint(/*Joueur joueur*/) {
		j1++;
		/*
		joueur.marqueUnPoint();
		if ( joueur.getPoints() == 4)
			score = joueur.getPointsConvertionEnScore();
		else
			score = joueur.getPointsConvertionEnScore() + score.substring(score.indexOf("-"));
			*/
	}
	
	public void joueur2MarqueUnPoint(/*Joueur joueur*/) {
		j2++;
		/*
		joueur.marqueUnPoint();
		if ( joueur.getPoints() == 4)
			score = joueur.getPointsConvertionEnScore();
		else
			score = score.substring(0, score.indexOf("-")) + "-" +  joueur.getPointsConvertionEnScore();
			*/
	}
	
	public void comparePointsJoueurs(Joueur joueur1, Joueur joueur2){
		if ( ( joueur1.getPoints() >= 3 || joueur2.getPoints() >= 3 ) ) {
			
			if (  joueur1.getPoints() == joueur2.getPoints()  )
				score = "Egalite";
			else if ( joueur1.getPoints() - joueur2.getPoints() == 1 )
				score = "Avantage joueur1";
			else if ( joueur2.getPoints() - joueur1.getPoints() == 1 )
				score = "Avantage joueur2";
		}
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
