package doggyDaycare.doggyDaycare;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class OwnerDao {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Doggy-Daycare");
	
	public void cleanUp()
	{
		emfactory.close();
	}
	
	public void insertOwner(Owner owner) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(owner);
		em.getTransaction().commit();
		em.close();
	}

	public Owner searchForOwnerById(int tempId) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Owner found = em.find(Owner.class, tempId);
		em.close();
		return found;
	}

	public void updateOwner(Owner dogToEdit) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(dogToEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Owner> viewAllOwners() 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Owner> typedQuery = em.createQuery("select owner from Owner owner", Owner.class);
		List<Owner> allOwners = typedQuery.getResultList();
		em.close();
		return allOwners;
	}

}
