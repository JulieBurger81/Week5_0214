/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Feb 15, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Families;

public class FamiliesHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebGames");
	
	public void insertFamilies(Families f) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Families> showAllFamilies() {
		EntityManager em = emfactory.createEntityManager();
		List<Families> allFamilies = em.createQuery("SELECT f FROM families f").getResultList();
		return allFamilies;
	}

	/**
	 * @param family
	 * @return
	 */
	public Families findFamily(String familyToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Families> typedQuery = em.createQuery("SELECT f FROM Families f WHERE f.family = "
				+ ":selectedFamily", Families.class);
		//Substitue parameter with actual data from the familyToLookUp item
		typedQuery.setParameter("selectedFamily", familyToLookUp);
		typedQuery.setMaxResults(1);
		Families foundFamily;
		try {
			foundFamily = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundFamily = new Families(familyToLookUp);
		}
		em.close();
		System.out.println("FamiliesHelper: " + foundFamily);
		
		return foundFamily;
	}
}
