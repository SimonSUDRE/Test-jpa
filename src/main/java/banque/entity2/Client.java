package banque.entity2;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Simon SUDRE
 * class Client
 */
@Entity
public class Client {

	/** id : {@link Integer} */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/** nom : {@link String} */
	@Column(name="NOM", length=50, nullable=false)
	private String nom;
	
	/** prenom : {@link String} */
	@Column(name="PRENOM", length=50, nullable=false)
	private String prenom;

	/** dateDeNaissance : {@link LocalDate} */
	@Column(name="DATE_DE_NAISSANCE", nullable=false)
	private LocalDate dateDeNaissance;
	
	/** adresse : {@link Adresse}*/
	@Embedded
	private Adresse adresse;
	
	/** banque : {@link Banque}*/
	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private Banque banque;
	
	/** comptes : {@link Set}<{@link Compte}>*/
	@ManyToMany
	@JoinTable(name="COMPO",
		joinColumns= @JoinColumn(name="ID_CLIENT", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_COMPTE", referencedColumnName="ID")
	)
	private Set<Compte> comptes;
	
	/**
	 * constructeur par default
	 */
	public Client() {
		this.comptes = new HashSet<>();
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
	 * GET dateDeNaissance of Client
	 * @return {@link LocalDate} dateDeNaissance
	 */
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * SET dateDeNaissance of Client
	 * @param dateDeNaissance {@link LocalDate}
	 */
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/**
	 * GET adresse of Client
	 * @return {@link Adresse} adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * SET adresse of Client
	 * @param adresse {@link Adresse}
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * GET banque of Client
	 * @return {@link Banque} banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * SET banque of Client
	 * @param banque {@link Banque}
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**
	 * GET comptes of Client
	 * @return {@link Set}<{@link Compte}> comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
	}

	/**
	 * SET comptes of Client
	 * @param comptes {@link Set}<{@link Compte}>
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", ddn=" + dateDeNaissance + "]";
	}
}
