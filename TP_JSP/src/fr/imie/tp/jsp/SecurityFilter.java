package fr.imie.tp.jsp;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Securityfilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/*" })
public class SecurityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/**/
		/* TP7 prerequis creer un filter de connexion */
		/**/
		
		Boolean resourceAllowed = true;
		HttpServletRequest httpServletRequest = (HttpServletRequest)request; // cast en HttpServletRequest pour de la retro compatibilité
		HttpServletResponse httpServletResponse = (HttpServletResponse)response; // idem
		
		// Recupere l'url avec les parametres
		String url = httpServletRequest.getRequestURI();
		if ( httpServletRequest.getQueryString() != null )
			url = url.concat("?").concat(httpServletRequest.getQueryString());
			
		// Determine si la ressource est autorisée ou non
		if ( !url.contains("css") && !url.contains("js") && !url.contains("login") && !url.contains("Login") )
			resourceAllowed = false;
		
		// Detecte si le user est connecté ou pas
		UserDTO connectedUser = (UserDTO) httpServletRequest.getSession().getAttribute("connectedUser");
		
		// Si la ressource est protegée et que le user n'est pas connecté...
		if ( !resourceAllowed && connectedUser == null ) 
		{
			// Track l'url redirigée pour fournir l'url APRES le login 
			httpServletRequest.getSession().setAttribute("askedResource", url);
			// ...alors on fait la redirection vers la page login
			httpServletResponse.sendRedirect("./LoginServlet");
		}
		else
		{
			// ...sinon on pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
		// Redirection vers la page trackée si elle existe et que le user VIENT de se connecter
		UserDTO recentConnectedUser = (UserDTO) httpServletRequest.getSession().getAttribute("connectedUser");
		if ( connectedUser == null && recentConnectedUser!= null )
		{
			String askedResource = (String) httpServletRequest.getSession().getAttribute("askedResource");
			
			// Au cas ou on vient de la page Login (donc pas de page trackée) on redirect sur une page par defaut
			if ( askedResource == null )
				askedResource = "UserListServlet";
			
			httpServletResponse.sendRedirect(askedResource);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
