package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllOwnersServlet
 */
@WebServlet("/viewAllOwnersServlet")
public class viewAllOwnersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllOwnersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		OwnerDao dao = new OwnerDao();
		request.setAttribute("allOwners", dao.viewAllOwners());
		if(dao.viewAllOwners().isEmpty())
		{
			request.setAttribute("allOwners", " ");
		}
		String fromJsp = request.getParameter("fromJsp");
//		if (fromJsp.equals("/addDog.jsp")) {
			getServletContext().getRequestDispatcher("/addDog.jsp").forward(request, response);
//		} else { 
//			getServletContext().getRequestDispatcher("/updateOwner.jsp").forward(request, response);
//		}
//		try {
//			getServletContext().getRequestDispatcher(fromJsp).forward(request, response);
//		} catch (Exception e) {
//			getServletContext().getRequestDispatcher("/updateDog.jsp").forward(request, response);
//		}
		
	}  //variablize the .jsp depending on who invoked it 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
