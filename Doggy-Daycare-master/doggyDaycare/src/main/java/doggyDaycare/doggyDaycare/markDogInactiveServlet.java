package doggyDaycare.doggyDaycare;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class markDogInactiveServlet
 */
@WebServlet("/markDogInactiveServlet")
public class markDogInactiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public markDogInactiveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		DogDao dao = new DogDao();
        Integer active = Integer.parseInt(request.getParameter("activeFlag"));

		Integer tempId = Integer.parseInt(request.getParameter("dogId"));
		Dog doge = dao.searchForDogById(tempId);
		
		doge.setActiveFlag(active);
		getServletContext().getRequestDispatcher("/viewAllActiveDogsServlet").forward(request, response);
	}

}
