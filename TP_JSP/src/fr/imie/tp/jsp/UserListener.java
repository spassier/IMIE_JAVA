package fr.imie.tp.jsp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class UserListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public UserListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)
    { 
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setId(1);
        userDTO1.setLogin("toto");
        userDTO1.setPassword("toto");
        
        UserDTO userDTO2 = new UserDTO();
        userDTO2.setId(2);
        userDTO2.setLogin("titi");
        userDTO2.setPassword("titi");
        
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        userDTOs.add(userDTO1);
        userDTOs.add(userDTO2);
        arg0.getSession().setAttribute("userDTOs", userDTOs);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
