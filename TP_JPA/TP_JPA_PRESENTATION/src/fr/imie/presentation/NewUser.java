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
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	PersonneServiceLocal personneService;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Promotion> promotions = personneService.findAllPromotions();
		
		request.setAttribute("Promotions", promotions);
		request.getRequestDispatcher("/WEB-INF/NewPersonne.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("nameInput");
		String lastname = request.getParameter("lastnameInput");
		String promoIdString = request.getParameter("promotionInput");
		
		Logger.getAnonymousLogger().info("Promo id selected = " + promoIdString);

		Personne personneToCreate = new Personne();
		personneToCreate.setNom(name);
		personneToCreate.setPrenom(lastname);

		Promotion promotion = null;
		if ( !promoIdString.isEmpty() )
		{
			promotion = new Promotion();
			promotion.setId(Integer.valueOf(promoIdString));
		}
		personneToCreate.setPromotion(promotion);

		personneService.create(personneToCreate);

		response.sendRedirect("AllUser");
	}
}
