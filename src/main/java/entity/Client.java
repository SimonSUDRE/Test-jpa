package entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Simon SUDRE
 * class Client
 */
@Entity
@Table(name="CLIENT")
public class Client {

	/** id : {@link Integer} */
	@Id
	@GeneratedValue
	private Integer id;
	
	/** nom : {@link String} */
	@Column(name="NOM", length=50, nullable=false)
	private String nom;
	
	/** prenom : {@link String} */
	@Column(name="PRENOM", length=50, nullable=false)
	private String prenom;
	
	/** emprunts : {@link Set}<{@link Emprunt}> */
	@OneToMany(mappedBy="client")
	private Set<Emprunt> empruntsClient;
	
	/**
	 * constructeur par default
	 */
	public Client() {
		this.empruntsClient = new HashSet<>();
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
	 * GET nom of Client
	 * @return {@link String} nom
	 */
	public String getNom() {
		return nom;
	}

	/** 
	 * SET nom of Client
	 * @param nom {@link String}
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * GET prenom of Client
	 * @return {@link String} prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** 
	 * SET prenom of Client
	 * @param prenom {@link String}
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * GET empruntsClient of Client
	 * @return {@link Set}<{@link Emprunt}> empruntsClient
	 */
	public Set<Emprunt> getLivres() {
		return this.empruntsClient;
	}

	/**
	 * SET empruntsClient of Client
	 * @param empruntsClient {@link Set}<{@link Emprunt}>
	 */
	public void setEmprunt(Set<Emprunt> empruntsClient) {
		this.empruntsClient = empruntsClient;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
}
