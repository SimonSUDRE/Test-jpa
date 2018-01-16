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

import banque.entity2.Adresse;
import banque.entity2.AssuranceVie;
import banque.entity2.Banque;
import banque.entity2.Client;
import banque.entity2.LivretA;
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
		
		LivretA la = new LivretA();
		la.setNumero(124578963);
		la.setSolde(125478963.12);
		la.setTaux(10.24);
		
		la.getClients().add(c);
		c.getComptes().add(la);
		
		AssuranceVie av = new AssuranceVie();
		av.setNumero(124578963);
		av.setSolde(125478963.12);
		av.setDateFin(LocalDate.of(2016, 3, 18));
		av.setTaux(5.34);
		
		av.getClients().add(c);
		c.getComptes().add(av);
		
		Virement o = new Virement();
		o.setDate(LocalDateTime.of(LocalDate.of(2015, 11, 22), LocalTime.of(11, 30, 38)));
		o.setMotif("donation");
		o.setMontant(150.21);	
		o.setBeneficiaire("Charles HENRY");

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
		
		em.persist(c);
		em.persist(b);
		em.persist(la);
		em.persist(av);
		em.persist(o);
		em.persist(v);
		
		transaction.commit();
		
		c = em.find(Client.class, 1);
		b = em.find(Banque.class, 1);
		la = em.find(LivretA.class, 1);
		av = em.find(AssuranceVie.class, 1);
		o = em.find(Virement.class, 1);
		v = em.find(Virement.class, 1);
		
		LOG.info(c.toString());
		LOG.info(c.getAdresse().toString());
		LOG.info(b.toString());
		LOG.info(la.toString());
		LOG.info(av.toString());
		LOG.info(o.toString());
		LOG.info(v.toString());
		
		em.close();
		emf.close();
	}
}