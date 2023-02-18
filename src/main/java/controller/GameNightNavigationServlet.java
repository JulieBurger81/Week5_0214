package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameNight;

/**
 * Servlet implementation class GameNightNavigationServlet
 */
@WebServlet("/gameNightNavigationServlet")
public class GameNightNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameNightNavigationServlet() {
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
		
		String act = request.getParameter("doThisToGame");
		
		//default to viewAllGamesNights servlet unless to add or edit
		String path = "/viewAllGameNightsServlet";
		if (act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				GameNight gameNightToDelete = gnh.searchGameNightByID(tempId);
				gnh.deleteGameNight(gameNightToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a game night");
			}
		} else if (act.equals("Edit")) {
			try {
				Integer tempID = Integer.parseInt(request.getParameter("id"));
				GameNight gameNightToEdit = gnh.searchGameNightByID(tempID);
				request.setAttribute("gameNightToEdit", gameNightToEdit);
				
				request.setAttribute("month", gameNightToEdit.getNight().getMonthValue());
				request.setAttribute("date", gameNightToEdit.getNight().getDayOfMonth());
				request.setAttribute("year", gameNightToEdit.getNight().getYear());
				
				request.setAttribute("allGames", gh.showAllGames());
				
				if(gh.showAllGames().isEmpty()) {
					request.setAttribute("allGames", " ");
				}
				path = "/edit-game-night.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a game night");
			}
		} else if (act.equals("Add")) {
			request.setAttribute("allGames", gh.showAllGames());
			path = "/add-game-night.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request,response);
	}

}
