package controller;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Families;
import model.GameNight;
import model.Games;

/**
 * Servlet implementation class EditGameNightServlet
 */
@WebServlet("/editGameNightServlet")
public class EditGameNightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGameNightServlet() {
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
		doGet(request, response);
		
		GameNightHelper gnh = new GameNightHelper();
		GamesHelper gh = new GamesHelper();
		FamiliesHelper fh = new FamiliesHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		GameNight gameNightToUpdate = gnh.searchGameNightByID(tempId);
		
		String newTheme = request.getParameter("theme");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String family = request.getParameter("family");
		Families newfamily = fh.findFamily(family);
		
		LocalDate newLd;
		try {
			newLd = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException e) {
			newLd = LocalDate.now();
		} catch (DateTimeException e) {  //in case dates entered is not valid dates, put in today's for now
			newLd = LocalDate.now();
		}
		
		try {
			//items are selected in GUI to add
			String[] selectedGames = request.getParameterValues("allGames");
			List<Games> selectedGamesInList = new ArrayList<Games>();
			
			for (int i = 0; i < selectedGames.length; i++) {
				Games c = gh.searchGameByID(Integer.parseInt(selectedGames[i]));
				selectedGamesInList.add(c);
			}
			
			gameNightToUpdate.setListOfGames(selectedGamesInList);
		} catch (NullPointerException ex) {
			//no items selected in list - set to an empty list
			List<Games> selectedGamesInList = new ArrayList<Games>();
			gameNightToUpdate.setListOfGames(selectedGamesInList);
		}
		
		gameNightToUpdate.setTheme(newTheme);
		gameNightToUpdate.setNight(newLd);
		gameNightToUpdate.setFamily(newfamily);
		
		gnh.updateGameNight(gameNightToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllGameNightsServlet").forward(request, response);
	}

}
