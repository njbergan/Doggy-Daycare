package doggyDaycare.doggyDaycare;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AggressionDao {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Doggy-Daycare");
	
	public void cleanUp()
	{
		emfactory.close();
	}
	
	public void insertAggression(Aggression aggReport) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(aggReport);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateAggression(Aggression aggToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(aggToEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Aggression> getTodaysAggressions() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Aggression> typedQuery = em.createQuery("select * from agression where "
				+ "Incident_Date = CAST(CURRENT_TIMESTAMP as DATE)", Aggression.class);
		List<Aggression> todaysAggressions = typedQuery.getResultList();
		return todaysAggressions;		
	}
	
	public List<Aggression> getAllAggressions() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Aggression> typedQuery = em.createQuery("select * from agression", Aggression.class);
		List<Aggression> allAggressions = typedQuery.getResultList();
		return allAggressions;
	}
}
