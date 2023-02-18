import java.util.List;

import controller.FamiliesHelper;
import model.Families;

/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Feb 15, 2023
 */

public class FamliesTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Families sister1 = new Families("Sister Angie");
		Families brother1 = new Families("Brother Eric");
		Families brother2 = new Families("Brother Craig");
		
		FamiliesHelper fh = new FamiliesHelper();
		
		fh.insertFamilies(sister1);
		fh.insertFamilies(brother1);
		fh.insertFamilies(brother2);
		
		List<Families> allFamilies = fh.showAllFamilies();
		for(Families family : allFamilies) {
			System.out.println(family.toString());
		}
		

	}

}
