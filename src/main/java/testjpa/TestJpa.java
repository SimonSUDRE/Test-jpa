package testjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.slf4j.LoggerFactory;
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("essai");
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close(); 
		LOG.info("");
	}

}