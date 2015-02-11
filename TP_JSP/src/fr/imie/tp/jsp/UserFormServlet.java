package fr.imie.tp.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.archi.AbstractFactory;
import fr.imie.archi.ConcreteFactory;
import fr.imie.archi.DTO.PersonneDTO;
import fr.imie.archi.service.IEcoleService;

/**
 * Servlet implementation class UserFormServlet
 */
@WebServlet("/UserFormServlet")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperation du parametre envoyer par le client (?id=dfdsfdsfds)
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		AbstractFactory factory = new ConcreteFactory();
		IEcoleService service = factory.createEcoleService();
		PersonneDTO userSelected = new PersonneDTO();
		userSelected.setId(id);
		userSelected = service.findPersonneById(userSelected);

	
		/*
		// Recuperation de la liste des DTO
		List<UserDTO> userDTOs = (List<UserDTO>)request.getSession().getAttribute("userDTOs");
		
		// Recherche du user correspond à l'id
		UserDTO userSelected=null;
		for (UserDTO userDTO : userDTOs)
		{
			if(userDTO.getId()==id)
			{
				userSelected=userDTO;
				break;
			}
		}
		*/
		
		// Forward du resultat à la jsp
		request.setAttribute("user", userSelected);
		request.getRequestDispatcher("/WEB-INF/UserForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TP10 : inclure un bouton pour updater
		String newPassword = request.getParameter("passwordInput");
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		AbstractFactory factory = new ConcreteFactory();
		IEcoleService service = factory.createEcoleService();
		PersonneDTO personneToUpdate = new PersonneDTO();
		personneToUpdate.setId(id);
		personneToUpdate = service.findPersonneById(personneToUpdate);
		personneToUpdate.setPassword(newPassword);
		service.updatePersonne(personneToUpdate);
		
		/*
		List<UserDTO> userDTOs = (List<UserDTO>)request.getSession().getAttribute("userDTOs");
		UserDTO userToUpdate = null;
		for (UserDTO userDTO : userDTOs)
		{
			if( userDTO.getId() == id )
			{
				userToUpdate = userDTO;
				break;
			}
		}
		
		// MAJ du password dans la liste des user DTO
		userToUpdate.setPassword(newPassword);
		*/	
		
		// Redirection du resultat à la servlet user list
		response.sendRedirect("UserListServlet");
	}
}
