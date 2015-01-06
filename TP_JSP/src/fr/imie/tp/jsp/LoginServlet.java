package fr.imie.tp.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("loginInput");
		String password = request.getParameter("passwordInput");
		
		List<UserDTO> userDTOs = (List<UserDTO>)request.getSession().getAttribute("userDTOs");
		
		// Recherche du user correspond au login & password
		UserDTO userSecured = null;
		
		for (UserDTO userDTO : userDTOs)
		{
			if( userDTO.getLogin().compareTo(login) == 0 && userDTO.getPassword().compareTo(password) == 0 )
			{
				userSecured = userDTO;
				break;
			}
		}
		
		// Si un user s'est connecté, on stock le user en session (utilisé par le filtre)
		if ( userSecured != null )
		{
			request.getSession().setAttribute("connectedUser", userSecured);
		}

	}

}
