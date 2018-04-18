package doggyDaycare.doggyDaycare;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DogDao {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Doggy-Daycare");
	
	public void cleanUp()
	{
		emfactory.close();
	}
	
	public void insertDog(Dog doge) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(doge);
		em.getTransaction().commit();
		em.close();
	}

	public Dog searchForDogById(int tempId) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Dog found = em.find(Dog.class, tempId);
		em.close();
		return found;
	}

	public void updateDog(Dog dogToEdit) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(dogToEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Dog> viewAllDogs() 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Dog> typedQuery = em.createQuery("select doge from Dog doge", Dog.class);
		List<Dog> allDogs = typedQuery.getResultList();
		em.close();
		return allDogs;
	}

	public List<Dog> viewOnlyActive() 
	{
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Dog> typedQuery = em.createQuery("select doge from Dog doge where Active_Flag = true", Dog.class);
		List<Dog> activeDogs = typedQuery.getResultList();
		return activeDogs;
	}

}
