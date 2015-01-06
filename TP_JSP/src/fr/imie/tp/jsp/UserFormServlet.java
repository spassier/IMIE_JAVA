package fr.imie.tp.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		// Forward du resultat à la jsp
		request.setAttribute("user", userSelected);
		request.getRequestDispatcher("/WEB-INF/UserForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
