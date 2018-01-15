package banque.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Simon SUDRE
 * class Banque
 */
@Entity
@Table(name="BANQUE")
public class Banque {
	
	/** nom : {@link String} */
	@Column(name="NOM", length=50)
	private String nom;
	
	/** clients : {@link Set}<{@link Client}> */
	@OneToMany(mappedBy="banque")
	private Set<Client> clients;
	
	/**
	 * Constructeur par default
	 */
	public Banque() {
		this.clients = new HashSet<>();
	}

	/**
	 * GET nom of Banque
	 * @return {@link String} nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * SET nom of Banque
	 * @param nom {@link String}
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * GET clients of Banque
	 * @return {@link Set}<{@link Client}> clients
	 */
	public Set<Client> getLivres() {
		return this.clients;
	}

	/**
	 * SET clients of Banque
	 * @param clients {@link Set}<{@link Client}>
	 */
	public void setLivres(Set<Client> clients) {
		this.clients = clients;
	}
}
