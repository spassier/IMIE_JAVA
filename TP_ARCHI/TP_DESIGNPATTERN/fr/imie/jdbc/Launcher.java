package fr.imie.jdbc;

import fr.imie.jdbc.ipresentation.IPresentation;
import fr.imie.jdbc.itransverse.IFactory;
import fr.imie.jdbc.transverse.Factory;


/**
 * 
 */

/**
 * @author imie
 *
 */
public class Launcher {

	/**
	 * fonction de démarrage de l'application utilisation de JDBC pour faire les
	 * différentes requêtes. recherche des personnes en utilisant un statement +
	 * executeQuery. recherche d'une personne en construisant dynamiquement la
	 * requête + executeQuery. recherche d'une personne en utilisant un
	 * preparedStatement + Execute Query. libération des ressources dans le
	 * finally
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		IFactory factory = Factory.getInstance();
		
		factory.createPresentation().start();
		
		//IPresentation presentation = new Presentation(factory);
		//presentation.start();
	}

}
