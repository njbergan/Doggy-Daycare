package controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Playground;

public class PlaygroundDao {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Doggy-Daycare");

	public void cleanUp() {
		emfactory.close();
	}

	public void insertPlayground(Playground playgr) {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(playgr);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			System.out.println("Exception in insertPlayground method: Entity already exists.");
		} finally {
			em.close();
		}
	}

	public Playground searchForPlaygroundById(int tempId) {
		Playground found = new Playground();
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			found = em.find(Playground.class, tempId);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception in searchForPlaygroundById: " + e);
		} finally {
			em.close();
		}
		return found;
	}

	public void updatePlayground(Playground playgroundToEdit) {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();

			em.merge(playgroundToEdit);
			em.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println("Exeption found in updatePlayground: " + e);
		} finally {
			em.close();
		}
	}

	public List<Playground> viewAllPlaygrounds() {
		EntityManager em = emfactory.createEntityManager();
		List<Playground> allPlaygrounds = null;
		try {
			TypedQuery<Playground> typedQuery = em.createQuery("select playground from Playground playground",
					Playground.class);
			allPlaygrounds = typedQuery.getResultList();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in viewAllPlaygrounds: " + e);
		} finally {
			em.close();
		}
		return allPlaygrounds;
	}

}