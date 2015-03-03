import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.imie.tennis.ISerialiser;
import fr.imie.tennis.Jeux;
import fr.imie.tennis.Joueur;
import fr.imie.tennis.Serialiser;


public class TennisTest {

	private ISerialiser serialiser; 
	private Jeux jeux;
	private Joueur joueur1;
	private Joueur joueur2;
	
	@Before
	public void testInitialisationNouveauTest() {
		serialiser = new Serialiser();
		jeux = new Jeux(serialiser);
		joueur1 = new Joueur();
		joueur2 = new Joueur();
	}
	
	@Test
	public void testAfficherScoreDebutDePartie() {
		Assert.assertEquals("0-0", jeux.getScore() );
	}

	@Test
	public void testAfficherScore_15_0() {
		jeux.joueur1MarqueUnPoint(joueur1);
		Assert.assertEquals("15-0", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScore_30_0() {	
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.joueur1MarqueUnPoint(joueur1);
		Assert.assertEquals("30-0", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScore_40_0() {	
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.joueur1MarqueUnPoint(joueur1);
		Assert.assertEquals("40-0", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScore_Victoire() {	
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.joueur1MarqueUnPoint(joueur1);
		Assert.assertEquals("Victoire", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScore_0_15() {
		jeux.joueur2MarqueUnPoint(joueur2);
		Assert.assertEquals("0-15", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScore_0_30() {	
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur2);
		Assert.assertEquals("0-30", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScore_0_40() {	
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur2);
		Assert.assertEquals("0-40", jeux.getScore() );
	}
	
	@Test
	public void testJoueurGagnePartie() {
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur2);
		Assert.assertEquals("Victoire", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScoreEgalite() {
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.comparePointsJoueurs(joueur1, joueur2);
		Assert.assertEquals("Egalite", jeux.getScore() );
	}
	
	@Test
	public void testAfficherAvantageJoueur1() {
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.comparePointsJoueurs(joueur1, joueur2);
		Assert.assertEquals("Avantage joueur1", jeux.getScore() );
	}
	
	@Test
	public void testAfficherAvantageJoueur2() {
		jeux.joueur1MarqueUnPoint(joueur2);
		jeux.joueur1MarqueUnPoint(joueur2);
		jeux.joueur1MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur1);
		jeux.joueur2MarqueUnPoint(joueur1);
		jeux.joueur2MarqueUnPoint(joueur1);
		jeux.joueur1MarqueUnPoint(joueur2);
		jeux.comparePointsJoueurs(joueur1, joueur2);
		Assert.assertEquals("Avantage joueur2", jeux.getScore() );
	}
	
	@Test
	public void testPersistScore0_0() {
		jeux.persist(jeux);
		Assert.assertEquals("0-0", jeux.read().getScore() );

	}
	
	@Test
	public void testPersistScore15_0() {
		jeux.joueur1MarqueUnPoint(joueur1);
		jeux.persist(jeux);
		Assert.assertEquals("15-0", jeux.read().getScore() );
	}
	
	@Test
	public void testPersistScore0_40() {
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.joueur2MarqueUnPoint(joueur2);
		jeux.persist(jeux);
		Assert.assertEquals("0-40", jeux.read().getScore() );
	}
}
