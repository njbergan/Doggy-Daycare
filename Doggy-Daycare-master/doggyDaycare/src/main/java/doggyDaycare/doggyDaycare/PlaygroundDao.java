package doggyDaycare.doggyDaycare;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PlaygroundDao {


	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Doggy-Daycare");
		
	public void cleanUp()
	{
		emfactory.close();
	}
		
	public void insertPlayground(Playground playgr) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(playgr);
		em.getTransaction().commit();
		em.close();
	}
	
	public Playground searchForPlaygroundById(Integer tempId) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Playground found = em.find(Playground.class, tempId);
		em.close();
		return found;
	}
	
	public void updatPlayground(Playground playgroundToEdit) 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(playgroundToEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Playground> viewAllDogs() 
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Playground> typedQuery = em.createQuery("select doge from Dog doge", Playground.class);
		List<Playground> allPlaygrounds = typedQuery.getResultList();
		em.close();
		return allPlaygrounds;
	}
	
}
