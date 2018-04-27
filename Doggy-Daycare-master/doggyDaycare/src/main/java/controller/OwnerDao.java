package controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;

public class OwnerDao {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Doggy-Daycare");

	public void cleanUp() {
		emfactory.close();
	}

	public void insertOwner(Owner owner) {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(owner);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			System.out.println("Exception in insertOwner method: Entity already exists.");
		} finally {
			em.close();
		}
	}

	public Owner searchForOwnerById(int tempId) {
		Owner found = new Owner();
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			found = em.find(Owner.class, tempId);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception in searchForOwnerById: " + e);
		} finally {
			em.close();
		}
		return found;
	}

	public void updateOwner(Owner dogToEdit) {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();

			em.merge(dogToEdit);
			em.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println("Exeption found in updateOwner: " + e);
		} finally {
			em.close();
		}
	}

	public List<Owner> viewAllOwners() {
		List<Owner> allOwners = null;
		EntityManager em = emfactory.createEntityManager();
		try {
			TypedQuery<Owner> typedQuery = em.createQuery("select owner from Owner owner", Owner.class);
			allOwners = typedQuery.getResultList();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in viewAllOwners: " + e);
		} finally {
			em.close();
		}
		return allOwners;
	}

}