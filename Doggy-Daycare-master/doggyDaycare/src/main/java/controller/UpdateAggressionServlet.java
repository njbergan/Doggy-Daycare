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
 * Servlet implementation class UpdateAggressionServlet
 */
@WebServlet("/UpdateAggressionServlet")
public class UpdateAggressionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAggressionServlet() {
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
		AggressionDao dao = new AggressionDao();
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
		
		Integer tempId = Integer.parseInt(request.getParameter("incidentId"));
		Aggression aggToUpdate = dao.searchForAggressionById(tempId);
		aggToUpdate.setAggressor(aggressor);
		aggToUpdate.setVictim(victim);
		aggToUpdate.setIncidentDate(aggToUpdate.convertJavaToSqlDate(incident));
		aggToUpdate.setIncidentDescription(incidentDescription);
		
		dao.updateAggression(aggToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllIncidents").forward(request, response);
	}

}
