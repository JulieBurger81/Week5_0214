/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Feb 15, 2023
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GameNight")
public class GameNight {
	@Id
	@GeneratedValue
	private int id;
	private String theme;
	private LocalDate night;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Families family;
	@OneToMany (cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Games> listOfGames;
	/**
	 * 
	 */
	public GameNight() {
		super();
	}
	/**
	 * @param id
	 * @param theme
	 * @param night
	 * @param family
	 * @param listOfGames
	 */
	public GameNight(int id, String theme, LocalDate night, Families family, List<Games> listOfGames) {
		super();
		setId(id);
		setTheme(theme);
		setNight(night);
		setFamily(family);
		setListOfGames(listOfGames);
	}
	/**
	 * @param theme
	 * @param night
	 * @param family
	 * @param listOfGames
	 */
	public GameNight(String theme, LocalDate night, Families family, List<Games> listOfGames) {
		super();
		setTheme(theme);
		setNight(night);
		setFamily(family);
		setListOfGames(listOfGames);
	}
	/**
	 * @param theme
	 * @param night
	 * @param family
	 */
	public GameNight(String theme, LocalDate night, Families family) {
		super();
		setTheme(theme);
		setNight(night);
		setFamily(family);
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}
	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}
	/**
	 * @return the night
	 */
	public LocalDate getNight() {
		return night;
	}
	/**
	 * @param night the night to set
	 */
	public void setNight(LocalDate night) {
		this.night = night;
	}
	/**
	 * @return the family
	 */
	public Families getFamily() {
		return family;
	}
	/**
	 * @param family the family to set
	 */
	public void setFamily(Families family) {
		this.family = family;
	}
	/**
	 * @return the listOfGames
	 */
	public List<Games> getListOfGames() {
		return listOfGames;
	}
	/**
	 * @param listOfGames the listOfGames to set
	 */
	public void setListOfGames(List<Games> listOfGames) {
		this.listOfGames = listOfGames;
	}
	@Override
	public String toString() {
		return "GameNight [id=" + id + ", theme=" + theme + ", night=" + night + ", family=" + family + ", listOfGames="
				+ listOfGames + "]";
	}
	
	
	
}
