package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Classes;
import model.Dog;

public class ClassesDao {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Doggy-Daycare");
	
	public void cleanUp()
	{
		emfactory.close();
	}
	
	public List<Classes> getAllClasses() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Classes> typedQuery = em.createQuery("SELECT * FROM classes", Classes.class);
		List<Classes> allClasses = typedQuery.getResultList();
		return allClasses;
	}
	
	public void addDogToClass(Dog doge, int classId) {
		doge.setTodaysClasses(classId);
	}

}
