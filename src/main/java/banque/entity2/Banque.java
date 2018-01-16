package banque.entity2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Simon SUDRE
 * class Banque
 */
@Entity
public class Banque {
	
	/** id : {@link Integer} */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/** nom : {@link String} */
	@Column(name="NOM", length=50, nullable=false)
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
	 * GET id of Client
	 * @return {@link Integer} id
	 */
	public Integer getId() {
		return id;
	}

	/** 
	 * SET id of Client
	 * @param id {@link Integer}
	 */
	public void setId(Integer id) {
		this.id = id;
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
	public Set<Client> getClients() {
		return this.clients;
	}

	/**
	 * SET clients of Banque
	 * @param clients {@link Set}<{@link Client}>
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + "]";
	}
}
