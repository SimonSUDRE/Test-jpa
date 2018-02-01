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
	private static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);
	
	/**
	 * methode execution
	 * @param args pas utiliser
	 */
	public static void main(String[] args) {
		String s = "";
		
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
			s = c.toString();
			LOG.info(s);
			for(Compte co : c.getComptes()) {
				s = co.toString();
				LOG.info(s);
			}
			s = c.getBanque().toString();
			LOG.info(s);
			
			LOG.info("");
			
			b = em.find(Banque.class, 1);
			s = b.toString();
			LOG.info(s);
			for(Client cl : b.getClients()) {
				s = cl.toString();
				LOG.info(s);
			}
			
			LOG.info("");
			
			comp = em.find(Compte.class, 1);
			s = comp.toString();
			LOG.info(s);
			for(Client cl : comp.getClients()) {
				s = cl.toString();
				LOG.info(s);
			}
			for(Operation op : comp.getOperations()) {
				s = op.toString();
				LOG.info(s);
			}

			LOG.info("");
			
			la = em.find(LivretA.class, 2);
			s = la.toString();
			LOG.info(s);
			for(Client cl : la.getClients()) {
				s = cl.toString();
				LOG.info(s);
			}
			for(Operation op : la.getOperations()) {
				s = op.toString();
				LOG.info(s);
			}
			
			LOG.info("");
			
			av = em.find(AssuranceVie.class, 3);
			s = av.toString();
			LOG.info(s);
			for(Client cl : av.getClients()) {
				s = cl.toString();
				LOG.info(s);
			}
			for(Operation op : av.getOperations()) {
				s = op.toString();
				LOG.info(s);
			}
			
			LOG.info("");
			
			o = em.find(Operation.class, 1);
			s = o.toString();
			LOG.info(s);
			s = o.getCompte().toString();
			LOG.info(s);
			
			LOG.info("");
			
			v = em.find(Virement.class, 2);
			s = v.toString();
			LOG.info(s);
			s = v.getCompte().toString();
			LOG.info(s);
			
			em.close();
		}
		catch(HibernateException he) {
			if(transaction.isActive()) {
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