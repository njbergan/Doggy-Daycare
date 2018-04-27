package controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Classes;
import model.Dog;
import model.Playground;

public class ClassesDao {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Doggy-Daycare");

	public void cleanUp() {
		emfactory.close();
	}

	public void insertClasses(Classes classes) {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(classes);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			System.out.println("Exception in insertClasses method: Entity already exists.");
		} finally {
			em.close();
		}
	}

	public void updateClasses(Classes classes) {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();

			em.merge(classes);
			em.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println("Exeption found in updateClasses: " + e);
		} finally {
			em.close();
		}
	}

	public List<Classes> getAllClasses() {
		List<Classes> allClasses = null;
		EntityManager em = emfactory.createEntityManager();
		try {
			TypedQuery<Classes> typedQuery = em.createQuery("SELECT * FROM classes", Classes.class);
			allClasses = typedQuery.getResultList();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in removeClassId: " + e);
		} finally {
			em.close();
		}
		return allClasses;
	}
}