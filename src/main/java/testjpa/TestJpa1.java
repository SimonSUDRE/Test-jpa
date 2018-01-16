package testjpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import banque.entity.Adresse;
import banque.entity.Banque;
import banque.entity.Client;
import banque.entity.Compte;
import banque.entity.Operation;

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
		Client c = new Client();
		c.setDateDeNaissance(LocalDate.of(1991, 10, 15));
		c.setNom("Jean");
		c.setPrenom("PIERRE");
		
		Adresse a = new Adresse();
		a.setCodePostal(44200);
		a.setNumero(56);
		a.setRue("place du commerces");
		a.setVille("Nantes");

		c.setAdresse(a);
		
		Banque b = new Banque();
		b.setNom("Credit mutuels");
		
		b.getClients().add(c);
		c.setBanque(b);
		
		Compte comp = new Compte();
		comp.setNumero(1245463);
		comp.setSolde(12455.12);
		
		comp.getClients().add(c);
		c.getComptes().add(comp);
		
		Operation o = new Operation();
		o.setDate(LocalDateTime.of(LocalDate.of(2005, 11, 22), LocalTime.of(12, 30, 38)));
		o.setMotif("retraits");
		o.setMontant(1500.21);			

		o.setCompte(comp);
		comp.getOperations().add(o);	
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(c);
		em.persist(b);
		em.persist(comp);
		em.persist(o);
		
		transaction.commit();
		
		LOG.info("");
		
		c = em.find(Client.class, 1);
		LOG.info(c.toString());
		LOG.info(c.getAdresse().toString());
		
		b = em.find(Banque.class, 1);
		LOG.info(b.toString());
		
		comp = em.find(Compte.class, 1);
		LOG.info(comp.toString());
		
		o = em.find(Operation.class, 1);
		LOG.info(o.toString());
		
		em.close();
		emf.close();
	}
}