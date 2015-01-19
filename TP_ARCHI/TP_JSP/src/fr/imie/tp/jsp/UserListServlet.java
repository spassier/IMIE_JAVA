package fr.imie.tp.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object userDTOs = request.getSession().getAttribute("userDTOs");
		request.setAttribute("users", userDTOs); // C'est le controleur qui fournis les données
		request.getRequestDispatcher("/WEB-INF/UserList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TP8 : ajouter un bouton "delete" et realiser la suppression d'un user
		
		// Recupere l'id technique passer en parametre (solution basique pour le TP)
		Integer deleteId = Integer.valueOf(request.getParameter("deleteInput"));
		
		// Recherche le user correspondant aux users de la session
		List<UserDTO> userDTOs = (List<UserDTO>)request.getSession().getAttribute("userDTOs");
		UserDTO userToDelete = null;
		for (UserDTO userDTO : userDTOs)
		{
			if( userDTO.getId() == deleteId )
			{
				userToDelete = userDTO;
				break;
			}
		}
		
		// Retire de la session le connectedUser si le user à effacer est connecté
		UserDTO connectedUser = (UserDTO)request.getSession().getAttribute("connectedUser");
		if ( connectedUser.getId() == userToDelete.getId() )
			request.getSession().removeAttribute("connectedUser");
			
		// Suppression du user de la list des users DTO, pas besoin de reinjecter userDTos dans la session car c'est une reference (il n' a pas de clonage)
		userDTOs.remove(userToDelete);
		
		// Puis reinjection de la list des users pour la page jsp
		request.setAttribute("users", userDTOs);
		
		// Forward du resultat à la page UserList
		request.getRequestDispatcher("/WEB-INF/UserList.jsp").forward(request, response);
	}
}
