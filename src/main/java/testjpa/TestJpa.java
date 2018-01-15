package testjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.slf4j.LoggerFactory;
import entity.Emprunt;
import entity.Livre;
import org.slf4j.Logger;

/**
 * @author Simon SUDRE
 * class TestJPA
 */
public class TestJpa {

	/** LOG : Logger */
	private static Logger LOG = LoggerFactory.getLogger(TestJpa.class);
	
	/**
	 * methode execution
	 * @param args pas utiliser
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");
		EntityManager em = emf.createEntityManager();
		
		Livre l = em.find(Livre.class, 1);
		LOG.info(l.toString()+"\n");
		
		TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre='Germinal'", Livre.class);
		LOG.info(query.getResultList().get(0).toString()+"\n");
		
		TypedQuery<Livre> query1 = em.createQuery("select l from Emprunt e, Livre l where e.id=1", Livre.class);
		for(Livre livre :query1.getResultList()) {
			LOG.info(livre.toString());
		}
		LOG.info("");
		
		TypedQuery<Emprunt> query2 = em.createQuery("select e from Emprunt e where e.client.id=1", Emprunt.class);
		for(Emprunt emprunt : query2.getResultList()) {
			LOG.info(emprunt.toString());
		}
		LOG.info("");
		
		em.close();
		emf.close();
	}
}