package fr.imie.rest;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.imie.model.Personne;
import fr.imie.service.*;

@Stateless
@Path("Personnes")
// La structure de l'url est de la forme localhost/app/url-pattern du web.xml/nom de l'EJB/method
// donc dans le cas du TP : localhost:8080/TP_REST2/RestService/Personnes
public class RestService {
	
	@EJB
	SchoolServiceLocal personneService;
	
	@GET()
	@Produces( MediaType.APPLICATION_JSON )
	public Response doGet()
	{
		List<Personne> personnes = personneService.findPersonAll();
		return Response.ok(personnes).build();
	}
	
	@DELETE()
	@Produces( MediaType.APPLICATION_JSON )
	@Path("/{id}")
	public void doDelete(@PathParam("id") Integer id )
	{
		Personne personne = new Personne();
		personne.setId(id);
		personneService.deletePerson(personne);
	}
	
	@POST() // Ajouter contentType application/json dans POSTMAN
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response doPost( Personne personne )
	{
		Personne newPersonne = personneService.createPerson(personne);
		return Response.ok(newPersonne).build();
	}
	
	@PUT()
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response doPut( Personne personne)
	{
		Personne newPersonne = personneService.updatePerson(personne);
		return Response.ok(newPersonne).build();
	}
	
}
