package controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Dog;

public class DogDao {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Doggy-Daycare");

	public void cleanUp() {
		emfactory.close();
	}

	public void insertDog(Dog doge) {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(doge);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			System.out.println("Exception in insertDog method: Entity already exists.");
		} finally {
			em.close();
		}
	}

	public Dog searchForDogById(int tempId) {
		Dog found = new Dog();
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			found = em.find(Dog.class, tempId);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception in searchForDogById: " + e);
		} finally {
			em.close();
		}
		return found;
	}

	public void updateDog(Dog dogToEdit) {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();

			em.merge(dogToEdit);
			em.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println("Exeption found in updateDog: " + e);
		} finally {
			em.close();
		}
	}

	public List<Dog> viewAllDogs() {
		List<Dog> allDogs = null;
		EntityManager em = emfactory.createEntityManager();
		try {
			TypedQuery<Dog> typedQuery = em.createQuery("select doge from Dog doge", Dog.class);
			allDogs = typedQuery.getResultList();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in viewAllDogs: " + e);
		} finally {
			em.close();
		}
		return allDogs;
	}

	public List<Dog> viewOnlyActive() {
		List<Dog> activeDogs = null;
		EntityManager em = emfactory.createEntityManager();
		try {
			TypedQuery<Dog> typedQuery = em.createQuery("select doge from Dog doge where Active_Flag = true",
					Dog.class);
			activeDogs = typedQuery.getResultList();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in DogDao viewOnlyActive: " + e);
		} finally {
			em.close();
		}
		return activeDogs;
	}
	
	public List<Dog> viewDogsCheckedInToday() {
		List<Dog> checkedInDogs = null;
		EntityManager em = emfactory.createEntityManager();
		try {
			TypedQuery<Dog> typedQuery = em.createQuery("select doge from Dog doge where Last_Visit = now()",
					Dog.class);
			checkedInDogs = typedQuery.getResultList();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in viewDogsCheckedInToday: " + e);
		} finally {
			em.close();
		}
		return checkedInDogs;
	}
	
	public List<Dog> viewDogsNotCheckedInThirtyDays() {
		List<Dog> dogsGreaterThan30Days = null;
		EntityManager em = emfactory.createEntityManager();
		try {
			TypedQuery<Dog> typedQuery = em.createQuery("select doge from Dog doge where Last_Visit >= "
					+ "(select date_add(now(), interval -30 day))", Dog.class);
			dogsGreaterThan30Days = typedQuery.getResultList();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in viewDogsNotCheckedInThirtyDays: " + e);
		} finally {
			em.close();
		}
		return dogsGreaterThan30Days;
	}

	public void removePlaygroundId() {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("UPDATE Dog SET Todays_Playground = null");
			em.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in removePlaygroundId: " + e);
		} finally {
			em.close();
		}
	}

	public void removeClassId() {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("UPDATE Dog SET Todays_Classes = null");
			em.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in removeClassId: " + e);
		} finally {
			em.close();
		}
	}

	public void addDogToClass(Dog doge, int classId) {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			doge.setTodaysClasses(classId);
			em.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in addDogToClass: " + e);
		} finally {
			em.close();
		}
	}

	public void addDogToPlayground(Dog doge, int playgroundId) {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			doge.setTodaysClasses(playgroundId);
			em.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in addDogToPlayground: " + e);
		} finally {
			em.close();
		}
	}

}