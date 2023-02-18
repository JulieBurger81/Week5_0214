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
 * Servlet implementation class AddGameNightServlet
 */
@WebServlet("/addGameNightServlet")
public class AddGameNightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameNightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GamesHelper gh = new GamesHelper();
		GameNightHelper gnh = new GameNightHelper();
		FamiliesHelper fh = new FamiliesHelper();
		
		String theme = request.getParameter("theme");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String family = request.getParameter("family");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		} catch (DateTimeException e) {  //in case dates entered is not valid dates, put in today's for now
			ld = LocalDate.now();
		}
		
		String[] allGames = request.getParameterValues("allGames");
		List<Games> selectedGamesInList = new ArrayList<Games>();
		if (allGames != null && allGames.length > 0) {
			for(int i=0; i<allGames.length; i++) {
				Games g = gh.searchGameByID(Integer.parseInt(allGames[i]));
				selectedGamesInList.add(g);
			}
		}
		
		Families newFamily = new Families(family);
		GameNight newGameNight = new GameNight(theme, ld, newFamily);
		newGameNight.setListOfGames(selectedGamesInList);
		gnh.insertNewGameNight(newGameNight);
		
		getServletContext().getRequestDispatcher("/viewAllGameNightsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
