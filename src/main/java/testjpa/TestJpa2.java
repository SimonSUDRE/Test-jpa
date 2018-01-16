package testjpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import banque.entity2.Adresse;
import banque.entity2.AssuranceVie;
import banque.entity2.Banque;
import banque.entity2.Client;
import banque.entity2.Compte;
import banque.entity2.LivretA;
import banque.entity2.Operation;
import banque.entity2.Virement;

/**
 * @author Simon SUDRE
 * class TestJPA
 */
public class TestJpa2 {

	/** LOG : Logger */
	private static Logger LOG = LoggerFactory.getLogger(TestJpa.class);
	
	/**
	 * methode execution
	 * @param args pas utiliser
	 */
	public static void main(String[] args) {
		Client c = new Client();
		c.setDateDeNaissance(LocalDate.of(1990, 10, 15));
		c.setNom("Jean");
		c.setPrenom("PIERRE");
		
		Adresse a = new Adresse();
		a.setCodePostal(44200);
		a.setNumero(56);
		a.setRue("place du commerce");
		a.setVille("Nantes");

		c.setAdresse(a);
		
		Banque b = new Banque();
		b.setNom("Credit mutuel");
		
		b.getClients().add(c);
		c.setBanque(b);
		
		Compte comp = new Compte();
		comp.setNumero(124578963);
		comp.setSolde(125478963.12);
		
		comp.getClients().add(c);
		
		LivretA la = new LivretA();
		la.setNumero(124578963);
		la.setSolde(125478963.12);
		la.setTaux(10.24);
		
		c.getComptes().add(la);
		
		AssuranceVie av = new AssuranceVie();
		av.setNumero(124578963);
		av.setSolde(125478963.12);
		av.setDateFin(LocalDate.of(2016, 3, 18));
		av.setTaux(5.34);
		
		av.getClients().add(c);
		
		Operation o = new Operation();
		o.setDate(LocalDateTime.of(LocalDate.of(2015, 11, 22), LocalTime.of(11, 30, 38)));
		o.setMotif("donation");
		o.setMontant(150.21);

		o.setCompte(la);
		la.getOperations().add(o);
		
		Virement v = new Virement();
		v.setDate(LocalDateTime.of(LocalDate.of(2015, 11, 22), LocalTime.of(11, 30, 38)));
		v.setMotif("retrait");
		v.setMontant(150.21);
		v.setBeneficiaire("Zack XXX");
		
		v.setCompte(av);
		av.getOperations().add(v);	
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque2");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		try {			
			em.persist(c);
			em.persist(b);
			em.persist(comp);
			em.persist(la);
			em.persist(av);
			em.persist(o);
			em.persist(v);
			
			transaction.commit();
			em.close();
			em = emf.createEntityManager();
			
			LOG.info("");
			
			c = em.find(Client.class, 1);
			LOG.info(c.toString());
			for(Compte co : c.getComptes()) {
				LOG.info(co.toString());
			}
			LOG.info(c.getBanque().toString());
			
			LOG.info("");
			
			b = em.find(Banque.class, 1);
			LOG.info(b.toString());
			for(Client cl : b.getClients()) {
				LOG.info(cl.toString());
			}
			
			LOG.info("");
			
			comp = em.find(Compte.class, 1);
			LOG.info(comp.toString());
			for(Client cl : comp.getClients()) {
				LOG.info(cl.toString());
			}
			for(Operation op : comp.getOperations()) {
				LOG.info(op.toString());
			}

			LOG.info("");
			
			la = em.find(LivretA.class, 2);
			LOG.info(la.toString());
			for(Client cl : la.getClients()) {
				LOG.info(cl.toString());
			}
			for(Operation op : la.getOperations()) {
				LOG.info(op.toString());
			}
			
			LOG.info("");
			
			av = em.find(AssuranceVie.class, 3);
			LOG.info(av.toString());
			for(Client cl : av.getClients()) {
				LOG.info(cl.toString());
			}
			for(Operation op : av.getOperations()) {
				LOG.info(op.toString());
			}
			
			LOG.info("");
			
			o = em.find(Operation.class, 1);
			LOG.info(o.toString());
			LOG.info(o.getCompte().toString());
			
			LOG.info("");
			
			v = em.find(Virement.class, 2);
			LOG.info(v.toString());
			LOG.info(v.getCompte().toString());
			
			em.close();
		}
		catch(HibernateException he) {
			if(transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		finally {
			if(em != null && em.isOpen()) {
				em.close();
				emf.close();
			}
		}
		emf.close();
	}
}