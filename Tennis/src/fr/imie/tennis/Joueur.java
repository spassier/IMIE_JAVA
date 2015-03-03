package fr.imie.tennis;

public class Joueur {
	private Integer points = 0;
	
	void marqueUnPoint() {
		points++;
	}
	
	Integer getPoints() {
		return points;
	}

	String getPointsConvertionEnScore() {
		String score = "0";
		
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
			case 4:
				score = "Victoire";
				break;
			default :
				throw new IllegalStateException(); 
		}
		
		return score;
	}
}
