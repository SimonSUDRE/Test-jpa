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
public class TestJpa1 {

	/** LOG : Logger */
	private static Logger LOG = LoggerFactory.getLogger(TestJpa.class);
	
	/**
	 * methode execution
	 * @param args pas utiliser
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();
	}
}