package fr.imie.presentation;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.model.Personne;
import fr.imie.model.Promotion;
import fr.imie.service.PersonneServiceLocal;

/**
 * Servlet implementation class OneUser
 */
@WebServlet("/OneUser")
public class OneUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	PersonneServiceLocal personneService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idString = request.getParameter("id");
		Integer id = Integer.valueOf(idString);
		List<Promotion> promotions = personneService.findAllPromotions();
		
		Personne personne = new Personne();
		personne.setId(id);
		personne = personneService.findById(personne);
		
		request.setAttribute("Promotions", promotions);
		request.setAttribute("Personne", personne);
		request.getRequestDispatcher("/WEB-INF/Personne.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("nameInput");
		String lastname = request.getParameter("lastnameInput");
		String promoIdString = request.getParameter("promotionInput");
		
		Logger.getAnonymousLogger().info("Promo id selected = " + promoIdString);
		
		Personne personneToUpdate = new Personne();
		personneToUpdate.setId(id);
		if ( !name.isEmpty() )
			personneToUpdate.setNom(name);
		if (!name.isEmpty() )
			personneToUpdate.setPrenom(lastname);	
		
		
		Promotion promotion = null;
		if ( !promoIdString.isEmpty() )
		{
			promotion = new Promotion();
			promotion.setId(Integer.valueOf(promoIdString));
		}
		personneToUpdate.setPromotion(promotion);
		
		personneService.update(personneToUpdate);

		response.sendRedirect("AllUser");
	}
}
