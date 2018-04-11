package doggyDaycare.doggyDaycare;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		return null;
	}

	public void updateOwner(Owner ownerToUpdate) 
	{
		// TODO Auto-generated method stub
		
	}

	public List<Owner> viewAllOwners() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
