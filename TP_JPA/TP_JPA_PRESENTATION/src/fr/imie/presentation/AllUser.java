package fr.imie.presentation;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.model.Personne;
import fr.imie.service.PersonneServiceLocal;

/**
 * Servlet implementation class AllUser
 */
@WebServlet("/AllUser")
public class AllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	PersonneServiceLocal personneService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Personne> personnes = personneService.findAll();
		
		request.setAttribute("Personnes", personnes);
		request.getRequestDispatcher("/WEB-INF/Personnes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idTodelete = Integer.valueOf(request.getParameter("deleteInput"));
		
		System.out.println(idTodelete);
		
		Personne personneToDelete = new Personne();
		personneToDelete.setId(idTodelete);
		personneService.delete(personneToDelete);

		response.sendRedirect("AllUser");
	}
}
