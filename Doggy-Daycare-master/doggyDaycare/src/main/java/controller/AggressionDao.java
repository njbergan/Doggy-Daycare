package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Aggression;
import model.Aggressor;
import model.Dog;
import model.Victim;

public class AggressionDao {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Doggy-Daycare");

	public void cleanUp() {
		emfactory.close();
	}

	public void insertAggression(Aggression aggReport) {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(aggReport);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			System.out.println("Exception in insertAggression method: Entity already exists.");
		} finally {
			em.close();
		}
	}

	public void updateAggression(Aggression aggToEdit) {
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();

			em.merge(aggToEdit);
			em.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println("Exeption found in updateAggression: " + e);
		} finally {
			em.close();
		}
	}

	public List<Aggression> getTodaysAggressions() {
		EntityManager em = emfactory.createEntityManager();
		List<Aggression> todaysAggressions = null;
		try {
			TypedQuery<Aggression> typedQuery = em.createQuery(
					"select * from agression where " + "Incident_Date = CAST(CURRENT_TIMESTAMP as DATE)",
					Aggression.class);
			todaysAggressions = typedQuery.getResultList();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in getTodaysAggressions: " + e);
		} finally {
			em.close();
		}
		return todaysAggressions;
	}

	public List<Aggression> getAllAggressions() {
		EntityManager em = emfactory.createEntityManager();
		List<Aggression> allAggressions = null;
		try {
			TypedQuery<Aggression> typedQuery = em.createQuery("select * from agression", Aggression.class);
			allAggressions = typedQuery.getResultList();
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in getAllAggressions: " + e);
		} finally {
			em.close();
		}
		return allAggressions;
	}

	public Map<Aggressor, List<Victim>> getAllVictimsBasedOnAggressors() {
		EntityManager em = emfactory.createEntityManager();
		Map<Aggressor, List<Victim>> victimMap = new HashMap<>();
		try {
			TypedQuery<Aggressor> typedQuery = em.createQuery("select rowdy from Aggressor rowdy", Aggressor.class);
			List<Aggressor> numOfAggressors = typedQuery.getResultList();
			for (int i = 0; i < numOfAggressors.size(); i++) {
				TypedQuery<Victim> victimQuery = em.createQuery(
						"select maimed from Victim maimed join fetch maimed.incidents attacker where attacker.aggressor = :selectedAggressorId",
						Victim.class);
				typedQuery.setParameter("selectedAggressorId", numOfAggressors.get(i).getAggressorId());
				victimMap.put(numOfAggressors.get(i), victimQuery.getResultList());
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in getAllVictimsBasedOnAggressors: " + e);
		} finally {
			em.close();
		}
		return victimMap;
	}

	public List<Dog> getAggressiveDogs() {
		EntityManager em = emfactory.createEntityManager();
		List<Dog> mongrels = new ArrayList<Dog>();
		try {
			Map<Aggressor, List<Victim>> victimMap = getAllVictimsBasedOnAggressors();
			List<Aggressor> aggressors = new ArrayList<>(victimMap.keySet());
			for (int i = 0; i < aggressors.size(); i++) {
				TypedQuery<Dog> typedQuery = em.createQuery("select bad from Dog bad where bad.dogId = :selectedDogId",
						Dog.class);
				typedQuery.setParameter("selectedDogId", aggressors.get(i).getDogId());
				Dog naughtyDog = typedQuery.getSingleResult();
				mongrels.add(naughtyDog);
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in getAggressiveDogs: " + e);
		} finally {
			em.close();
		}
		return mongrels;
	}

	public List<Dog> getVictimsList(Aggressor naughtyDog) {
		EntityManager em = emfactory.createEntityManager();
		List<Dog> doggos = new ArrayList<Dog>();
		try {
			Map<Aggressor, List<Victim>> victimMap = getAllVictimsBasedOnAggressors();
			for (Map.Entry<Aggressor, List<Victim>> entry : victimMap.entrySet()) {
				if (entry.getKey().equals(naughtyDog)) {
					List<Victim> downDogs = entry.getValue();
					for (int i = 0; i < downDogs.size(); i++) {
						TypedQuery<Dog> typedQuery = em.createQuery(
								"select pupper from Dog pupper where pupper.dogId = :selectedDogId", Dog.class);
						typedQuery.setParameter("selectedDogId", downDogs.get(i).getDogId());
						Dog doggo = typedQuery.getSingleResult();
						doggos.add(doggo);
					}
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Exception found in getAggressiveDogs: " + e);
		} finally {
			em.close();
		}
		return doggos;
	}

	public Aggression searchForAggressionById(int tempId) {
		Aggression found = new Aggression();
		EntityManager em = emfactory.createEntityManager();
		try {
			em.getTransaction().begin();
			found = em.find(Aggression.class, tempId);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception in searchForAggressionById: " + e);
		} finally {
			em.close();
		}
		return found;
	}
}