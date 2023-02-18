package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameNight;
import model.Games;

/**
 * Servlet implementation class ViewAllGameNightsServlet
 */
@WebServlet("/viewAllGameNightsServlet")
public class ViewAllGameNightsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllGameNightsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameNightHelper gnh = new GameNightHelper();
		GamesHelper gh = new GamesHelper();
		
		List<GameNight> gameNights = gnh.getGameNights();
		List<Games> games = gh.showAllGames();
		
		request.setAttribute("allGameNights", gameNights);
		request.setAttribute("allGames", games);
		
		String path = "/view-game-nights.jsp";
		
		if(gameNights.isEmpty()) {  // if no game nights exist to view, go to add game night screen
			if(games.isEmpty() ) {	// if no games exist to view, go to add game screen
				request.setAttribute("allGames", " ");
				path = "/index.html";
			} else {
				request.setAttribute("allGameNights", " ");
				path = "/add-game-night.jsp";
			}
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
