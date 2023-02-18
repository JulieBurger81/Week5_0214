/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Feb 15, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GameNight;
import model.Games;

public class GameNightHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebGames");
	
	public void insertNewGameNight(GameNight gn) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(gn);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<GameNight> getGameNights() {
		EntityManager em = emfactory.createEntityManager();
		List<GameNight> allDetails = em.createQuery("SELECT gn FROM GameNight gn").getResultList();
		return allDetails;
	}

	/**
	 * @param tempId
	 * @return
	 */
	public GameNight searchGameNightByID(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		GameNight foundGameNight = em.find(GameNight.class, tempId);

		em.close();
		return foundGameNight;
	}

	/**
	 * @param gameToDelete
	 */
	public void deleteGameNight(GameNight gameToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<GameNight> typedQuery = em.createQuery("SELECT d FROM GameNight d where d.id = :selectedId", GameNight.class);
		
		//Substitue parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", gameToDelete.getId());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		GameNight result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param gameNightToUpdate
	 */
	public void updateGameNight(GameNight gameNightToUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(gameNightToUpdate);
		em.getTransaction().commit();
		em.close();
	}
}
