package fr.imie.rest;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.model.Personne;
import fr.imie.service.*;

/**
 * Servlet implementation class Users
 */
@WebServlet("/Users/*") // On etends le path de la servlet pour prendre en consideration ce qui se trouve apres Users
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SchoolServiceLocal personneService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

			response.setContentType("application/json");
		
			List<Personne> personnes = personneService.findPersonAll();
		
			Writer out = response.getWriter();
		
			String json = "[";
			for ( Personne item : personnes )
			{
				json += "{nom:" + item.getPrenom() + "\", prenom:" + item.getNom() + "\"}" + ",";
			}
			json = json.substring(0, json.length() - 1);
			json += "]";

			out.write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "[{name:bla, prenom:blu}]";
		
		String nom = "bla";
		String prenom = "blu";
		
		Personne personne = new Personne();
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personneService.createPerson(personne);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String urlPath = request.getRequestURI();// .getPathInfo();
		Pattern pattern = Pattern.compile("/Users\\/(\\S*)");
		Matcher matcher = pattern.matcher(urlPath);
		
		System.out.println(urlPath);
		
		Integer id = null;
		if ( matcher.find() ){
			String idString = matcher.group(1);//urlPath.substring(1, urlPath.length());
			System.out.println(idString);
			
			id = Integer.parseInt(idString);
			
			if ( id != null )
			{
				Personne personne = new Personne();
				personne.setId(id);
				//personne = personneService.findPersonById(personne);
				personneService.deletePerson(personne);
			}
			else
			{
				response.sendError(400, "Tu t'es planté dans l'url, couillon...");
			}
		}
	}
}
