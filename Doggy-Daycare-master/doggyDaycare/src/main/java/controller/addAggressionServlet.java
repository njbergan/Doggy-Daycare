package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aggression;

/**
 * Servlet implementation class addAggressionServlet
 */
@WebServlet("/addAggressionServlet")
public class addAggressionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAggressionServlet() {
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
        Integer aggressor = Integer.parseInt(request.getParameter("aggressor"));
        Integer victim = Integer.parseInt(request.getParameter("victim"));
		String incidentDate = request.getParameter("incidentDate");
		SimpleDateFormat iDate = new SimpleDateFormat("dd-MM-yyyy");
        Date incident = null;
		try {
			incident = iDate.parse(incidentDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String incidentDescription = request.getParameter("incidentDescription");
		
		Aggression ruction = new Aggression(aggressor, victim, null, incidentDescription);
		ruction.setIncidentDate(ruction.convertJavaToSqlDate(incident));
		AggressionDao dao = new AggressionDao();
		dao.insertAggression(ruction);
		getServletContext().getRequestDispatcher("/addAggression.html").forward(request, response);
	}

}
