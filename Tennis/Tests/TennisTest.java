import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import fr.imie.tennis.ISerialiser;
import fr.imie.tennis.Jeux;


public class TennisTest {

	private ISerialiser serialiser; 
	private Jeux jeux;
	
	@Before
	public void testInitialisationNouveauTest() {
		serialiser = new MockSerialiser();
		jeux = new Jeux(serialiser);
	}
	
	@Test
	public void testAfficherScoreDebutDePartie() {
		Assert.assertEquals("0-0", jeux.getScore() );
	}

	@Test
	public void testAfficherScore_15_0() {
		jeux.joueur1MarqueUnPoint();
		Assert.assertEquals("15-0", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScore_30_0() {	
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		Assert.assertEquals("30-0", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScore_40_0() {	
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		Assert.assertEquals("40-0", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScore_VictoireJ1() {	
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		Assert.assertEquals("Victoire joueur1", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScore_0_15() {
		jeux.joueur2MarqueUnPoint();
		Assert.assertEquals("0-15", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScore_0_30() {	
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		Assert.assertEquals("0-30", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScore_0_40() {	
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		Assert.assertEquals("0-40", jeux.getScore() );
	}
	
	@Test
	public void testAfficherScoreEgalite() {
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		Assert.assertEquals("Egalite", jeux.getScore() );
	}
	
	@Test
	public void testAfficherAvantageJoueur1() {
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		Assert.assertEquals("Avantage joueur1", jeux.getScore() );
	}
	
	@Test
	public void testAfficherAvantageJoueur2() {
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		Assert.assertEquals("Avantage joueur2", jeux.getScore() );
	}
	
	@Test
	public void testAfficherAvantageJoueurs2PuisEgalite() {
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		Assert.assertEquals("Egalite", jeux.getScore() );
	}
	
	@Test
	public void testAfficherAvantageJoueurs2PuisEgalitePuisAvantageJoueur1() {
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur2MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		jeux.joueur1MarqueUnPoint();
		Assert.assertEquals("Avantage joueur1", jeux.getScore() );
	}
	
	@Test
	public void testReadScore0_0() {
		ISerialiser serialiser = mock(ISerialiser.class);
		Jeux jeuTest = new Jeux(serialiser);
		when(serialiser.read()).thenReturn(jeuTest);
		Jeux jeu = new Jeux(serialiser);
		jeu.charger();
		
		Assert.assertEquals("0-0", jeu.getScore() );

	}
	
	@Test
	public void testReadScore15_15() {
		ISerialiser serialiser = mock(ISerialiser.class);
		Jeux jeuTest = new Jeux(serialiser);
		jeuTest.setJ1(1);
		jeuTest.setJ2(1);
		when(serialiser.read()).thenReturn(jeuTest);
		Jeux jeu = new Jeux(serialiser);
		jeu.charger();
		
		Assert.assertEquals("15-15", jeu.getScore() );
	}
	
	@Test
	public void testReadScore30_30() {
		ISerialiser serialiser = mock(ISerialiser.class);
		Jeux jeuTest = new Jeux(serialiser);
		jeuTest.setJ1(2);
		jeuTest.setJ2(2);
		when(serialiser.read()).thenReturn(jeuTest);
		Jeux jeu = new Jeux(serialiser);
		jeu.charger();
		
		Assert.assertEquals("30-30", jeu.getScore() );
	}
}
