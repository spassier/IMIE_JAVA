package fr.imie.tennis;

import static org.mockito.Mockito.mock;

public class Jeux {
	
	private ISerialiser jeuSerialiser;
	private String score = "0-0";
	


	private Integer j1 = 0;
	private Integer j2 = 0;
	
	public Jeux (ISerialiser serialiser) {
		jeuSerialiser = serialiser;
	}
	
	public Integer getJ1() {
		return j1;
	}

	public void setJ1(Integer j1) {
		this.j1 = j1;
	}

	public Integer getJ2() {
		return j2;
	}

	public void setJ2(Integer j2) {
		this.j2 = j2;
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
		default :
			throw new IllegalStateException(); 
		}
		
		return score;
	}
	public void joueur1MarqueUnPoint() {
		j1++;
	}
	
	public void joueur2MarqueUnPoint() {
		j2++;
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

	public void charger() {

		Jeux jeu = jeuSerialiser.read();
		this.setJ1(jeu.getJ1());
		this.setJ2(jeu.getJ2());
	}
	
}
