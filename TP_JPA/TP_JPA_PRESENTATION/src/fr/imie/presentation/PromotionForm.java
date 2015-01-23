package fr.imie.presentation;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.model.Personne;
import fr.imie.model.Promotion;
import fr.imie.service.PersonneServiceLocal;

/**
 * Servlet implementation class PromotionForm
 */
@WebServlet("/PromotionForm")
public class PromotionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@EJB
	PersonneServiceLocal personneService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromotionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idString = request.getParameter("id");
		Integer id = Integer.valueOf(idString);
		
		Promotion promotion = new Promotion();
		promotion.setId(id);
		List<Personne> personnes = personneService.findAllPersonneByPromotion(promotion);
		
		request.setAttribute("Personnes", personnes);
		request.getRequestDispatcher("/WEB-INF/PromotionForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
