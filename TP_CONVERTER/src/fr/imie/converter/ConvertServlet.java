package fr.imie.converter;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConvertServlet
 */
@WebServlet("/ConvertServlet")
public class ConvertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject @Named("Euro2Dollar") private IConvert converterEuro2Dollar;
	@Inject @Named("Dollar2Euro") private IConvert converterDollar2Euro;
	
	@Inject
	IHistoric historic;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ConvertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Convert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if ( request.getParameter("DollarInput") != null )
		{
			Float valueToConvertInitial = Float.valueOf(request.getParameter("DollarInput"));
			Float valueToConvertFinal = null;
			valueToConvertFinal = converterDollar2Euro.convert(valueToConvertInitial);
			request.setAttribute("EuroValue", valueToConvertFinal);
			
			DataGui dataGui = new DataGui();
			dataGui.SetDataInitial(valueToConvertInitial);
			dataGui.SetDataFinal(valueToConvertFinal);
			historic.AddHistoric(dataGui);
		}
		
		if ( request.getParameter("EuroInput") != null )
		{
			Float valueToConvert = Float.valueOf(request.getParameter("EuroInput"));
			valueToConvert = converterEuro2Dollar.convert(valueToConvert);
			request.setAttribute("DollarValue", valueToConvert);
		}
		
		request.getRequestDispatcher("/WEB-INF/Convert.jsp").forward(request, response);
	}
}
