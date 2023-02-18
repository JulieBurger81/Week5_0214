import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.FamiliesHelper;
import controller.GameNightHelper;
import model.Families;
import model.GameNight;
import model.Games;

/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Feb 15, 2023
 */

public class GameNightTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Families father = new Families("Dad");
		FamiliesHelper fh = new FamiliesHelper();
//		fh.insertFamilies(father);
		
		Games pictionary = new Games("Pictionary", "Drawing", 8);
		Games war = new Games("War", "Cards", 2);
		
		List<Games> fatherGames = new ArrayList<Games>();
		fatherGames.add(pictionary);
		fatherGames.add(war);
		
		GameNight dadsNight = new GameNight("Dad's night", LocalDate.now(), father);
		dadsNight.setListOfGames(fatherGames);
		
		GameNightHelper gnh = new GameNightHelper();
		gnh.insertNewGameNight(dadsNight);
		
		List<GameNight> allDetails = gnh.getGameNights();
		
		for(GameNight night: allDetails) {
			System.out.println(night.toString());
		}
		

	}

}
