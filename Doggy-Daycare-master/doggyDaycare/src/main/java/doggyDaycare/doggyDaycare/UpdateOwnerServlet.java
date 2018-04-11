package doggyDaycare.doggyDaycare;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateOwnerServlet
 */
@WebServlet("/UpdateOwnerServlet")
public class UpdateOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		OwnerDao dao = new OwnerDao();
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
        
		int tempId = Integer.parseInt(request.getParameter("OwnerId"));
        Owner ownerToUpdate = dao.searchForOwnerById(tempId);
        
        ownerToUpdate.setFirstName(first);
        ownerToUpdate.setLastName(last);
        ownerToUpdate.setPhone(phone);
        ownerToUpdate.setStreet(street);
        ownerToUpdate.setCity(city);
        ownerToUpdate.setState(state);
        ownerToUpdate.setZip(zip);
        
        dao.updateOwner(ownerToUpdate);
        
		getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
	}

}
