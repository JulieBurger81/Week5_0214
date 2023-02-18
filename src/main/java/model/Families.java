/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Feb 15, 2023
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="families")
public class Families {
	@Id
	@GeneratedValue
	private int id;
	private String family;
	/**
	 * 
	 */
	public Families() {
		super();
	}
	/**
	 * @param id
	 * @param family
	 */
	public Families(int id, String family) {
		super();
		setId(id);
		setFamily(family);
	}
	/**
	 * @param family
	 */
	public Families(String family) {
		super();
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
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}
	/**
	 * @param family the family to set
	 */
	public void setFamily(String family) {
		this.family = family;
	}
	@Override
	public String toString() {
		return "Families [id=" + id + ", family=" + family + "]";
	}
	
}
